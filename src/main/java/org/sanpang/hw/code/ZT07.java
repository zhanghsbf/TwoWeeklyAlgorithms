package org.sanpang.hw.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class ZT07 {
    public static void main(String[] args) {

//        100个人围成一圈，每个人有一个编码，编号从1开始到100。他们从1开始依次报数，报到为M的人自动退出圈圈，然后下一个人接着从1开始报数，直到剩余的人数小于M。请问最后剩余的人在原先的编号为多少？
//        输入描述:
//        输入一个整数参数M
//        输出描述:
//        如果输入参数M小于等于1或者大于等于100，输出“ERROR!”；否则按照原先的编号从小到大的顺序，以英文逗号分割输出编号字符串
//        示例1：
//        输入
//        3
//        输出
//        58,91
//        说明
//        输入M为3，最后剩下两个人
//        示例2：
//        输入
//        4
//        输出
//        34,45,97

        //接收输入参数，并解析
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(sc.nextLine());

        //判断合法性
        if ( m <= 1 || m >= 100 ) {
            System.out.println("ERROR!");
            return;
        }

        //生成数据
        ArrayList<Integer> arr = new ArrayList<Integer>(100);
        for (int i = 1; i < 101; i++) {
            arr.add(i);
        }

        //循环移除序号为M的元素，直至元素个数小于M。
        int seq = 1;
        while ( arr.size() >= m ) {
            Iterator<Integer> iterator = arr.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if ( seq == m ) {
                    iterator.remove();
                    seq = 1;
                    continue;
                }
                seq++;
            }
        }
        Collections.sort(arr);
        System.out.println(arr);


    }
}
