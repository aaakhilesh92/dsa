package other;

public class MyOuter {
    private int x = 10;
    private int y = 10;
    private String str = "Outer";

    private MyOuter() {
        this(5);
    }

    private MyOuter(int x) {
        this(x, 10);
        // cannot refer to an instance field while explicitly invoking a constructor
        // this(x, y);
    }

    private MyOuter(int x, int y) {
        System.out.println(x * y);
    }

    public static void main(String[] args) {
        new MyOuter().createInnerInstance();

    }

    public void createInnerInstance() {
        MyInner in = new MyInner();
        in.seeOuterVariable();
    }

    private class MyInner {
        private void seeOuterVariable() {
            System.out.println(x + ", " + str);
        }
    }

}
