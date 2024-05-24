package org.zgd.other;

import java.util.Arrays;

/**
 * @description: TODO
 * @date: 2024/5/24 16:49
 * @author: zyk
 */

class ArrayQueue{

    // 基础数组队列功能, 入队, 出队
    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity){
        this.items = new String[capacity];
        this.n = capacity;
    }
    public boolean enqueue(String item){
        // 如果 tail == n 表示队列已经满了 触发搬移操作
        if (tail == n) {
            // 队列满了搬不了了
            if(head == 0) {
                return false;
            }
            int j = 0;
            for(int i = head; i < tail; i++){
                items[j] = items[i];
                j++;
            }
            tail -= head;
            head = 0;
        }
        // 入队tail后移
        items[tail] = item;
        tail++;
        return true;
    }

    public String dequeue(){
        // 如果 head == tail 表示队列为空
        if (head == tail) return null;
        // 出队头部后移
        String item = items[head];
        head++;
        return item;
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.enqueue("a");
        arrayQueue.enqueue("b");
        System.out.println(arrayQueue.dequeue());
        arrayQueue.enqueue("c");
//        System.out.println(arrayQueue.tail);
//        System.out.println(arrayQueue.head);
        arrayQueue.enqueue("d");
        System.out.println(Arrays.toString(arrayQueue.items));
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
    }

}
