package other;

public class ParentChild1 {
    public static void main(String[] args) {
        Parent obj = new Child();
        obj.run();
    }
}

class Parent {
    public void walk() {
        System.out.println("Parent Walk method");
    }

    public void run() {
        System.out.println("Parent Run method");
        this.walk();
    }
}

class Child extends Parent {
    public void walk() {
        System.out.println("Child Walk method");
        super.walk();
    }

    public void run() {
        System.out.println("Child Run method");
        super.run();
    }
}