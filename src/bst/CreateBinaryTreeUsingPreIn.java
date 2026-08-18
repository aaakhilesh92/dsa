package bst;

import java.util.HashMap;

/* Java program to construct tree using inorder and preorder traversals */
class CreateBinaryTreeUsingPreIn {
    private Node root;
    // Store indexes of all items so that we can quickly find later
    private HashMap<Character, Integer> map = new HashMap<>();
    private int preIndex = 0;

    /*
     * Recursive function to construct binary of size len from Inorder traversal in[] and Preorder traversal pre[]. Initial values of inStrt and inEnd should be 0 and len -1. The
     * function doesn't do any error checking for cases where inorder and preorder do not form a tree
     */
    public Node buildTree(char[] in, char[] pre, int inStrt, int inEnd) {

        if (inStrt > inEnd) {
            return null;
        }

        /*
         * Pick current node from Preorder traversal using preIndex and increment preIndex
         */
        char data = pre[preIndex++];
        Node tNode;
        tNode = new Node(data);

        /* If this node has no children then return */
        if (inStrt == inEnd) {
            return tNode;
        }

        /* Else find the index of this node in Inorder traversal */
        int inIndex = map.get(data);

        /*
         * Using index in Inorder traversal, construct left and right subtress
         */
        tNode.left = buildTree(in, pre, inStrt, inIndex - 1);
        tNode.right = buildTree(in, pre, inIndex + 1, inEnd);
        return tNode;
    }

    // This function mainly creates an unordered_map, then calls buildTree()
    public Node buldTreeWrap(char[] in, char[] pre, int len) {
        for (int i = 0; i < len; i++) {
            map.put(in[i], i);
        }
        return buildTree(in, pre, 0, len - 1);
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

    /* Driver code */
    public static void main(String[] args) {
        char[] in = { 'D', 'B', 'E', 'A', 'F', 'C' };
        char[] pre = { 'A', 'B', 'D', 'E', 'C', 'F' };
        int len = in.length;
        CreateBinaryTreeUsingPreIn obj = new CreateBinaryTreeUsingPreIn();
        Node root = obj.buldTreeWrap(in, pre, len);

        System.out.println("Inorder traversal of the constructed tree:");
        obj.inOrder(root);
        System.out.println("\nPreorder traversal of the constructed tree:");
        obj.preOrder(root);
        System.out.println("\nPostorder traversal of the constructed tree:");
        obj.postOrder(root);
    }

    private static class Node {
        char data;
        Node left, right;

        Node(char item) {
            data = item;
            left = right = null;
        }
    }
}
