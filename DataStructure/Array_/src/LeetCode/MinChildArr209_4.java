package LeetCode;

public class MinChildArr209_4 {
    public static void main(String[] args) {

    }

    /**
     * 暴力解法
     * 这种方法现在力扣上已经是完全超出时间限制的解法了, 不过思路简单
     * */
    @SuppressWarnings("unused")
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
    }
}
