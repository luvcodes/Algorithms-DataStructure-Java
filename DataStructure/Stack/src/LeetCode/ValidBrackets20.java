package LeetCode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author yangrunze
 * LeetCode20:https://leetcode.cn/problems/valid-parentheses/description/
 * 有效的括号
 */
public class ValidBrackets20 {
    public static void main(String[] args) {
        ValidBrackets20 brackets = new ValidBrackets20();
        // true
        System.out.println(brackets.isValid("()[]{}"));
        // false
        System.out.println(brackets.isValid("([)]"));
        // true
        System.out.println(brackets.isValid("{[]}"));
    }

    /**
     * 方法一: 使用 HashMap 来作为辅助实现
     * */
    // 使用 map 来存储所有的括号可能性
    private static final Map<Character, Character> map = new HashMap<>();

    static {
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        map.put('?', '?');
    }

    public boolean isValid(String s) {
        // 右括号不能出现在字符串的第一个位置，否则它无法匹配任何左括号，这样的字符串显然不可能是有效的括号字符串。
        if (s.length() > 0 && !map.containsKey(s.charAt(0))) return false;

        // 添加一个问号到栈中
        LinkedList<Character> stack = new LinkedList<>();
        stack.add('?');

        // 遍历字符串
        for (int i = 0; i < s.length(); i++) {
            // charAt 方法得到当前索引的字符串的字符
            char c = s.charAt(i);
            // containsKey 的意思就是判断是不是左括号
            if (map.containsKey(c)) {
                // 是左括号，添加到栈中
                stack.addLast(c);
            } else {
                // 不是左括号
                // removeLast 移除栈中的最后一个括号，这应该是最右边的左括号
                // 判断这个左括号所对应的右括号是否等于当前字符，不等，直接 false; 相等，就移除了这个左括号。
                if (map.get(stack.removeLast()) != c) return false;
            }
        }

        // 到这里，说明栈中只有一个初始添加进去的 ? 了
        // 证明当前字符串是一个有效字符串
        return stack.size() == 1;
    }

    // public static void main(String[] args) {
    //     Solution solution = new Solution();
    //     System.out.println(solution.isValid("()[]{}")); // true
    //     System.out.println(solution.isValid("([)]"));   // false
    //     System.out.println(solution.isValid("{[]}"));   // true
    // }
}

/**
 * 方法的核心逻辑就是通过指针来逐个将当前左括号所对应的右括号添加到栈内，
 * 当第一次碰到右括号的时候，检查这个右括号是否与栈顶元素相等，如果相等则弹出，说明匹配上了。
 * 这个逻辑就是因为压到栈内的都是右括号，一旦栈顶的元素与当前要压入的右括号相等，其实就证明有对应的左括号存在。
 * */
class Solution {
    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        char ch;

        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            // 碰到左括号，就把对应的右括号压入栈内
            if (ch == '(') {
                deque.push(')');
            } else if (ch == '[') {
                deque.push(']');
            } else if (ch == '{') {
                deque.push('}');
            } else if (deque.isEmpty() || deque.peek() != ch) {
                return false;
            } else {
                // 如果是右括号，判断是否与栈顶元素匹配。匹配的话，弹出括号。
                deque.pop();
            }
        }

        // 判断栈中元素是否匹配
        return deque.isEmpty();
    }
}
