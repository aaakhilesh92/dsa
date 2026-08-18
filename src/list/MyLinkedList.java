package list;

public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    MyLinkedList() {
    }

    public void add(T item) {
        Node<T> l = tail;
        Node<T> newNode = new Node<T>(item, l, null);
        tail = newNode;
        if (l == null)
            head = newNode;
        else
            l.next = newNode;
        size++;
    }

    public void addFirst(T item) {
        Node<T> h = head;
        Node<T> newNode = new Node<T>(item, null, h);
        head = newNode;
        if (h == null)
            tail = newNode;
        else
            h.prev = newNode;
        size++;
    }

    public void addAt(T item, int index) {
        checkElementIndex(index);
        if (index == 0) {
            addFirst(item);
        } else if (index == size - 1) {
            add(item);
        } else {
            Node<T> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            Node<T> prev = temp.prev;
            Node<T> newNode = new Node<T>(item, prev, temp);
            prev.next = newNode;
            temp.prev = newNode;
            size++;
        }
    }

    public void findKthElementFromLast(int index) {
        checkElementIndex(index);
        Node<T> first = head;
        for (int i = 0; i < index; i++)
            first = first.next;
        Node<T> second = head;
        while (first.next != null) {
            second = second.next;
            first = first.next;
        }

        System.out.println("Nth Element from Last : " + second.data);
    }

    public void remove(T item) {
        for (Node<T> x = head; x != null; x = x.next) {
            if (x.data.equals(item)) {
                removeNode(x);
                break;
            }
        }
    }

    public void remove(int index) {
        checkElementIndex(index);
        removeNode(node(index));
    }

    private void checkElementIndex(int index) {
        if (!(index >= 0 && index < size))
            throw new IndexOutOfBoundsException("Index : " + index + ", size " + size);
    }

    private void removeNode(Node<T> node) {
        Node<T> prev = node.prev;
        Node<T> next = node.next;
        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }
        node.data = null;
        size--;
    }

    public T get(int index) {
        checkElementIndex(index);
        return node(index).data;
    }

    private Node<T> node(int index) {
        Node<T> result = null;
        if (index < (size >> 1)) {
            result = head;
            for (int i = 0; i < index; i++)
                result = result.next;
        } else {
            result = tail;
            for (int i = size - 1; i > index; i--)
                result = result.prev;
        }
        return result;
    }

    public void printList() {
        Node<T> temp = head;
        if (temp == null)
            return;

        System.out.print("Traversing List : ");
        while (temp != null) {
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return data + "";
        }
    }

    public static void main(String[] args) {
        MyLinkedList<String> mylist = new MyLinkedList<String>();
        mylist.add("2");
        mylist.add("3");
        mylist.addFirst("10");
        mylist.add("9");
        mylist.add("6");
        mylist.addAt("20", 3);
        mylist.printList();
        mylist.findKthElementFromLast(5);
        mylist.printList();
    }
}
