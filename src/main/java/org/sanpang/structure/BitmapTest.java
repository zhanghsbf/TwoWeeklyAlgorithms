package org.sanpang.structure;

import java.util.BitSet;

public class BitmapTest {
    public static void main(String[] args) {
        //自定义实现,创建一个5亿大小的位图。如果超过int的最大值，得考虑用byte[][]实现底层存储
        Bitmap bitmap = new Bitmap(500000000);
        System.out.println(bitmap.contain(19));
        bitmap.add(19);
        System.out.println(bitmap.contain(19));
        bitmap.delete(19);
        System.out.println(bitmap.contain(19));
        System.out.println(bitmap.size());


        //java库类
        BitSet bitSet = new BitSet(500000000);
        bitSet.set(19);
        System.out.println(bitSet.get(19));
        System.out.println(bitSet.size());


    }

}
class Bitmap {
    private byte[] bits ;
    private int capacity;

    public Bitmap(int capacity) {
        this.capacity = capacity;
        this.bits = new byte[(capacity >> 3) + 1];
    }

    public void add(int num) {
        int arrayIndex = num >> 3; //19 -> 10011 -> 10 -> 2 等同于除以8取整数部分，意味着对应下标为2的字节
        int position = num & 0x07; //19 & 00000111 = 3 取余数部分，意味着应该对应bit[2]字节中的第3位（0-7中的3）
        bits[arrayIndex] |= (0x01 << position); //将bit[2]的第3位设为1，其余位保留原来的值
    }

    public boolean contain(int num) {
        int arrayIndex = num >> 3;
        int position = num & 0x07;
        return (bits[arrayIndex] & (0x01 << position)) != 0;
    }

    public void delete(int num) {
        int arrayIndex = num >> 3;
        int position = num & 0x07; // 3
        bits[arrayIndex] &= ~(0x01 << position); // 0000 1000 & 1111 0111
    }

    public String size() {
        return (this.bits.length / 1024 / 1024  + "M");
    }
}
