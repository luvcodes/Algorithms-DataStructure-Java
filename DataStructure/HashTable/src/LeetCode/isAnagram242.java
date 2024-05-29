package LeetCode;

/**
 * @author ryanw
 * LeetCode242 有效的字母异位词: https://leetcode.cn/problems/valid-anagram/description/
 * s = "anagram", t = "nagaram"
 * true
 */
public class isAnagram242 {
    public static void main(String[] args) {

    }
}

/**
 暴力解法：两层循环嵌套
 */
/*class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int countS = 0;
            int countT = 0;

            // 先判断在s中的字符在s中出现的次数
            for (int j = 0; j < s.length(); j++) {
                if (ch == s.charAt(j)) {
                    countS++;
                }
            }

            // 判断在t中的字符在s中出现的次数
            for (int j = 0; j < t.length(); j++) {
                if (ch == t.charAt(j)) {
                    countT++;
                }
            }

            if (countS != countT) {
                return false;
            }
        }

        return true;
    }
}*/


/**
 * 哈希映射
 * 使用数组来承载26个字母，可以理解成s字符串负责添加数值，t字符串负责减少数值
 * 判断最后结果是不是整个数组的值都是0
 * */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // 定义一个数组，每个元素所对应的位置代表26个字母的位置
        int[] record = new int[26];

        // 使用字符串中的每一个字符与'a'相减，s字符串负责升高数值，t字符串负责降低数值
        // 判断升高的数值和降低的数值是否相平衡
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
            record[t.charAt(i) - 'a']--;
        }


        // 判断数组中的值是否都是0，如果不都是0，直接返回false，说明有重复的字符
        for (int i = 0; i < 26; i++) {
            if (record[i] != 0) {
                return false;
            }
        }

        // 全都通过，返回true
        return true;
    }
}
