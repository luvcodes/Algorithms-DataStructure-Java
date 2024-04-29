package LeetCode;

/**
 * @author yangrunze
 * LeetCode 27. 移除元素
 * 示例1: 输入：nums = [3,2,2,3], val = 3 输出：2, nums = [2,2]
 * 示例2: 输入：nums = [0,1,2,2,3,0,4,2], val = 2 输出：5, nums = [0,1,3,0,4]
 */
public class RemoveDuplicates {
    public static void main(String[] args) {

    }
    /**
     * 解法一: 双指针
     * */
    public static int removeDuplicates(int[] nums, int val) {
        int left = 0;
        int len = nums.length - 1;

        for (int right = 0; right < len; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }

        return left;
    }

    /**
     * 解法二: 双指针优化
     * */
    public static int removeDuplicates2(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }

        return left;
    }
}
