package org.zgd.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @description:
 * @date: 2024/5/11 16:02
 * @author: zyk
155. 最小栈
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

实现 MinStack 类:

MinStack() 初始化堆栈对象。
void push(int val) 将元素val推入堆栈。
void pop() 删除堆栈顶部的元素。
int top() 获取堆栈顶部的元素。
int getMin() 获取堆栈中的最小元素。


示例 1:

输入：
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

输出：
[null,null,null,null,-3,null,0,-2]

解释：
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.

提示：

-231 <= val <= 231 - 1
pop、top 和 getMin 操作总是在 非空栈 上调用
push, pop, top, and getMin最多被调用 3 * 104 次
 */
public class Practice_155 {


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

}

class MinStack {
    // 需要支持动态扩容
    int[] stack;
    // 当前数据量
    int count;

    // O(1)复杂度查询最小值
    int minVal;

    // 最小值栈，实现O(1)时间复杂度查询
    Stack<Integer> minStack;

    public MinStack() {
        stack = new int[8];
        count = 0;
        minStack = new Stack<>();
    }

    public void expand(){
        if( count >= stack.length * 0.75){
            stack = Arrays.copyOf(stack, stack.length * 2);
        }
    }


    public void push(int val) {
        // 正常入栈;  累计最小值; 检测是否需要扩容;
        stack[count++] = val;

        if(minStack.empty()){
            minStack.push(val);
        } else {
            minVal = minStack.peek();
            if(minVal >= val){
                minStack.push(val);
            }
        }


        expand();
    }

    public void pop() {
        // 正常出栈; 累计最小值
        int top = stack[--count];
//        System.out.println(String.format("top %d, count %d", top, count));
        minVal = minStack.peek();
        if(minVal == top){
            minStack.pop();
        }
    }

    public int top() {
        return stack[count-1];
    }

    public int getMin() {
        return minStack.peek();
    }
}