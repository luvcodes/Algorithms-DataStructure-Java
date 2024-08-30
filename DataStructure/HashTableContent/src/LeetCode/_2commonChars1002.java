package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangrunze
 * LeetCode1002: 查找字符串数组中多个元素的共有字符
 */
public class _2commonChars1002 {
    public static void main(String[] args) {}

    /**
     这个方法的核心概念有点像 LeetCode20，就是使用数组来模拟哈希表
     */
    public List<String> commonChars(String[] words) {
        // 创建存储最终结果的ArrayList
        List<String> result = new ArrayList<>();
        if (words.length == 0) return result;

        // 存储26个英文字母
        int[] alphabet = new int[26];

        // 遍历words字符串数组的第一个元素，存储第一个字符串 (元素) 的每一个字符的ASCII码
        for (int i = 0; i < words[0].length(); i++) {
            alphabet[words[0].charAt(i) - 'a']++;
        }

        // 遍历第二个元素、以及剩下的元素，存储到新的数组中
        for (int i = 1; i < words.length; i++) {
            // 创建新的数组来存储除第一个字符串以外其他的字符串
            int[] anotherHash = new int[26];

            for (int j = 0; j < words[i].length(); j++) {
                anotherHash[words[i].charAt(j) - 'a']++;
            }

            // 更新结果数组，保证数组中26个字符的对应位置的值都是字符出现的最小次数
            for (int k = 0; k < 26; k++) {
                alphabet[k] = Math.min(alphabet[k], anotherHash[k]);
            }

        }

        // 输出最终结果，也就是说输出最终数组中的不为0的元素值所对应的字母
        for (int i = 0; i < 26; i++) {
            while (alphabet[i] != 0) {
                // 这里将当前索引 i 加上字符 'a' 的 ASCII 值，得到对应小写字母的 ASCII 值，
                // 然后将其强制转换为字符类型，得到了一个小写字母 ch。
                char ch = (char) (i + 'a');
                // 将字符 ch 转换为字符串, 添加到最终的结果ArrayList中result
                result.add(String.valueOf(ch));
                alphabet[i]--;
            }
        }

        return result;
    }
}
