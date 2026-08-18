package list;

public class SingleLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public SingleLinkedList() {
    }

    // add at tail
    public void add(T val) {
        if (head == null) {
            addFirst(val);
        } else {
            addAtTail(val);
        }

    }

    // add at head
    public void insert(T val) {
        if (head == null) {
            addFirst(val);
        } else {
            addAtHead(val);
        }
    }

    private void addFirst(T val) {
        tail = head = new Node<T>(null, val);
        size++;
    }

    private void addAtHead(T val) {
        Node<T> temp = new Node<T>(head, val);
        head = temp;
        size++;
    }

    private void addAtTail(T val) {
        tail.next = new Node<T>(null, val);
        tail = tail.next;
        size++;
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
                Node<T> newNode = new Node<T>(temp.next, val);
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
            System.out.print("head : " + head.value + ", tail : " + tail.value + ", size : " + size + "\nList Elements : ");
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

    public void traverseList(Node<T> node) {
        if (node != null) {
            System.out.print("List Elements : ");
            Node<T> temp = node;
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
        if (temp != null) {
            head = head.next;
            temp.setNext(null);
            size--;
        }
        return temp;
    }

    public Node<T> getHead() {
        return head;
    }

    // delete from end
    public Node<T> removeFromTail() {
        if (head == null) {
            return null;
        }
        if (head == tail) {
            Node<T> p = head;
            head = tail = null;
            size--;
            return p;
        }

        Node<T> next = head.next;
        Node<T> prev = head;
        while (next.next != null) {
            prev = next;
            next = next.next;
        }
        prev.setNext(null);
        tail = prev;
        size--;
        return next;
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
        Node<T> prev = head;
        while (temp != null) {
            if (temp.value.equals(val)) {
                prev.setNext(temp.next);
                temp.next = null;
                size--;
                if (tail == temp) {
                    tail = prev;
                }
                return null;
            }
            prev = temp;
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
        Node<T> prev = null;
        int i = 0;
        while (i < index) {
            prev = temp;
            temp = temp.next;
            i++;
        }
        if (temp == head) {
            return removeFromHead();
        }
        prev.next = temp.next;
        temp.next = null;
        if (temp == tail) {
            tail = prev;
        }
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

    public Node<T> reverse(Node<T> node) {
        Node<T> prev = null;
        Node<T> current = node;
        Node<T> next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    public void reverse(int k) {
        head = reverse(head, k);
        System.out.println(head);
        traverseList();
    }

    public Node<T> reverse(Node<T> node, int k) {
        if (node == null)
            return null;
        Node<T> current = node;
        Node<T> next = null;
        Node<T> prev = null;

        int count = 0;

        /* Reverse first k nodes of linked list */
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        // Next is now a pointer to (k+1)th node Recursively call for the list starting from current.
        // And make rest of the list as next of first node

        if (next != null)
            node.next = reverse(next, k);

        // prev is now head of input list
        return prev;
    }

    // Function to reverse the linked list in groups of
    // size k and return the pointer to the new head node. /
    public Node<T> reverseIterative(Node<T> node, int k) {
        Node<T> prev = null;
        Node<T> curr = node;
        Node<T> temp = null;
        Node<T> tail = null;
        Node<T> newHead = null;
        Node<T> join = null;
        int t = 0;

        // Traverse till the end of the linked list
        while (curr != null) {
            t = k;
            join = curr;
            prev = null;

            // Reverse group of k nodes of the linked list
            while (curr != null && t-- != 0) {
                temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // Sets the new head of the input list
            if ((newHead == null))
                newHead = prev;

            // Tail pointer keeps track of the last node of the k-reversed linked list.
            // We join the tail pointer with the head of the next k-reversed linked list's head

            if (tail != null)
                tail.next = prev;
            // The tail is then updated to the last node of the next k-reverse linked list
            tail = join;
        }

        // newHead is new head of the input list
        return newHead;
    }

    // Function to reverse first k elements of linked list
    public Node<T> reverseKNodes(Node<T> head_ref, int k) {
        // traverse the linked list until break
        // point not meet
        Node<T> temp = head_ref;
        int count = 1;
        while (count < k) {
            temp = temp.next;
            count++;
        }

        // backup the joint point
        Node<T> joint_point = temp.next;
        temp.next = null; // break the list

        // reverse the list till break point
        Node<T> prev = null;
        Node<T> current = head_ref;
        Node<T> next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // join both parts of the linked list
        // traverse the list until null is not
        // found
        head_ref = prev;
        current = head_ref;
        while (current.next != null)
            current = current.next;

        // joint both part of the list
        current.next = joint_point;
        return head_ref;
    }

    // function used to reverse a linked list from position m to n which uses reverse function
    public Node<T> reverseBetween(int m, int n) {
        if (m == n)
            return head;

        // rev_start and rev_end is start and end respectively of the portion of the linked list which need to be reversed.
        // rev_start_prev is previous of starting position and rev_end_next is next of end of list to be reversed.
        Node<T> rev_start = null, rev_start_prev = null;
        Node<T> rev_end = null, rev_end_next = null;

        // Find values of above pointers.
        int i = 1;
        Node<T> curr = head;
        while (curr != null && i <= n) {
            if (i < m)
                rev_start_prev = curr;
            if (i == m)
                rev_start = curr;
            if (i == n) {
                rev_end = curr;
                rev_end_next = curr.next;
            }
            curr = curr.next;
            i++;
        }
        rev_end.next = null;

        // Reverse linked list starting with rev_start.
        rev_end = reverse(rev_start);

        // If starting position was not head
        if (rev_start_prev != null) {
            rev_start_prev.next = rev_end;
        } else { // If starting position was head
            head = rev_end;
        }

        rev_start.next = rev_end_next;
        return head;
    }

    private static class Node<T> {
        private Node<T> next;
        private T value;

        Node(Node<T> next, T value) {
            this.next = next;
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
