package list;

public class DoublyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublyLinkedList() {
    }

    // delete from start
    public Node<T> removeFromHead() {
        if (head == null) {
            return null;
        }

        Node<T> temp = head;
        if (head == tail) {
            head = tail = null;
            size--;
            return temp;
        }

        head = head.next;
        head.setPrev(null);
        temp.setNext(null);
        size--;
        return temp;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> removeFromTail() {
        if (head == null) {
            return null;
        }

        Node<T> temp = tail;
        if (head == tail) {
            head = tail = null;
            size--;
            return temp;
        }

        tail = tail.prev;
        tail.setNext(null);
        temp.setPrev(null);
        size--;
        return temp;
    }

    // Remove 1st Matched Item
    public Node<T> removeMatchedItem(T val) {
        if (head == null) {
            return null;
        }
        if (head.value.equals(val)) {
            return removeFromHead();
        }

        Node<T> temp = head.next;
        while (temp != null) {
            if (temp.value.equals(val)) {
                Node<T> prev = temp.prev;
                if (tail == temp) {
                    tail = prev;
                    tail.setNext(null);
                    temp.setPrev(null);
                } else {
                    Node<T> next = temp.next;
                    prev.setNext(next);
                    next.setPrev(prev);
                    temp.setPrev(null);
                    temp.setNext(null);
                }
                size--;
                return temp;
            }
            temp = temp.next;
        }

        return null;
    }

    // Remove value at given position
    public Node<T> removeItemAtIndex(int index) {
        if (head == null) {
            return null;
        }
        if (index < 0 || index >= size) {
            return null;
        }

        Node<T> temp = head;
        int i = 0;
        while (i < index) {
            temp = temp.next;
            i++;
        }

        if (temp == head) {
            return removeFromHead();
        }

        Node<T> prev = temp.prev;
        if (temp == tail) {
            tail = prev;
            tail.setNext(null);
            temp.setPrev(null);
        } else {
            Node<T> next = temp.next;
            prev.setNext(next);
            next.setPrev(prev);
            temp.setPrev(null);
            temp.setNext(null);
        }
        size--;
        return temp;
    }

    // get Index of element
    public int getPosition(T val) {
        int position = -1;
        if (head == null) {
            return position;
        }
        Node<T> temp = head;
        int c = 0;
        while (temp != null) {
            if (temp.value.equals(val)) {
                position = c;
                break;
            }
            temp = temp.next;
            c++;
        }
        return position;
    }

    // find nth element from last
    public Node<T> findNthElementFromLast(int n) {
        if (n <= 0 || n > size) {
            return null;
        }
        if (n == 1) {
            return tail;
        }
        if (n == size) {
            return head;
        }
        Node<T> first = head;
        Node<T> second = head;
        int c = 0;
        while (c < n) {
            first = first.next;
            c++;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }

    private void addFirst(T val) {
        tail = head = new Node<T>(val);
        size++;
    }

    private void addAtHead(T val) {
        Node<T> temp = new Node<T>(val, null, head);
        head.prev = temp;
        head = temp;
        size++;
    }

    private void addAtTail(T val) {
        Node<T> temp = new Node<T>(val, tail, null);
        tail.next = temp;
        tail = temp;
        size++;
    }

    // add at tail
    public void insertAtTail(T val) {
        if (head == null) {
            addFirst(val);
        } else {
            addAtTail(val);
        }
    }

    public void insertAtHead(T val) {
        if (head == null) {
            addFirst(val);
        } else {
            addAtHead(val);
        }
    }

    public void insertAt(T val, int index) {
        if (head != null && index >= 0 && index <= size) {
            if (index == 0) {
                addAtHead(val);
            } else if (index == size) {
                addAtTail(val);
            } else {
                Node<T> temp = head;
                int i = 1;
                while (i < index) {
                    temp = temp.next;
                    i++;
                }
                Node<T> newNode = new Node<T>(val, temp, temp.next);
                // or newNode.next.prev = newNode;
                temp.next.prev = newNode;
                temp.next = newNode;
                size++;
            }
        } else {
            if (index == 0) {
                addFirst(val);
            } else {
                System.out.println("Wrong index, can't add element in list");
            }
        }
    }

    public void traverseList() {
        if (head != null) {
            System.out.print("head : " + head.value + ", tail : " + tail.value + ", size : " + size + ", list : ");
            Node<T> temp = head;
            int c = 0;
            while (temp != null) {
                if (c != 0) {
                    System.out.print(" --> ");
                } else {
                    c++;
                }
                System.out.print(temp.getValue());
                temp = temp.next;
            }

        } else {
            System.out.println("List is empty");
        }
        System.out.println();
    }

    private static class Node<T> {
        private T value;
        private Node<T> prev;
        private Node<T> next;

        Node(T value, Node<T> prev, Node<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        Node(T value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
