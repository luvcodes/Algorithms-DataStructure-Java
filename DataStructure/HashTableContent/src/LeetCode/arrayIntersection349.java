package LeetCode;


import java.util.HashSet;
import java.util.Set;

/**
 * @author yangrunze
 * LeetCode349: https://leetcode.cn/problems/intersection-of-two-arrays/
 * 两个数组的交集，输出结果中的每个元素一定是唯一的，不考虑输出结果的顺序。
 */
public class arrayIntersection349 {
    public static void main(String[] args) {

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        return getIntersection(set1, set2);
    }

    public int[] getIntersection(Set<Integer> set1, Set<Integer> set2) {
        if (set1.size() > set2.size()) {
            return getIntersection(set2, set1);
        }
        Set<Integer> intersectionSet = new HashSet<Integer>();
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
