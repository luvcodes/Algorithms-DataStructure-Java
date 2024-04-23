package LeetCode;

/**
 * @author yangrunze
 * 这个题是LeetCode的题目，编号724，1991是一样的题目需求
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 */
public class GetCenterIndex {
    public static void main(String[] args) {
        // 输出结果是返回的中心数组的下标
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }
    public static int pivotIndex(int[] nums) {
        // 方法一: 前缀和
        // 定义全部元素之和为total
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        // 左侧之和为sum，那么右侧之和就是 total - sum - nums[i]
        // 那么整体的total = sum + sum + nums[i]
        int sum = 0;
        // 遍历数组检查情况
        for (int i = 0; i < nums.length; i++) {
            if (2 * sum + nums[i] == total) {
                // 如果左侧之和等于右侧之和，那么直接返回当前数组的下标
                return i;
            }
            sum += nums[i];
        }

        // 否则返回-1
        return -1;
    }
}
