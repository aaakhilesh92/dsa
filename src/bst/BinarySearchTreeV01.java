package bst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTreeV01<T> {
    private Node<T> root;
    private Comparator<? super T> comparator;

    public BinarySearchTreeV01() {
        comparator = null;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void add(T val) {
        if (root == null) {
            root = new Node<T>(val);
        } else {
            Node<T> temp = root;
            Node<T> parent;
            int cmp;
            Comparator<? super T> cpr = comparator;
            if (cpr != null) {
                do {
                    parent = temp;
                    cmp = cpr.compare(val, temp.data);
                    if (cmp < 0) {
                        temp = temp.left;
                    } else if (cmp > 0) {
                        temp = temp.right;
                    } else {
                        // do nothing
                    }
                } while (temp != null);
            } else {
                if (val == null)
                    throw new NullPointerException();
                @SuppressWarnings("unchecked")
                Comparable<? super T> k = (Comparable<? super T>) val;
                do {
                    parent = temp;
                    cmp = k.compareTo(temp.data);
                    if (cmp < 0) {
                        temp = temp.left;
                    } else if (cmp > 0) {
                        temp = temp.right;
                    } else {
                        // do nothing
                    }
                } while (temp != null);
            }
            Node<T> e = new Node<T>(val);
            if (cmp < 0) {
                parent.left = e;
            } else {
                parent.right = e;
            }
        }
    }

    public static class Node<T> {
        Node<T> left;
        Node<T> right;
        T data;

        Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data + "";
        }
    }

    public void levelOrderTraversal() {
        //Breadth First Traversal
        System.out.println("***** Level Order Traversal *****");
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            System.out.print(node.data + " ");
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        System.out.println();
    }

    public void inOrderTraversal() {
        System.out.println("*********** InOrder Traversal ***********");
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node<T> node) {
        if (node == null)
            return;

        inOrderRec(node.left);
        System.out.print(node.data + " ");
        inOrderRec(node.right);
    }

    public void inOrderIterative() {
        System.out.println("*********** InOrder Traversal Iterative ***********");
        if (root == null)
            return;

        Stack<Node<T>> stack = new Stack<>();
        Node<T> curr = root;
        while (curr != null || !stack.empty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
        System.out.println();
    }

    public void preOrderTraversal() {
        System.out.println("*********** PreOrder Traversal ***********");
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node<T> node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrderIterative() {
        System.out.println("*********** Pre Order Traversal Iterative ***********");
        if (root == null) {
            return;
        }
        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Node<T> node = stack.pop();
            System.out.print(node.data + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        System.out.println();
    }

    public void preOrderIterative2() {
        if (root == null) {
            return;
        }

        Stack<Node<T>> st = new Stack<>();

        // Start from root node (set curr node to root node)
        Node<T> curr = root;

        // Run till stack is not empty or current is not NULL
        while (curr != null || !st.empty()) {

            // Print left children while exist and keep pushing right into the stack.
            while (curr != null) {
                System.out.print(curr.data + " ");

                if (curr.right != null)
                    st.push(curr.right);

                curr = curr.left;
            }

            // We reach when curr is NULL, so We take out a right child from stack
            if (!st.empty()) {
                curr = st.pop();
            }
        }
    }

    public void postOrderTraversal() {
        System.out.println("*********** PostOrder Traversal ***********");
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(Node<T> node) {
        if (node == null)
            return;

        postOrderRec(node.left);
        postOrderRec(node.right);
        System.out.print(node.data + " ");
    }

    public void postOrderIterative() {
        System.out.println("*********** Post Order Traversal Iterative ***********");

        Stack<Node<T>> stack = new Stack<>();

        Node<T> node = root;
        while (true) {
            while (node != null) {
                stack.push(node);
                stack.push(node);
                node = node.left;
            }
            if (stack.empty())
                return;
            node = stack.pop();

            if (!stack.empty() && stack.peek() == node) {
                node = node.right;
            } else {
                System.out.print(node.data + " ");
                node = null;
            }
        }

    }

    public void postOrderIterative2() {
        System.out.println("*********** Post Order Traversal Iterative2 ***********");
        // Check for empty tree
        if (root == null)
            return;
        List<T> list = new ArrayList<>();
        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);
        Node<T> prev = null;
        while (!stack.empty()) {
            Node<T> current = stack.peek();

            /*
             * go down the tree in search of a leaf an if so process it and pop stack otherwise move down
             */
            if (prev == null || prev.left == current || prev.right == current) {
                if (current.left != null)
                    stack.push(current.left);
                else if (current.right != null)
                    stack.push(current.right);
                else {
                    stack.pop();
                    //list.add(current.data);
                    System.out.print(current.data + " ");
                }

                /*
                 * go up the tree from left node, if the child is right push it onto stack otherwise process parent and pop stack
                 */
            } else if (current.left == prev) {
                if (current.right != null)
                    stack.push(current.right);
                else {
                    stack.pop();
                    //list.add(current.data);
                    System.out.print(current.data + " ");
                }

                /*
                 * go up the tree from right node and after coming back from right node process parent and pop stack
                 */
            } else if (current.right == prev) {
                stack.pop();
                //list.add(current.data);
                System.out.print(current.data + " ");
            }
            prev = current;
        }
        System.out.println();
    }

    public boolean isIdentical(Node<T> node1, Node<T> node2) {
        if (node1 == null && node2 == null)
            return true;
        if (node1 == null || node2 == null)
            return false;
        return node1.data.equals(node2.data) && isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.right);

    }

    public boolean isIdentical_Iterative(Node<T> node1, Node<T> node2) {
        if (node1 == null && node2 == null)
            return true;

        if (node1 == null || node2 == null)
            return false;

        Queue<Node<T>> q1 = new LinkedList<>();
        Queue<Node<T>> q2 = new LinkedList<>();

        q1.add(node1);
        q2.add(node2);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            Node<T> t1 = q1.poll();
            Node<T> t2 = q2.poll();

            if (!t1.data.equals(t2.data))
                return false;

            // Handle Left Child
            if (t1.left != null && t2.left != null) {
                q1.add(t1.left);
                q2.add(t2.left);
            } else if (t1.left != null || t2.left != null)
                return false;

            // Right Left Child
            if (t1.right != null && t2.right != null) {
                q1.add(t1.right);
                q2.add(t2.right);
            } else if (t1.right != null || t2.right != null)
                return false;
        }

        return true;
    }

    public boolean isMirror(Node<T> node1, Node<T> node2) {
        if (node1 == null && node2 == null)
            return true;

        if (node1 == null || node2 == null)
            return false;
        return node1.data.equals(node2.data) && isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);

    }

    public void printLeftView(Node<T> root) {
        if (root == null) {
            return;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 1; i <= n; i++) {
                Node<T> temp = queue.poll();
                if (i == 1)
                    System.out.print(temp.data + " ");

                if (temp.left != null)
                    queue.add(temp.left);

                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
    }

    public void printRightView(Node<T> root) {
        if (root == null) {
            return;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 1; i <= n; i++) {
                Node<T> temp = queue.poll();
                if (i == n)
                    System.out.print(temp.data + " ");

                if (temp.left != null)
                    queue.add(temp.left);

                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
    }

    public void printRootToLeafPaths() {
        inOrder(root, new StringBuilder(root.data.toString()));
    }

    private void inOrder(Node<T> node, StringBuilder sb) {
        if (node.left == null && node.right == null) {
            System.out.println(sb.toString());
            return;
        }
        if (node.left != null) {
            inOrder(node.left, sb.append(node.left.data));
            sb.deleteCharAt(sb.length() - 1);
        }
        if (node.right != null) {
            inOrder(node.right, sb.append(node.right.data));
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
