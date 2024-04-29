package org.crc.hw.code;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 第二题：
 * 给你一个整数数组nums，请计算数组的中心位置。
 * 数组的中心位置是数组的一个下标， 其左侧所有元素相乘的积等于右侧所有元素相乘的积。
 * 数组第一个元素的左侧积为1，最后一个元素的右侧积为1。
 * 如果数组有多个中心位置，应该返回最靠近左边的那一个，如果数组不存在中心位置，返回-1。
 *
 * 输入
 * 2 5 3 6 5 6
 * 输出
 * 3
 */
public class CT02 {
    public static void main(String[] args) {
        findArrayMiddle();
    }

    public static void findArrayMiddle(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一组整数数组，以空格隔开（如：a b c）：");
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        int[] ins = Arrays.stream(s1).mapToInt(Integer::parseInt).toArray();
        int left = 1;
        int right = 1;
        int middle = -1;
        for (Integer in : ins) {
            right *= in;
        }
        for (int i = 0; i < ins.length; i++) {
            right /= ins[i];
            if (left == right) {
                middle = i;
            }else {
                left *= ins[i];
            }
        }
        System.out.println("输出：\n" + middle);
    }
}
