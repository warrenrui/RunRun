package algorithm.leetcode;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


/**
 * 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * 示例2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例3：
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * 示例4：
 * <p>
 * 输入：s = "([)]"
 * 输出：false
 * 示例5：
 * <p>
 * 输入：s = "{[]}"
 * 输出：true
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class ValidParentheses {

    public static void main(String[] args) {
        Assert.assertTrue(isValid(""));
        Assert.assertTrue(isValid(""));
        Assert.assertTrue(isValid("()"));
        Assert.assertTrue(isValid("()[]{}"));
        Assert.assertFalse(isValid("(]"));
        Assert.assertFalse(isValid("([)]"));
        Assert.assertTrue(isValid("{[]}"));

        Assert.assertTrue(isValidToo(""));
        Assert.assertTrue(isValidToo("()"));
        Assert.assertTrue(isValidToo("()[]{}"));
        Assert.assertFalse(isValidToo("(]"));
        Assert.assertFalse(isValidToo("([)]"));
        Assert.assertTrue(isValidToo("{[]}"));

        System.out.println("success!!!!");
    }


    private static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for (int i = 0; i < str.length(); i++) {
            if (map.containsValue(str.charAt(i))) {
                stack.push(str.charAt(i));
                continue;
            }
            if (stack.isEmpty() || stack.pop() != map.get(str.charAt(i))) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private static boolean isValidToo(String str) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        for (int i = 0; i < str.length(); i++) {
            final char character = str.charAt(i);
            if (map.containsKey(character)) {
                stack.push(character);
                continue;
            }
            if (stack.isEmpty() || map.get(stack.pop()) != character) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
