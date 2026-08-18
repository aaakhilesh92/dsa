package bst;

public class BinarySearchTreeTesting {

    public static void main(String[] args) {
        BinarySearchTreeV01<Integer> bst = new BinarySearchTreeV01<Integer>();
        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.add(2);
        bst.add(1);
        bst.add(3);
        bst.add(6);
        bst.add(12);
        bst.add(11);
        bst.add(17);
        bst.add(14);
        bst.add(18);
        bst.add(16);
        bst.postOrderTraversal();;
        bst.postOrderIterative();
        System.out.println();
        bst.postOrderIterative2();
        System.out.println();
        BinarySearchTreeV01<Integer> bst2 = new BinarySearchTreeV01<Integer>();
        bst2.add(10);
        bst2.add(5);
        bst2.add(15);
        bst2.add(2);
        bst2.add(1);
        bst2.add(3);
        bst2.add(6);
        bst2.add(12);
        bst2.add(11);
        bst2.add(17);
        bst2.add(14);
        bst2.add(18);
        bst2.add(16);
        System.out.println("2nd Tree");
        bst2.levelOrderTraversal();
        System.out.println("Tree is identical ? " + bst.isIdentical_Iterative(bst.getRoot(), bst2.getRoot()));
        bst2.printRootToLeafPaths();
    }

}
