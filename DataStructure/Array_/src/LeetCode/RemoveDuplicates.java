package LeetCode;

/**
 * @author yangrunze
 * LeetCode 27. 移除元素，要求是在当前数组本身中移除元素
 * 示例1: 输入：nums = [3,2,2,3], val = 3 输出：2, nums = [2,2]
 * 示例2: 输入：nums = [0,1,2,2,3,0,4,2], val = 2 输出：5, nums = [0,1,3,0,4]
 */
public class RemoveDuplicates {

    public static void main(String[] args) {

    }

    /**
     * 解法一: 双指针
     * 这种方法的核心是在于，因为我们想要将新的数组就放置在原始数组的位置，所以核心的步骤就是在于nums[left] = nums[right];
     * 这样做，就可以让右指针一直向右移动的过程中，不断判断，然后看是不是要放到左指针所在的位置
     * 最终返回 left 就是正确的结果。因为左指针指向的元素以及其左边的元素就是最终想要的数组的长度。
     * */
    private static int removeDuplicates(int[] nums, int val) {
        int slowPointer = 0;
        for (int fastPointer = 0; fastPointer < nums.length; fastPointer++) {
            if (nums[fastPointer] != val) {
                nums[slowPointer] = nums[fastPointer];
                slowPointer++;
            }
        }

        return slowPointer;
    }

    /**
     * 解法二: 双指针优化
     * */
    public static int removeDuplicates2(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            // 如果 left 指向的元素等于要移除的值 val，将 right - 1 指向的元素复制到 left 指向的位置，
            // 然后将 right 减一，即减少数组最终考虑的长度。
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                // 如果不等于，left 指针向右移动。
                left++;
            }
        }

        // 恰恰就是因为上面说的不等于要移除的值，所以 left 的值实际上表示的就是最终结果
        return left;
    }

    /**
     * 相向双指针，交换移除
     * 这种解法在力扣上出现问题，就是超出时间限制，复杂度很高
     * */
    private static int removeDuplicates3(int[] nums, int val) {
        int ans = nums.length;
        for (int i = 0; i < ans;) {
            // 判断左侧指针是否等于要删除的值
            if (nums[i] == val) {
                // 如果相等，就把右面的目标值交换到左边来, 这样也就同时做到了右指针左移
                nums[i] = nums[ans - 1];
            } else {
                // 如果不等，左侧指针右移
                i++;
            }
        }

        return ans;
    }
}
