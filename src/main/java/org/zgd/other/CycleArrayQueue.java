package org.zgd.other;

import java.util.Arrays;

/**
 * @description: TODO
 * @date: 2024/5/24 16:49
 * @author: zyk
 */

class CycleArrayQueue{

    // 基础数组队列功能, 入队, 出队
    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public CycleArrayQueue(int capacity){
        this.items = new String[capacity];
        this.n = capacity;
    }
    public boolean enqueue(String item){
        // 如果 (tail + 1)%n == head 表示队列已经满了, 环形队列不用搬移，不过天生少一个存储位，用来区分满队列和空队列
        if ( (tail + 1) % n == head) {
            // 队列满了进不了了
            return false;
        }
        // 入队tail后移, 环形后移
        int x = 1/0;
        items[tail] = item;
        if (n - tail == 1){
            tail = 0;
        } else {
            tail++;
        }
        return true;
    }

    public String dequeue(){
        // 如果 head == tail 表示队列为空
        if (head == tail) return null;
        // 出队头部后移,环形后移
        String item = items[head];
        if (n - head == 1){
            head = 0;
        } else {
            head++;
        }
        return item;
    }

    public static void main(String[] args) {
        CycleArrayQueue cyc = new CycleArrayQueue(3);
        cyc.enqueue("a");
        cyc.enqueue("b");
        System.out.println(cyc.dequeue());
        cyc.enqueue("c");
//        System.out.println(arrayQueue.tail);
//        System.out.println(arrayQueue.head);
        cyc.enqueue("d");
        System.out.println(Arrays.toString(cyc.items));
        System.out.println(cyc.dequeue());
        System.out.println(cyc.dequeue());
        System.out.println(cyc.dequeue());
    }

}
