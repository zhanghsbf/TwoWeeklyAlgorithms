package org.zgd.other;

import sun.plugin.javascript.navig.AnchorArray;

/**
 * @description: TODO
 * @date: 2024/5/23 17:40
 * @author: zyk
 */
public class LinkedTableQueue {
    Node head;
    Node tail;

    class Node{
        String item;
        Node prev;
        Node next;

        public Node(String item){
            this.item = item;
        }
    }
    public LinkedTableQueue(){

    }
    public boolean enqueue(String item){
        // 链表不用搬了
        Node newNode = new Node(item);
        if(tail == null){
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        return true;
    }

    public String dequeue(){
        // 如果 head == tail 表示队列为空
        if (head == null) return null;
        String item = head.item;
        if (head.next == null){
            tail = null;
            head = null;
        } else {
            head = head.next;
        }
        return item;
    }

    public static void main(String[] args) {
        LinkedTableQueue linkedQueue = new LinkedTableQueue();
        linkedQueue.enqueue("a");
        linkedQueue.enqueue("b");
        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.dequeue());
        linkedQueue.enqueue("c");

        linkedQueue.enqueue("d");

        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.dequeue());
    }
}
