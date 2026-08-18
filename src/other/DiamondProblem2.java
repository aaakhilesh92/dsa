package other;

public class DiamondProblem2 implements Interface1, Interface2 {
    public void foo() {
        // System.out.println("Inside DiamondProblem2");
        Interface1.super.foo();
    }

    public static void main(String[] args) {
        new DiamondClass().show();
        new DiamondProblem2().foo();
        new DiamondClass().show();
    }
}

class DiamondClassTest extends DiamondClass implements C1 {

}

class DiamondClass implements B1 {
    /*@Override
    public void show() {
        System.out.println("Using DiamondClass");
        B1.super.show();
    }*/
}

interface C1 extends B1, A1 {
    @Override
    default void show() {
        B1.super.show();
    }
}

interface A1 {
    default void show() {
        System.out.println("Interface A1 show");
    }
}

interface B1 {
    default void show() {
        System.out.println("Interface B1 show");
    }
}

interface Interface1 {
    default void foo() {
        System.out.println("Interface1's foo");
    }
}

interface Interface2 {
    default public void foo() {
        System.out.println("Interface2's foo");
    }
}