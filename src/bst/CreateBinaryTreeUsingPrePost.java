package bst;

//Java program for construction of full binary tree
public class CreateBinaryTreeUsingPrePost {

    // variable to hold index in preOrder[] array
    private int preIndex = 0;

    // A recursive function to construct Full from preOrder[] and postOrder[]. preIndex is used to keep track of index in preOrder[].
    private Node constructTreeUtil(int preOrder[], int postOrder[], int l, int h, int size) {
        if (preIndex >= size || l > h)
            return null;

        // The first node in preorder traversal is root. So take the node at preIndex from
        // preorder and make it root, and increment preIndex
        Node root = new Node(preOrder[preIndex]);
        preIndex++;

        // If the current subarry has only one element, no need to recur or preIndex > size after incrementing
        if (l == h || preIndex >= size)
            return root;

        int i;
        // Search the next element of preOrder[] in postOrder[]
        for (i = l; i <= h; i++) {
            if (postOrder[i] == preOrder[preIndex])
                break;
        }
        // Use the index of element found in postorder to divide postorder array in two parts. Left subtree and right subtree
        if (i <= h) {
            root.left = constructTreeUtil(preOrder, postOrder, l, i, size);
            root.right = constructTreeUtil(preOrder, postOrder, i + 1, h, size);
        }
        return root;
    }

    public Node constructTree(int preOrder[], int postOrder[], int size) {
        preIndex = 0;
        return constructTreeUtil(preOrder, postOrder, 0, size - 1, size);
    }

    public void printInorder(Node root) {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args) {

        int preOrder[] = { 1, 2, 4, 8, 9, 5, 3, 6, 7 };
        int postOrder[] = { 8, 9, 4, 5, 2, 6, 7, 3, 1 };

        int size = preOrder.length;
        CreateBinaryTreeUsingPrePost obj = new CreateBinaryTreeUsingPrePost();
        Node root = obj.constructTree(preOrder, postOrder, size);

        System.out.println("Inorder traversal of the constructed tree:");
        obj.inOrder(root);
        System.out.println("\nPreorder traversal of the constructed tree:");
        obj.preOrder(root);
        System.out.println("\nPostorder traversal of the constructed tree:");
        obj.postOrder(root);
    }

    private static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }
}