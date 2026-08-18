package other;

public interface InterfaceB extends InterfaceA{
    default void show() {
        System.out.println("hello B");
    }
}
