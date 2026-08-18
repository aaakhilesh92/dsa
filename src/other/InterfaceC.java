package other;

public interface InterfaceC extends InterfaceA {
    default public void show() {
        System.out.println("hello C");
    }
}
