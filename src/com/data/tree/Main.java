package com.data.tree;

public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();

        tree.addElement(5);
        tree.addElement(8);
        tree.addElement(6);
        tree.addElement(7);
        tree.addElement(3);
        tree.addElement(4);
        tree.addElement(1);
        tree.addElement(2);
//        System.out.println(tree);

        System.out.println(tree.contains(100));
        System.out.println(tree.contains(10));
        System.out.println(tree.contains(2));

        System.out.println(tree.getMinValue());

        tree.removeMin();
        System.out.println(tree.getMinValue());

//        tree.preOrder();
//        tree.preOrderStack();
//        System.out.println("asdfdadasdasda");
//        tree.levelTraversal();
    }
}
