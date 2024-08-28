package LeetCode;

import java.util.Arrays;

/**
 * @author ryanw
 * Leetcode242: https://leetcode.cn/problems/valid-anagram/description/
 * 看是否两个string是anagram
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 */
@SuppressWarnings("all")
public class _1isAnagram242 {
    public static void main(String[] args) {}

    /**
     * 方法一: 对字符串 s 和 t 分别排序，看排序后的字符串是否相等即可判断
     * */
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    /**
     * 方法二
     * 1. 判断输入的两个字符串长度是否相等，如果不相等直接返回false，因为不可能是字母异位词
     * 2. 初始化int数组为26承载每一个字符的ASCII码
     * 3. 分别遍历字符串s和t，可以理解成分割成了两个数组，前13个位置负责增加数值，t负责再对应位置减少
     * 4. 遍历26位的数组，如果所有数值都为0，则s和t为字母异位词
     * */
    public boolean isAnagram3(String s, String t) {
        int[] record = new int[26];

        for (int i = 0; i < s.length(); i++) {
            // s.charAt(i) - 'a'这个意思就是对应到了26个字母中当前这个指针指向s的某一个字母的所对应的位置
            // 因为初始化了record数组，所以i = 0的时候数组26个元素都是0，现在数值+1，那么就代表当前指针指向的字母存储到了record数组中
            record[s.charAt(i) - 'a']++;
        }

        // 遍历t字符串，再把上面已经更新过的record数组对应的字母位的值减一
        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }

        for (int count : record) {
            // record数组如果有的元素不为零0，说明字符串s和t 一定是谁多了字符或者谁少了字符。
            if (count != 0) {
                return false;
            }
        }

        // record数组所有元素都为零0，说明字符串s和t是字母异位词
        return true;
    }

}
