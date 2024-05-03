package LeetCode;

/**
 * @author yangrunze
 * 题目: LeetCode 485. 最大连续 1 的个数
 * 给定一个二进制数组nums，计算其中最大连续 1 的个数。
 */
public class maxLengthOfOnes {
    public static void main(String[] args) {
        int ones = maxLengthOfOnes(new int[]{1, 2, 3, 4, 1, 1, 1, 2, 1, 1, 1, 1});
        System.out.println(ones);
    }

    /**
     * 实现方法: 一次遍历
     * */
    public static int maxLengthOfOnes(int[] nums) {
        // 最大 1 的个数 (要返回的最终结果)
        int maxCount = 0;
        // 当前连续的 1 的个数
        int count = 0;
        int n = nums.length;

        // 开始遍历，如果当前元素是 1，那么就更新 count++
        // 如果当前元素不是 1 了，那么就将之前已经记录好的 count 值，赋给 maxCount，然后把当前的 count 值清零
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                // 使用之前的连续 1 的个数更新最大的连续 1 的个数，并将当前的连续 1 的个数清零
                // 这里使用 Math.max()方法的原因主要是用来更新记录的最长连续1的长度
                // 每当遍历到数组中的0，或者数组遍历完成时，
                // 我们都会用这个函数比较当前连续1的长度 (count) 和之前记录的最长长度 (maxCount)，
                // 然后将较大的值保存为新的最长长度。
                maxCount = Math.max(maxCount, count);
                // 将当前的连续的 1 的个数的统计数重置为 0
                count = 0;
            }
        }

        // 在代码末尾的`maxCount = Math.max(maxCount, count);`语句是必要的，
        // 因为数组的最后一段可能是连续的1。如果数组以1结束，那么在循环结束时，`count`变量会记录这最后一段1的长度，
        // 但由于没有更多的0来触发`maxCount`的更新，所以需要在循环外再次比较`maxCount`和`count`。
        // 这样可以确保即使数组末尾是连续的1，我们也能正确计算出最大连续1的个数。
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }
}
