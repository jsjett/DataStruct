package com.data.linkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addFirst(10);
        System.out.println(linkedList);
        for (int i = 0; i< 5; i++) {
            linkedList.addFirst(i);
        }

        System.out.println(linkedList);
        linkedList.addFirst(8);
        linkedList.addFirst(10);
        linkedList.addFirst(5);
        linkedList.addFirst(10);
        linkedList.addFirst(10);
        System.out.println(linkedList);

        linkedList.removeNodesWithDeep(10);
        System.out.println(linkedList);

    }

}
