package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangrunze
 * LeetCode1002: https://leetcode.cn/problems/find-common-characters/description/
 * 查找字符串数组中多个元素的共有字符
 */
public class commonChars1002 {
    public static void main(String[] args) {

    }

    /**
     这个方法的核心概念有点像 LeetCode20，就是使用数组来模拟哈希表
     */
    public List<String> commonChars(String[] words) {
        // 创建 list 来存储最终结果
        List<String> result = new ArrayList<>();
        // 首先判断输入是否为空，为空则直接返回
        if (words.length == 0) {
            return result;
        }

        // 创建数组作为 hash table 来存储 26 个小写英文字母
        int[] hash = new int[26];

        // 使用数组中第一个元素，也就是第一个字符串来声明 hash table
        for (int i = 0; i < words[0].length(); i++) {
            hash[words[0].charAt(i) - 'a']++;
        }

        // 开始遍历输入的字符串数组中的第二个到最后一个字符串的重复字符出现频率
        // 从第二个元素开始，也就是第二个字符串，i = 1，填充新的 hash table
        for (int i = 1; i < words.length; i++) {
            // 声明另一个 hash table 也是用来承载 26 个英文字母，每个字母是一个字符
            int[] anotherHash = new int[26];
            // 遍历第二个元素，是一个字符串，所以这里要用 length() 带括号的
            // 说明：数组的 length 直接就用 length，字符串的长度要加上括号 length()
            for (int j = 0; j < words[i].length(); j++) {
                anotherHash[words[i].charAt(j) - 'a']++;
            }

            // 更新hash，保证hash里统计26个字符在所有字符串里出现的最小次数
            // 将新的 hash table 和原来的一开始的 hash table 放在 min 方法中得到最小值
            for (int k = 0; k < 26; k++) {
                hash[k] = Math.min(hash[k], anotherHash[k]);
            }

        }

        // 转换输出格式
        for (int i = 0; i < 26; i++) {
            // 不等于 0 的部分所对应的字母就是结果需要统计的字母
            while (hash[i] != 0) {
                char ch = (char) (i + 'a');
                result.add(String.valueOf(ch));
                // 结果数组中填充了一个字符，有些字符可能是大于 1 的，所以当前数值-1
                hash[i]--;
            }
        }

        return result;
    }
}
