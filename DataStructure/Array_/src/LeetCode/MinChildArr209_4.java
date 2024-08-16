package LeetCode;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0。
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * */
public class MinChildArr209_4 {
    public static void main(String[] args) {
        int[] nums = {1,2,2,1};
        int target = 1;
        System.out.println(minSubArrayLen(target, nums));
    }

    /**
     * 暴力解法
     * 这种方法现在力扣上已经是完全超出时间限制的解法了, 不过思路简单
     * */
    /*@SuppressWarnings("unused")
    private static int minSubArrayLen(int target, int[] nums) {

        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= target) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }

        // 返回最终结果
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }*/


    /**
     * 滑动窗口
     * 每一轮迭代，将 nums[end] 加到 sum，如果 sum ≥ s，则更新子数组的最小长度（此时子数组的长度是 end−start+1），
     * 然后将 nums[start] 从 sum 中减去并将 start 右移，直到 sum < s，在此过程中同样更新子数组的最小长度。
     * 在每一轮迭代的最后，将 end 右移。
     * */
    @SuppressWarnings("all")
    private static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;

        while (end < n) {
            // 将nums[end]添加到sum值上
            sum += nums[end];
            // 判断sum是否满足大于等于target的条件
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }

            end++;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
