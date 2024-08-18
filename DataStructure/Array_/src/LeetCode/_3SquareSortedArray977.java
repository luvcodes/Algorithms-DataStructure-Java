package LeetCode;

import java.util.Arrays;

/**
 * @author yangrunze
 * LeetCode997: 给一个按非递减顺序排序的整数数组 nums，
 * 返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 */
@SuppressWarnings("all")
public class _3SquareSortedArray977 {
    public static void main(String[] args) {
        int[] num = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares2(num)));
    }

    /**
     * 暴力解法
     */
    public static int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);
        return nums;
    }

    /**
     * 双指针解法
     * 1. 因为原数组已经排序，所以只有在最左端或者最右端的那个元素, 才有可能是平方之后最大的结果。
     * 2. 因此，就可以通过使用双指针的解法，将左指针放在原数组的左端，右指针放在最后一个元素
     * 3. 创建新的数组，来存储结果。使用第三个指针，从新数组的最右端逐渐向左添加元素
     * 4. 添加的判断逻辑：比较原数组的左指针指向元素的平方 和 原数组的右指针指向元素的平方，比较这两个值哪个更大，就把大的那个存储到新数组中
     * 5. 存储完成之后，将原数组存储进去的那个元素的所属指针，向原数组中心移动，这样就实现了从右往左 == 从大到小
     */
    public static int[] sortedSquares2(int[] nums) {

        // 创建新数组
        int[] result = new int[nums.length];
        // 原数组左指针
        int i = 0;
        // 原数组右指针
        int j = nums.length - 1;
        // 新数组指针指向最右侧
        int k = result.length - 1;

        while (i <= j) {
            // 条件判断
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                result[k] = nums[i] * nums[i];
                ++i;
                --k;
            } else {
                result[k] = nums[j] * nums[j];
                --j;
                --k;
            }
        }

        return result;
    }

    /**
     * 双指针解法
     */
    public static int[] sortedSquares3(int[] nums) {
        int n = nums.length;
        int negative = -1;
        for (int i = 0; i < n; ++i) {
            if (nums[i] < 0) {
                negative = i;
            } else {
                break;
            }
        }

        int[] ans = new int[n];
        int index = 0, i = negative, j = negative + 1;
        while (i >= 0 || j < n) {
            if (i < 0) {
                ans[index] = nums[j] * nums[j];
                ++j;
            } else if (j == n) {
                ans[index] = nums[i] * nums[i];
                --i;
            } else if (nums[i] * nums[i] < nums[j] * nums[j]) {
                ans[index] = nums[i] * nums[i];
                --i;
            } else {
                ans[index] = nums[j] * nums[j];
                ++j;
            }
            ++index;
        }

        return ans;
    }

}
