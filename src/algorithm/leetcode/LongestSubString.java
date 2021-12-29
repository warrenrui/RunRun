package algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode-cn.com/articles/longest-substring-without-repeating-characters/
 * 无重复字符的最长子串
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 * <p>
 * 输入: s = ""
 * 输出: 0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class LongestSubString {

    /**
     * 滑动窗口是数组/字符串问题中常用的抽象概念。
     * 窗口通常是在数组/字符串中由开始和结束索引定义的一系列元素的集合，即 [i, j)[i,j)（左闭，右开）。
     * 而滑动窗口是可以将两个边界向某一方向“滑动”的窗口。例如，我们将 [i, j)[i,j) 向右滑动 11 个元素，
     * 则它将变为 [i+1, j+1)[i+1,j+1)（左闭，右开）。
     * <p>
     * 当前窗口 [i,j)，最初 i == j，用 HashSet 存储窗口数据集
     * 向右滑动索引 j ，如果 j 不在窗口中，放入窗口，继续向右滑动窗口。
     * 直到 j 已经存在于窗口中。此时得到，以 i 开头的无重复最长子串
     * 向右滑动 i，重复滑动索引 j 的逻辑，比较最长子串的长度
     * 最终得到最长的。
     */
    public static int longestSubStr(String source) {
        int length = source.length();
        int mark = 0, i = 0, j = 0;
        HashSet<Object> set = new HashSet<>();
        while (i < length && j < length) {
            if (set.contains(source.charAt(j))) {
                set.remove(source.charAt(i));
                i++;
            } else {
                set.add(source.charAt(j));
                j++;
                mark = Math.max(mark, j - i);

            }
        }
        return mark;
    }

    /**
     * 需要向右滑动 i 的时候，滑动窗口 [i,j）中存在 m 位置，与 j 位置字符相同
     * 当 i <= m 时，滑动窗口 [i,j）中总是存在 m 位置，与 j 位置字符相同
     * 因为要的是最长无重复子串
     * 当 i <= m 时，得出的无重复子串，长度总是小于 j - i，
     * 因此，
     * 1.i 可以直接滑动到 m+1
     * 2.位置 j，对应的最长无重复子串，是固定不变的
     * 3.按照这种方式继续滑动，对比每一个位置对应的固定不变的最长无重复子串，即可得出最大值
     * 例如：abccbc
     * 滑动窗口 [ 0,3 ) 是 abc ，第 3 位是c，与第 2 位 c 相同。i=0，j=3，m = 2
     * i 逐步滑动时，
     * [1,3) ，bc，到第 3 位出现重复
     * [2,3)，c，到第 3 位出现重复
     * bc，c 长度肯定都是小于 abc，
     * 因此，
     * 1.i 可以直接滑到 m+1 = 3
     * 2.第三位，对应的最长无重复子串，是固定不变的，abc，长度 3
     * 得到滑动窗口 [3,3)
     * TODO
     * @param source
     * @return
     */
    public static int longestSubString(String source) {
        int length = source.length();
        int mark = 0, i = 0, j = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (i < length && j < length) {
            if (map.containsKey(source.charAt(j))) {
                i = 0;
            }
            mark = Math.max(mark, j - i + 1);
            map.put(source.charAt(j), j + 1);
            j++;
        }
        return mark;
    }

    public static void main(String[] args) {
        System.out.println(longestSubStr("abcabcbb") == 3);
        System.out.println(longestSubStr("bbbbb") == 1);
        System.out.println(longestSubStr("pwwkew") == 3);
        System.out.println(longestSubStr("") == 0);
    }

}
