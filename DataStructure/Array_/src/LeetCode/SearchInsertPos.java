package LeetCode;

/**
 * LeetCode题目编号35，搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * @author yangrunze
 */
public class SearchInsertPos {
    public static void main(String[] args) {
        searchInsert(new int[]{1, 2, 3}, 0);
    }

    public static int searchInsert(int[] nums, int target) {
        // 使用二分查找的方法
        // 首先得到nums数组的长度
        int n = nums.length;

        // 判断如果二分之后的结果小于target，right左移，如果大于target，right右移
        int left = 0;
        int right = n - 1;
        int answer = n;

        while (left <= right) {
            // 如果 target 小于等于 nums[mid]：表明target的插入位置应该不超过mid，所以将answer更新为mid。
            // 更新right为mid - 1，继续在左半部分搜索。
            // 如果 target 大于 nums[mid]：更新left为mid + 1，表示target应在右侧查找。
            // left + (right - left) / 2
            int mid = left + ((right - left) >> 1);
            if (target <= nums[mid]) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}
