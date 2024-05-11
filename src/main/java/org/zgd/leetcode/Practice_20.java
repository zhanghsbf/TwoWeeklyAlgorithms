package org.zgd.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @description:
 * @date: 2024/5/11 16:02
 * @author: zyk
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class Practice_20 {
    public static boolean isValid(String s) {
        // 1. 奇数肯定无效 2.
        //  假设不考虑这种情况{()}()
        Map<Character, Character> pair = new HashMap<>();
        pair.put('(', ')');
        pair.put('[', ']');
        pair.put('{', '}');

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if(pair.containsKey(chars[i])){
                stack.push(chars[i]);
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                Character pop = stack.pop();
                if(pair.get(pop).equals(chars[i])){
                    continue;
                } else {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }
}
