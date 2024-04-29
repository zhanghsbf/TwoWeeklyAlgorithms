package org.crc.hw.code;

import java.util.*;

/**
 * 第一题：intervalOverlap
 * 给定坐标轴上的一组线段，线段的起点和终点均为整数并且长度不小于1，请你从中找到最少数量的线段，这些线段可以覆盖住所有线段。
 *
 * 输入描述
 * 第一行输入为所有线段的数量，不超过10000，后面每行表示一条线段，格式为”x,y”，
 * x和y 分别表示起点和终点，取值范围是[-10^5 ，10^5]。
 * 输出描述
 *
 * 最少线段数量，为正整数。
 * 输入
 * 3
 * 1,4
 * 2,5
 * 3,6
 * 输出
 * 2
 */
public class CT01 {
    public static void main(String[] args) {
        intervalOverlap();
    }

    public static void intervalOverlap(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入所有线段的数量和线段坐标：");
        int n = Integer.parseInt(scanner.nextLine()); // 所有线段的数量
        int[][] segments = new int[n][2];
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            String[] split = s.split(",");
            segments[i][0] = Integer.parseInt(split[0]);
            segments[i][1] = Integer.parseInt(split[1]);
        }

        int result = minSegments(segments);
        System.out.println("输出：\n"+result);
    }

    public static int minSegments(int[][] segments) {
        if (segments == null || segments.length == 0) {
            return 0;
        }
        System.out.println("-----------------------");
        // 将所有线段按照起点从小到大排序
        Arrays.sort(segments, Comparator.comparingInt((int[] ints) -> ints[0]).thenComparingInt(ints -> ints[1]));
        for (int[] segment : segments) {
            System.out.println(segment[0]+":"+segment[1]);
        }

        int count = 0;              //要输出的线段数量（统计能覆盖所有线段的线段）
        int start_index = 0;        //上一条线段覆盖长度的起点
        int end_index = 0;          //上一条线段覆盖的终点
        int min_end_index = 0;      //前面所有线段中，取小于当前线段的起点的最大终点值

        for (int i = 0; i < segments.length; i++) {
            //x:当前线段的起点，y:当前线段的终点
            int x = segments[i][0];
            int y = segments[i][1];
            //第一条线段赋值
            if(i == 0){
                start_index = x;
                end_index = y;
                count ++;
                continue;
            }

            if(x > end_index){
                count ++;
                end_index = y;
                start_index = x;
            }else {
                end_index = Math.max(y, end_index);
                if(x > (min_end_index - 1)){
                    start_index = Math.max(x, start_index);
                    count++;
                    min_end_index = y;
                }
            }
        }

        return count;
    }
}
