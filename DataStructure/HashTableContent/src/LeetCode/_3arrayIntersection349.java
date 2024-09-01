package LeetCode;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

/**
 * @author yangrunze
 * LeetCode349: 两个数组的交集，输出结果中的每个元素一定是唯一的，不考虑输出结果的顺序。
 */
@SuppressWarnings("all")
public class _3arrayIntersection349 {
    public static void main(String[] args) {}

    /**
     * 方法一: HashSet的方法
     * */
    public int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }

        // 声明两个Set，一个用来承接，一个用来作为最终结果
        Set<Integer> set = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        for (int num : nums2) {
            // 判断是否已经包含了set1中存储的nums1数组中的元素值
            if (set.contains(num)) {
                resultSet.add(num);
            }
        }

        // 转化Set为数组
        int[] finalResult = new int[resultSet.size()];
        int j = 0;
        for (int i : resultSet) {
            finalResult[j++] = i;
        }

        return finalResult;
    }

    /**
     * 方法二: 使用Hash数组
     * 力扣更新了题目描述和后台测试数据，增添了数值范围：
     * 1 <= nums1.length, nums2.length <= 1000
     * 0 <= nums1[i], nums2[i] <= 1000
     * 所以就可以使用数组来做哈希表了，因为数组都是 1000以内的。
     * */
    public int[] intersection3(int[] nums1, int[] nums2) {
        // 声明两个数组分别存储nums1和nums2的元素值
        int[] hash1 = new int[1002];
        int[] hash2 = new int[1002];
        for(int i : nums1) hash1[i]++;
        for(int i : nums2) hash2[i]++;

        // 初始化一个ArrayList，存储最终结果，如果两个数组的同一个指向都不为0，那么就添加到结果ArrayList中
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < 1002; i++) {
            if (hash1[i] == hash2[i]) {
                resultList.add(i);
            }
        }

        // 转换ArrayList成数组形式
        int index = 0;
        int[] finalResult = new int[resultList.size()];
        for (int i : resultList) {
            finalResult[index++] = i;
        }

        return finalResult;
    }

    public int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        return getIntersection(set1, set2);
    }

    /**
     * 递归法
     * */
    public int[] getIntersection(Set<Integer> set1, Set<Integer> set2) {
        if (set1.size() > set2.size()) {
            return getIntersection(set2, set1);
        }
        Set<Integer> intersectionSet = new HashSet<>();
        for (int num : set1) {
            if (set2.contains(num)) {
                intersectionSet.add(num);
            }
        }
        int[] intersection = new int[intersectionSet.size()];
        int index = 0;
        for (int num : intersectionSet) {
            intersection[index++] = num;
        }
        return intersection;
    }


}
