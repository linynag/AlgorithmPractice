package com.yugutou.charpter1_linklist.level1;

/**
 * 在算法中最常用的链表定义方式
 */
public class ListNode {
    private int var;
    private ListNode next;

    public ListNode(int x){
        this.var=x;
        this.next=null;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        System.out.println(listNode.var);
    }

}
