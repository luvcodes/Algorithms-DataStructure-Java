package LeetCode;

/**
 * @author ryanw
 * Leetcode242: https://leetcode.cn/problems/valid-anagram/description/
 * 看是否两个string是anagram
 */
public class isAnagram242 {
    public static void main(String[] args) {

    }

    /**
     * 字母异位词解法
     * 1. 判断输入的两个字符串长度是否相等，如果不相等直接返回false，因为不可能是字母异位词
     * 2. 初始化int数组为26承载每一个字符的ASCII码
     * 3. 分别遍历字符串s和t，可以理解成分割成了两个数组，前13个位置负责增加数值，t负责再对应位置减少
     * 4. 遍历26位的数组，如果所有数值都为0，则s和t为字母异位词
     * */
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        // 定义一个数组，每个元素所对应的位置代表26个字母的位置
        int[] records = new int[26];

        // s字符串用来增加数值
        for (int i = 0; i < s.length(); i++) {
            // 例如，假设 s.charAt(i) 是 'c'：
            // 'c' - 'a' 的结果是 2，因为 'c' 是字母表中的第 3 个字母（从 0 开始计数：a 是 0，b 是 1，c 是 2）。
            // 这样做的目的是将字符映射到数组 records 的正确索引位置。因为英文字母一共有 26 个，records 数组的长度也是 26
            records[s.charAt(i) - 'a']++;
            records[t.charAt(i) - 'a']--;
        }

        // 经历上面的运算，判断数组中的所有数值是不是都等于0
        // 不等于0的话一定有多次出现的字母没有被消除
        for (int i = 0; i < 26; i++) {
            if (records[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
