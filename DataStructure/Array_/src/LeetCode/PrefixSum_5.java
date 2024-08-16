package LeetCode;

import java.util.Scanner;

/**
 * 前缀和
 * 代码随想录 第一个“区间和”的内容
 * */
@SuppressWarnings("all")
public class PrefixSum_5 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 先输入第一个数 -> 数组长度 (总共多少个数)
        int n = scanner.nextInt();
        // 声明两个数组分别承载原始数以及“前缀和”数
        int[] vec = new int[n];
        int[] prefixSum = new int[n];

        // 依次输入到两个数组中
        int preSum = 0;
        for (int i = 0; i < n; i++) {
            vec[i] = scanner.nextInt();
            preSum += vec[i];
            prefixSum[i] = preSum;
        }

        // 输入要确定的区间的两个值 (一头一尾)
        while (scanner.hasNext()) {
            int head = scanner.nextInt();
            int tail = scanner.nextInt();

            // 这里是核心代码，用tail在prefixSum数组中指向的元素值 减去 head指向的元素的前一位的元素值
            // 这个sum是最终要返回的结果
            int sum = 0;
            if (head == 0) {
                sum = prefixSum[tail];
            } else {
                sum = prefixSum[tail] - prefixSum[head - 1];
            }
        }

        scanner.close();

    }
}
