package LeetCode;

/**
 * @author yangrunze
 * LeetCode 27. 移除元素，要求是在当前数组本身中移除元素
 * 示例1: 输入：nums = [3,2,2,3], val = 3 输出：2, nums = [2,2]
 * 示例2: 输入：nums = [0,1,2,2,3,0,4,2], val = 2 输出：5, nums = [0,1,3,0,4]
 */
public class RemoveDuplicates27_2 {

    public static void main(String[] args) {}

    /**
     * 解法一: 双指针
     * 这种方法的核心是在于，因为我们想要将新的数组就放置在原始数组的位置，所以核心的步骤就是在于nums[left] = nums[right];
     * 这样做，就可以让右指针一直向右移动的过程中，不断判断，然后看是不是要放到左指针所在的位置
     * 最终返回 left 就是正确的结果。因为左指针指向的元素以及其左边的元素就是最终想要的数组的长度。
     * 这样做的核心原因主要是在于，我们最终想要的是移除目标元素之后的数组。
     * */
    private static int removeDuplicates(int[] nums, int val) {
        int slowPointer = 0;
        for (int fastPointer = 0; fastPointer < nums.length; fastPointer++) {
            if (nums[fastPointer] != val) {
                // 这其实就是在做移除操作，就是后面的元素覆盖前面的元素
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
     * 这种解法在力扣上出现问题，就是超出时间限制
     * 在这段代码中，不返回 i 的值而是返回 ans 的值，是因为 i 只是用于遍历数组的索引，它并不能准确反映经过移除操作后数组中有效元素的数量。
     * i 会一直增加，直到遍历完整个数组或者遇到某些条件提前结束循环。
     * 但在移除元素的过程中，数组的长度实际上是在变化的（因为有元素被覆盖掉了），而 ans 始终记录的是经过移除操作后剩余的有效元素的数量。
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
