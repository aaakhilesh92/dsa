package list;

public class DoublyLinkedListTest {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        list.insertAtHead(1);
        list.insertAtHead(2);
        list.insertAtHead(3);
        list.insertAtHead(4);
        list.insertAtHead(5);
        list.traverseList();

        list.removeItemAtIndex(0);
        list.traverseList();
        list.removeItemAtIndex(2);
        list.traverseList();
        list.removeItemAtIndex(1);
        list.traverseList();
        list.removeItemAtIndex(1);
        list.traverseList();
        list.removeItemAtIndex(0);
        list.traverseList();

        list.insertAtTail(4);
        list.insertAtTail(2);
        list.insertAtTail(1);
        list.insertAtHead(50);
        list.insertAtHead(10);
        list.insertAtHead(20);
        list.insertAtHead(30);
        list.insertAtHead(500);
        list.traverseList();

        list.insertAt(100, 4);
        list.traverseList();
        list.insertAt(100, 2);
        list.traverseList();
        list.insertAt(300, 10);
        list.traverseList();
        int index = 2;
        System.out.println("Last " + index + "th element : " + list.getPosition(100));
        index = 1;
        System.out.println("Last " + index + "th element : " + list.getPosition(300));
        index = 11;
        System.out.println("Last " + index + "th element : " + list.getPosition(1));
    }
}
