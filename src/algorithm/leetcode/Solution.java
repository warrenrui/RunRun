package algorithm.leetcode;

import java.util.Arrays;

/**
 * https://gitcode.net/mirrors/luliyucoordinate/leetcode?utm_source=csdn_github_accelerator
 * https://www.jiuzhang.com/solution/3sum-closest/
 *
 * 解法思路
 * 本题是[57. 三数之和](https://www.lintcode.com/problem/3sum/description)的扩展问题，不再要求恰好相等，而是找与target最接近的三数之和。
 * 本题需要计算三数之和，如果用暴力枚举，时间复杂度会是 O( n3)。
 * 我们这里采用双指针的方法，来降低时间复杂度。首先将数组排序，然后固定一个数numbersi上用双指针来找与target最接近的三数之和nearest。
 * <p>
 * 算法流程
 * 第一步，对数组进行排序。只有将数组转化为有序数组，我们才方便移动双指针。
 * 第二步，在数组numbers中遍历，每次固定numbers[i]作为第一个数
 * 建立双指针left和right，初始化分别指向i + 1和len(numbers) - 1
 * 求出此时的三数之和curr，如果curr和target恰好相等，我们可以直接返回target。
 * 比较curr和nearest谁距离target更近，如果是curr，那么将nearest更新为target
 * 判断curr和target的大小关系，如果curr > target，那么right左移；反之，left右移。继续第二步的过程，直到left >= right。
 * 此外，当数组中有重复元素时，为了避免重复运算，在代码中添加了三处剪枝操作。当指针指向新的位置和旧的位置的值相等时，我们继续移动指针。
 * 算法复杂度
 * 时间复杂度
 * 数组排序的时间复杂度为
 * O(nlogn)遍历过程，固定值为 n 次，双指针为 n 次，时间复杂度为
 * O(n2))
 * 总时间复杂度：O ( n l o g n ) + O ( n 2 ) = O ( n 2 )
 * 空间复杂度为O（1），只需要常量空间。
 */
public class Solution {

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        System.out.println(threeSumClosest(numbers, 3) == 20);
        System.out.println(findBestValue(numbers, 3) == 20);
        int[] numbers2 = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(numbers2, 1) == 2);
        System.out.println(findBestValue(numbers2, 1) == 2);
    }

    /**
     * @param numbers: Give an array numbers of n integer
     * @param target:  An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    public static int threeSumClosest(int[] numbers, int target) {
        int nearest = Integer.MAX_VALUE;
        // step1: 首先对数组进行排序
        Arrays.sort(numbers);
        // step2: 遍历
        for (int i = 0; i < numbers.length - 2; i++) {
            // 剪枝1
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            // 定义双指针
            int left = i + 1;
            int right = numbers.length - 1;
            // 双指针相向而行
            while (left < right) {
                int curr = numbers[i] + numbers[left] + numbers[right];
                // 和恰好为target
                if (curr == target) {
                    return target;
                }
                // 更新nearest
                if (Math.abs(curr - target) < Math.abs(nearest - target)) {
                    nearest = curr;
                }
                // 移动双指针
                if (curr > target) {
                    right -= 1;
                    // 剪枝2
                    while (right >= 0 && numbers[right] == numbers[right + 1]) {
                        right -= 1;
                    }
                } else {
                    left += 1;
                    // 剪枝3
                    while (left < numbers.length && numbers[left] == numbers[left - 1]) {
                        left += 1;
                    }
                }
            }
        }
        return nearest;
    }

    public static int findBestValue(int[] A, int target) {
        Arrays.sort(A);
        int maxv = A[A.length - 1], t = 0;

        while (t < A.length && target >= A[t] * (A.length - t)) {
            target -= A[t++];
        }
        return t == A.length ? maxv : (int) (target * 1.0 / (A.length - t) + 0.49);
    }
}
