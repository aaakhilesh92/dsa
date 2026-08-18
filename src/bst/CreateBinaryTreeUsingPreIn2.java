package bst;

/*
 * Let us consider the below traversals:
Inorder sequence: D B E A F C 
Preorder sequence: A B D E C F
 */

public class CreateBinaryTreeUsingPreIn2 {
    private int preIndex = 0;

    public static void main(String[] args) {
        char[] inorder = { 'D', 'B', 'E', 'A', 'F', 'C' };
        char[] preOrder = { 'A', 'B', 'D', 'E', 'C', 'F' };
        CreateBinaryTreeUsingPreIn2 obj = new CreateBinaryTreeUsingPreIn2();
        Node node = obj.buildTree(inorder, preOrder);

        obj.inOrder(node);
        System.out.println();
        obj.preOrder(node);
    }

    public Node buildTree(char[] inOrder, char[] preOrder) {
        preIndex = 0;
        return buildTreeRec(inOrder, preOrder, 0, inOrder.length - 1);
    }

    private Node buildTreeRec(char[] inOrder, char[] preOrder, int startIndex, int lastIndex) {

        if (startIndex > lastIndex) {
            return null;
        }

        Node node = new Node(preOrder[preIndex++]);

        if (startIndex == lastIndex) {
            return node;
        }
        int index = search(inOrder, startIndex, lastIndex, node.data);
        node.left = buildTreeRec(inOrder, preOrder, startIndex, index - 1);
        node.right = buildTreeRec(inOrder, preOrder, index + 1, lastIndex);
        return node;
    }

    private int search(char[] inOrder, int start, int end, char ch) {
        int index = start;
        while (index <= end) {
            if (inOrder[index] == ch) {
                break;
            }
            index++;
        }
        return index;
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    private static class Node {
        private char data;
        private Node left;
        private Node right;

        Node(char data) {
            this.data = data;
        }
    }
}
// two string are greather based on size and alphabaticalliy
// 2nd highest number
// design principles

// 2ND HIGHEST NO
// COMPARE STRING LENGHTH