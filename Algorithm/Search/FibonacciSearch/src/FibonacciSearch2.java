import java.util.Arrays;

public class FibonacciSearch2 {
    private static int maxSize = 20;
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};

        System.out.println("index = " + fibSearch(arr, 1));
    }

    // 因为后面mid = low + F(k - 1) - 1, 需要使用斐波那契数列，因此需要先获取一个斐波那契数列
    // 非递归方法获取
    public static int[] fib() {
        int[] fib = new int[maxSize];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < 20; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }

    public static int fibSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0; // 表示斐波那契分割点的下标
        int mid = 0;
        int[] fib = fib(); // 获取斐波那契数列

        // 获取到斐波那契分割数组的下标
        // - 1 是为了确保数组的大小至少能容纳到斐波那契数列中的第k个数所表示的元素数量
        while (high > fib[k] - 1) {
            k++;
        }

        // 因为f[k]可能大于数组的长度，因此需要使用Arrays类，构造新的数组，并指向arr[]
        int[] temp = Arrays.copyOf(arr, fib[k]);
        // 用数组最后的一位数来填充不足的部分
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        // 使用while来循环处理，来找到目标数 key
        while (low <= high) {
            mid = low + fib[k - 1] - 1;
            if (key < temp[mid]) { // 向数组的前面查找
                high = mid - 1;
                // 为什么k--？
                k--;
            } else if (key > temp[mid]) { // 向数组的后面查找
                low = mid + 1;
                // 为什么k-2？
                k -= 2;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1; // 未找到元素
    }
}
