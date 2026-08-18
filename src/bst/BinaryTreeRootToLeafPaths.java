package bst;

/*Provided root node of a tree, iterate over the tree and print all pathways from root to the leaves.

       A
    /     \
   B       C
    \    /  \
     D   E   F
Ans - ABD, ACE, ACF
*/

public class BinaryTreeRootToLeafPaths {
    private Node root;

    static class Node {
        Node(String data) {
            this.data = data;
        }

        String data;
        Node left, right;
    }

    public void printRootToLeafPaths() {
        inOrder(root, new StringBuilder(root.data));
    }

    private void inOrder(Node node, StringBuilder sb) {
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

    public static void main(String[] args) {
        BinaryTreeRootToLeafPaths bst = new BinaryTreeRootToLeafPaths();
        bst.root = new Node("A");
        bst.root.left = new Node("B");
        bst.root.right = new Node("C");
        bst.root.left.left = new Node("D");
        bst.root.right.left = new Node("E");
        bst.root.right.right = new Node("F");
        bst.printRootToLeafPaths();
    }
}
