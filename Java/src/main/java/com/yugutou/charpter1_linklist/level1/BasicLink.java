package com.yugutou.charpter1_linklist.level1;

/**
 * 一个简单的链表实例，用于演示JVM怎么构造链表的
 */
public class BasicLink {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        Node head = initLinkedList(a);
        System.out.println(head);
    }

    private static Node initLinkedList(int[] a) {
        Node head = null;
        Node cur = null;
        for (int i = 0; i < a.length; i++) {
            Node newNode = new Node(a[i]);
            newNode.next = null;
            if (i == 0) {
                head = newNode;
                cur = newNode;
            } else {
                cur.next = newNode;
                cur = newNode;
            }
        }
        return head;
    }


    static class Node {
        public int val;
        public Node next;

        Node(int x) {
            val = x;
            next = null;
        }
    }

}
