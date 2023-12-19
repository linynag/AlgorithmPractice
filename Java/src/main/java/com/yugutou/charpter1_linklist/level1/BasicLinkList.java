package com.yugutou.charpter1_linklist.level1;

import com.sun.org.apache.xpath.internal.operations.Neg;
import sun.awt.geom.AreaOp;

/**
 * 构造链表，使用静态内部类定表示结点，实现增加和删除元素的功能
 */
public class BasicLinkList {
    public static void main(String[] args) {
        // 头部添加节点1
        Node head = new Node(1);
        System.out.println("头部添加节点1：" + BasicLinkList.toString(head));

        System.out.println("链表长度为：" + getLength(head));
        // 尾部添加节点2
        Node node = new Node(2);
        head = BasicLinkList.insertNode(head, node, 2);
        System.out.println("尾部添加节点2：" + BasicLinkList.toString(head));
        System.out.println("链表长度为：" + getLength(head));
        // 中间添加节点3
        node = new Node(3);
        head = BasicLinkList.insertNode(head, node, 2);
        System.out.println("中间添加节点3：" + BasicLinkList.toString(head));

        // 删除中间节点2
        head = BasicLinkList.deleteNode(head, 2);
        System.out.println("删除中间节点3：" + BasicLinkList.toString(head));

        // 删除头部节点1
        head = BasicLinkList.deleteNode(head, 1);
        System.out.println("删除头部节点1：" + BasicLinkList.toString(head));
    }

    /**
     * 获取链表长度
     *
     * @param head 链表头节点
     * @return 链表长度
     */
    public static int getLength(Node head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    /**
     * 链表插入
     *
     * @param head       链表头节点
     * @param nodeInsert 待插入节点
     * @param position   待插入位置，取值从2开始
     * @return 插入后得到的链表头节点
     */
    public static Node insertNode(Node head, Node nodeInsert, int position) {
        // 头节点非空判断
        if (head == null) {
            return nodeInsert;
        }
        int length = getLength(head);
        // 插入位置 界限判断
        if (position > length + 1 && position < 1) {
            System.out.println("界限判断未通过");
            return head;
        }
        // 表头插入
        if (position == 1) {
            nodeInsert.next = head;
            return nodeInsert;
        }
        int i = 1;
        Node pNode = head;
        while (i < position - 1) {
            pNode = head.next;
            i++;
        }
        nodeInsert.next = pNode.next;
        pNode.next = nodeInsert;
        return head;
    }

    /**
     * 删除节点
     *
     * @param head     链表头节点
     * @param position 删除节点位置，取值从1开始
     * @return 删除后的链表头节点
     */
    public static Node deleteNode(Node head, int position) {
        if (head == null) {
            return null;
        }
        int length = getLength(head);
        if (position < length && position < 1) {
            System.out.println("校验出错");
        }
        if (position == 1) {
            return head.next;
        } else {
            int count = 1;
            Node pNode = head;
            while (count < position - 1) {
                count++;
                pNode = pNode.next;
            }
            Node cur = pNode.next;
            pNode.next = cur.next;
        }
        return head;
    }

    /**
     * 输出链表
     *
     * @param head 头节点
     */
    public static String toString(Node head) {
        Node cur = head;
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.data).append("\t");
            cur = cur.next;
        }
        return sb.toString();
    }

    static class Node {
        final int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

}
