package other;

public class DiamondProblem implements InterfaceC {
    public static void main(String[] args) {
        new DiamondProblem().show();
    }
}

interface C extends B, A {
    @Override
    default void show() {
        B.super.show();
    }
}

interface A {
    default void show() {
        System.out.println("A");
    }
}

interface B {
    default void show() {
        System.out.println("B");
    }
}
