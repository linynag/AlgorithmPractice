package com.yugutou.charpter1_linklist.level2.topic2_2回文序列;


import org.w3c.dom.NodeList;

import java.util.Stack;

public class IsPalindromic {
    NodeList temp;

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 1};
        ListNode node = initLinkedList(a);
        int testMethode = 3;
        boolean result = false;
        switch (testMethode) {
            case 1:
                result = isPalindromeByTwoPoints(node);
                break;
            case 2:
                result = isPalindromeByAllStack(node);
                break;
            case 3:
                result = inPalindromeByHalfStack(node);
                break;
            case 4:
                result = isPalindromebyRe(node);
                break;
        }
        System.out.println("result：" + result);
    }

    private static boolean isPalindromebyRe(ListNode node) {
        return true;
    }

    private static boolean inPalindromeByHalfStack(ListNode node) {
        if (node == null) {
            return true;
        }
        ListNode temp = node;
        Stack<Integer> stack = new Stack<>();
        int length = 0;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
            length++;
        }
        // 向下取整数  向上取整：(length % 2 == 0) ? length / 2 : (length / 2) + 1;
        length = length / 2;
        while (length-- > 0) {
            if (node.val != stack.pop()) {
                return false;
            }
            node = node.next;
        }
        return true;
    }

    private static boolean isPalindromeByAllStack(ListNode node) {
        if (node == null) {
            return true;
        }
        ListNode temp = node;
        // 为什么需要必须是Integer
        Stack<Integer> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        while (node != null) {
            if (node.val != stack.pop()) {
                return false;
            }
            node = node.next;
        }
        return true;
    }

    private static boolean isPalindromeByTwoPoints(ListNode node) {
        return true;
    }

        private static ListNode initLinkedList(int[] a) {
            ListNode head = null;
            ListNode cur = null;
            for (int i = 0; i < a.length; i++) {
                ListNode newNode = new ListNode(a[i]);
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

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


}
