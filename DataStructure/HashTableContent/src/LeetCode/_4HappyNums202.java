package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yangrunze
 *         LeetCode202: 判断是否为快乐数
 *         定义：一个数不断拆分成每个位的数字的平方和，不断计算，如果最终得到的结果为1，那么一开始的这个数就是快乐数。
 */
@SuppressWarnings("all")
public class _4HappyNums202 {
    public static void main(String[] args) {
        System.out.println(isHappy(21));
    }

    /**
     * 每次计算下一个数之前，都会检查这个数是否已经在record中。如果已经出现过，那么就意味着我们遇到了一个循环，
     * 可以立即停止计算并返回false。如果没有出现过，就将这个数添加到record中，然后继续计算下一个数。
     * @param n
     * @return
     */
    public static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }

        return n == 1;
    }

    /**
     * 计算方法：这个方法用于计算下一个数，即计算一个整数的每一位数字的平方和。
     */
    private static int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            // 通过n % 10获取n的最后一位数字，然后计算这个数字的平方，并将其累加到res上
            int d = n % 10;
            // 通过n/10去掉n的最后一位数字。
            n = n / 10;
            totalSum += d * d;
        }

        return totalSum;
    }

}
