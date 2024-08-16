package LeetCode;

import java.util.Arrays;

/**
 * @author ryanw
 * LeetCode 561: https://leetcode.cn/problems/array-partition/description/
 * 在这个问题中，排序后相邻的两个数构成一对是题目要求的配对方法，是解决这个问题的一部分。
 * 通过排序，我们能够确保每一对中第一个数字是小于等于第二个数字的，因为数组是按照非降序排列的。
 * 所以，当我们选择排序后的数组中的每个偶数索引的数时，
 * 我们实际上选择的是每一对中较小的数。
 * 这是题目设计的一个巧妙之处，确保你总是取到每一对中较小的那个数来相加。
 */
public class ArraySplit561 {
    public static void main(String[] args) {
        int[] arr = {2,4,6,4,3};
        System.out.println(arrayPairSum(arr));
    }

    public static int arrayPairSum(int[] arr) {
        // 首先对数组进行排序，这里巧妙的点就在于，数组经过排序之后，相邻的两个元素就应该结成一组。
        // 为什么呢？这是因为我们要找的是最小的所有两数组合之和。
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < arr.length; i += 2) {
            sum += arr[i];
        }
        return sum;
    }
}
