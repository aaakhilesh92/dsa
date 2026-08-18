package other;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;
import java.util.Scanner;

public class problemC {
    private int size;
    private Point3D[] points;
    private Random rd;

    public static void main(String[] args) throws Exception {
        double minVolume = new problemC().calculateCylinderVolume();
        System.out.printf("%.8f%n", minVolume);
    }

    public problemC() {
        rd = new Random(1373);
    }

    private double multiplyDivideByPointSquare(Point3D pointA, Point3D pointB) {
        return pointA.multiplyWithPoint(pointB) / pointA.calculatePointSquare();
    }

    private double multiplyDivideByPointSqrt(Point3D pointA, Point3D pointB) {
        return pointA.multiplyWithPoint(pointB) / Math.sqrt(pointA.calculatePointSquare());
    }

    private Point3D scalePoint(Point3D pointA, Point3D pointB) {
        return pointA.scalePointByS(multiplyDivideByPointSquare(pointA, pointB));
    }


    private double calculatePointHeight(Point3D pointA) {
        double low = Long.MAX_VALUE;
        double high = Long.MIN_VALUE;

        for (Point3D point : points) {
            double val = multiplyDivideByPointSqrt(pointA, point);
            low = Math.min(low, val);
            high = Math.max(high, val);
        }
        return high - low;
    }

    private double calculatePointRadius(Point3D point) {
        Point3D orthogonalPoint = new Point3D(-point.y, -point.z, point.x);
        if (orthogonalPoint.equal(point)) {
            orthogonalPoint = new Point3D(point.y, -point.z, -point.x);
        }

        Point3D point1 = point.crossPoint(orthogonalPoint);
        Point3D point2 = point.crossPoint(point1);

        double halfPi = Math.PI / 2;
        if (!Utils.equals(halfPi, point.angleBetweenPoint(point1)) || !Utils.equals(halfPi, point.angleBetweenPoint(point2)) || !Utils.equals(halfPi, point1.angleBetweenPoint(point2))) {
            System.out.println("Error!!! Orthogonal basis not found");
        }

        Point2D[] arr2DPoint = new Point2D[size];
        for (int i = 0; i < size; i++) {
            Point3D delta = scalePoint(point, points[i]);
            Point3D p = points[i].subtractPoint(delta);

            double x = multiplyDivideByPointSqrt(point1, p);
            double y = multiplyDivideByPointSqrt(point2, p);
            arr2DPoint[i] = new Point2D(x, y);
        }

        for (int i = 1; i < size; i++) {
            int j = (int) (rd.nextDouble() * i);
            Point2D tmp = arr2DPoint[i];
            arr2DPoint[i] = arr2DPoint[j];
            arr2DPoint[j] = tmp;
        }

        CircleSearch circleSearch = new CircleSearch(arr2DPoint);
        Circle circle = circleSearch.createCircleTwoPoint();
        return circle.getRadius();
    }

    private double calculatePointVolume(Point3D point) {
        double radius = calculatePointRadius(point);
        double height = calculatePointHeight(point);

        return Math.PI * radius * radius * height;
    }

    public double calculateCylinderVolume() {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        points = new Point3D[size];
        for (int i = 0; i < size; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            points[i] = new Point3D(x, y, z);
        }

        double minVolume = Double.MAX_VALUE;
        Point3D[] normalTests = new ConvexShell(points).extractVectorsOfConvexShellFaces();

        for (Point3D point : normalTests) {
            minVolume = Math.min(minVolume, calculatePointVolume(point));
        }

        return minVolume;
    }
}

class ConvexShell {
    int size;
    Point3D[] points;
    int[][] edgeArr;

    ConvexShell(Point3D[] points) {
        this.points = points;
        size = points.length;
        edgeArr = new int[size][size];
    }

    Point3D[] extractVectorsOfConvexShellFaces() {
        Deque<Face> faceQueue = new ArrayDeque<>();
        Deque<Face> pendingQueue = new ArrayDeque<>();

        faceQueue.add(new Face(0, 1, 2));
        faceQueue.add(new Face(0, 2, 1));

        for (int m = 3; m < size; m++) {
            Point3D point3D = points[m];

            int steps = faceQueue.size();
            while (steps > 0) {
                Face face = faceQueue.poll();
                Point3D pointX = point3D.subtractPoint(points[face.spin[0]]);

                double multiplyResult = pointX.multiplyWithPoint(face.norm);
                if (multiplyResult > Utils.precision) {
                    int x = face.spin[0];
                    int y = face.spin[1];
                    int z = face.spin[2];

                    edgeArr[x][y]--;
                    edgeArr[y][z]--;
                    edgeArr[z][x]--;
                } else {
                    faceQueue.add(face);
                }
                steps--;
            }

            for (Face face : faceQueue) {
                for (int p = 0; p < 3; p++) {
                    int x = face.spin[(p + 1) % 3];
                    int y = face.spin[p];

                    if (edgeArr[x][y] == 0)
                        pendingQueue.add(new Face(x, y, m));
                }
            }
            faceQueue.addAll(pendingQueue);
            pendingQueue.clear();
        }

        Point3D[] vectorsOfConvexShellFaces = new Point3D[faceQueue.size()];
        int c = 0;
        for (Face face : faceQueue)
            vectorsOfConvexShellFaces[c++] = face.norm;
        return vectorsOfConvexShellFaces;
    }

    class Face {
        int[] spin;
        Point3D norm;

        Face(int i, int j, int k) {
            norm = points[j].subtractPoint(points[i]).crossPoint(points[k].subtractPoint(points[i]));
            spin = new int[]{i, j, k};

            edgeArr[i][j]++;
            edgeArr[j][k]++;
            edgeArr[k][i]++;
        }
    }
}

class Point3D {
    double x, y, z;

    Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    boolean equal(Point3D point) {
        return Utils.equals(x, point.x)
                && Utils.equals(y, point.y)
                && Utils.equals(z, point.z);
    }

    Point3D subtractPoint(Point3D point2) {
        return new Point3D(x - point2.x, y - point2.y, z - point2.z);
    }

    Point3D scalePointByS(double s) {
        return new Point3D(x * s, y * s, z * s);
    }

    double multiplyWithPoint(Point3D point2) {
        return x * point2.x + y * point2.y + z * point2.z;
    }

    Point3D crossPoint(Point3D point2) {
        double xn = y * point2.z - z * point2.y;
        double yn = z * point2.x - x * point2.z;
        double zn = x * point2.y - y * point2.x;
        return new Point3D(xn, yn, zn);
    }

    double calculatePointSquare() {
        return x * x + y * y + z * z;
    }

    double angleBetweenPoint(Point3D point2) {
        double magnitute1 = Math.sqrt(calculatePointSquare());
        double magnitute2 = Math.sqrt(point2.calculatePointSquare());
        if (magnitute1 < Utils.precision || magnitute2 < Utils.precision)
            return 0.0;
        double dt = multiplyWithPoint(point2);
        return Math.acos(dt / (magnitute1 * magnitute2));
    }
}

class CircleSearch {
    private int length;
    private Point2D[] points;

    CircleSearch(Point2D[] points) {
        length = points.length;
        this.points = new Point2D[length];

        for (int x = 0; x < length; x++) {
            this.points[x] = points[x];
        }
    }

    Circle createCircleTwoPoint() {
        Circle circle = null;
        for (int x = 0; x < length; x++) {
            Point2D point = points[x];
            if (circle == null || !circle.contains(point)) {
                circle = createCircleOnePoint(x + 1, point);
            }
        }
        return circle;
    }

    Circle createCircleOnePoint(int size, Point2D pointA) {
        Circle circle = new Circle(pointA, 0);
        for (int i = 0; i < size; i++) {
            Point2D pointB = points[i];
            if (!circle.contains(pointB)) {
                if (circle.getRadius() == 0) {
                    circle = createCircleTwoPoint(pointA, pointB);
                } else {
                    circle = createCircleTwoPoint(i + 1, pointA, pointB);
                }
            }
        }
        return circle;
    }

    Circle createCircleTwoPoint(int size, Point2D pointA, Point2D pointB) {
        Circle circle = createCircleTwoPoint(pointA, pointB);
        Circle leftCircle = null;
        Circle rightCircle = null;

        Point2D pq = pointB.subtract(pointA);
        for (int k = 0; k < size; k++) {
            Point2D r = points[k];
            if (circle.contains(r)) {
                continue;
            }

            double cross = pq.cross(r.subtract(pointA));
            Circle circumCircle = createCircumCircle(pointA, pointB, r);

            if (circumCircle == null) {
                continue;
            } else if (cross > 0 && (leftCircle == null || pq.cross(circumCircle.getCenter().subtract(pointA)) > pq.cross(leftCircle.getCenter().subtract(pointA)))) {
                leftCircle = circumCircle;
            } else if (cross < 0 && (rightCircle == null || pq.cross(circumCircle.getCenter().subtract(pointA)) < pq.cross(rightCircle.getCenter().subtract(pointA)))) {
                rightCircle = circumCircle;
            }
        }

        if (leftCircle == null && rightCircle == null) {
            return circle;
        } else if (leftCircle == null) {
            return rightCircle;
        } else if (rightCircle == null) {
            return leftCircle;
        } else {
            return leftCircle.getRadius() <= rightCircle.getRadius() ? leftCircle : rightCircle;
        }
    }

    Circle createCircleTwoPoint(Point2D a, Point2D b) {
        Point2D m = a.midpoint(b);
        return new Circle(m, a.distance(m));
    }

    Circle createCircumCircle(Point2D a, Point2D b, Point2D c) {
        Point2D p = Circle.getCenter(a, b, c);
        if (p == null)
            return null;
        return new Circle(p, p.distance(a));
    }
}

class Circle {
    private Point2D center;
    private double radius;

    Circle(Point2D center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    boolean contains(Point2D p) {
        return center.distance(p) <= radius + Utils.precision;
    }

    static Point2D getCenter(Point2D p1, Point2D p2, Point2D p3) {
        Point2D pointA1 = p1.midpoint(p2);
        Point2D pointA2 = p3.midpoint(p2);

        Point2D pointB1 = new Point2D(p2.y - p1.y, p1.x - p2.x);
        Point2D pointB2 = new Point2D(p2.y - p3.y, p3.x - p2.x);

        if (Utils.equals(pointB1.cross(pointB2), 0)) {
            return null;
        }

        Line L1 = new Line(pointA1, pointA1.add(pointB1));
        Line L2 = new Line(pointA2, pointA2.add(pointB2));
        return L1.intersect(L2);
    }

    double getRadius() {
        return radius;
    }

    Point2D getCenter() {
        return center;
    }
}

class Line {
    private Point2D pointX, pointY;

    Line(Point2D x, Point2D y) {
        this.pointX = x;
        this.pointY = y;
    }

    Point2D getPointSubtract() {
        return pointY.subtract(pointX);
    }

    Point2D intersect(Line line2) {
        Point2D pointA = getPointSubtract();
        Point2D pointB = line2.getPointSubtract();
        Point2D pointC = line2.pointX.subtract(pointX);
        double division = pointA.cross(pointB), sn = pointC.cross(pointB);
        double scale = sn / division;

        return pointA.scale(scale).add(pointX);
    }
}

class Point2D implements Comparable<Point2D> {
    double x, y;

    Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public int compareTo(Point2D point2) {
        if (Utils.equals(x, point2.x)) {
            if (Utils.equals(y, point2.y)) {
                return 0;
            }
            return Double.compare(y, point2.y);
        }
        return Double.compare(x, point2.x);
    }

    Point2D add(Point2D point2) {
        return new Point2D(x + point2.x, y + point2.y);
    }

    Point2D subtract(Point2D point2) {
        return new Point2D(x - point2.x, y - point2.y);
    }

    Point2D scale(double scale) {
        return new Point2D(scale * x, scale * y);
    }

    double cross(Point2D point2) {
        return x * point2.y - y * point2.x;
    }

    Point2D midpoint(Point2D point2) {
        return new Point2D(0.5 * (x + point2.x), 0.5 * (y + point2.y));
    }

    double multiply() {
        return x * x + y * y;
    }

    double multiplySqrt() {
        return Math.sqrt(multiply());
    }

    double distance(Point2D point2) {
        return subtract(point2).multiplySqrt();
    }
}

class Utils {
    static double precision = 1e-6;

    static boolean equals(double valueA, double valueB) {
        double diff = Math.abs(valueA - valueB);
        if (diff < precision) {
            return true;
        }
        boolean result = diff < precision * Math.max(Math.abs(valueA), Math.abs(valueB));
        return result;
    }
}