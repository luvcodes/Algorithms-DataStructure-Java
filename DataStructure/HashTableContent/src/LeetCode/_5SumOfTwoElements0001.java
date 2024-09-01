package LeetCode;

import java.util.HashMap;

/**
 * LeetCode0001: 两数之和，给定target，找出数组中的两个数相加为target值的元素下标
 * */
@SuppressWarnings("all")
public class _5SumOfTwoElements0001 {
    public static void main(String[] args) {}

    /**
     * 方法一: 暴力解法
     * 时间复杂度：O(N ^ 2)，其中 N 是数组中的元素数量。最坏情况下数组中任意两个数都要被匹配一次。
     * 空间复杂度：O(1)
     * 当我们使用遍历整个数组的方式寻找 target - x 时，需要注意到每一个位于 x 之前的元素都已经和 x 匹配过，
     * 因此不需要再进行匹配。而每一个元素不能被使用两次，所以我们只需要在 x 后面的元素中寻找 target - x。
     * */
    public static int[] getSum(int[] arr, int target) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (arr[i] + arr[j] == target) {
                    return new int[]{arr[i], arr[j]};
                }
            }
        }

        return new int[0];
    }

    /**
     * 方法二: 使用哈希表，可以将寻找 target - x 的时间复杂度降低到从 O(N) 降低到 O(1)。
     * 这样我们创建一个哈希表，对于每一个 x，我们首先查询哈希表中是否存在 target - x，
     * 然后将 x 插入到哈希表中，即可保证不会让 x 和自己匹配。
     * HashMap: key->元素值, value->下标
     * 这样存储的原因是key存储元素值才能把元素查出来，然后去访问下标
     * */
    public static int[] twoSum(int[] nums, int target) {
        // 创建HashMap
        HashMap<Integer, Integer> map = new HashMap<>();

        // 遍历nums数组，查找target-nums[i]是否存在于map中
        for (int i = 0; i < nums.length; i++) {
            // 如果存在，返回i 和 nums.length-i 作为最终结果，证明找到了目标的”两数“
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            // 不存在就将当前数及下标存入map中 继续遍历
            map.put(nums[i], i);
        }


        return new int[0];
    }
}
