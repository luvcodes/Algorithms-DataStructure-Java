public class FibonacciSearch {

    // 生成斐波那契数列
    public static int[] fibonacciSeries(int size) {
        int[] fib = new int[size];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < size; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }

    // 斐波那契查找算法
    public static int fibonacciSearch(int[] arr, int x) {
        int n = arr.length;
        // 生成一个足够大的斐波那契数列
        // 保数列中包含足够大的数来覆盖大多数实际应用中可能遇到的数组长度
        int[] fib = fibonacciSeries(20);

        // 初始化斐波那契分割点变量
        int fibMm2 = 0; // (m-2)'th 斐波那契数
        int fibMm1 = 1; // (m-1)'th 斐波那契数
        int fibM = fibMm2 + fibMm1; // m'th 斐波那契数

        // 找到大于或等于n的最小斐波那契数
        while (fibM < n) {
            fibMm2 = fibMm1;
            fibMm1 = fibM;
            fibM = fibMm2 + fibMm1;
        }

        // 标记删除的元素数量
        int offset = -1;

        // 当fibM大于1时，分割数组并进行查找
        while (fibM > 1) {
            // 检查分割点是否在数组范围内
            int i = Math.min(offset + fibMm2, n - 1);

            // 如果x大于分割点的值，移动到数组的右边
            if (arr[i] < x) {
                fibM = fibMm1;
                fibMm1 = fibMm2;
                fibMm2 = fibM - fibMm1;
                offset = i;
            }

            // 如果x小于分割点的值，移动到数组的左边
            else if (arr[i] > x) {
                fibM = fibMm2;
                fibMm1 = fibMm1 - fibMm2;
                fibMm2 = fibM - fibMm1;
            }
            // 元素找到
            else {
                return i;
            }
        }

        // 检查最后的元素是否是x
        if (fibMm1 == 1 && arr[offset + 1] == x) {
            return offset + 1;
        }

        // 元素未找到
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 8, 10, 12, 15, 18, 21, 24};
        int x = 15;
        int index = fibonacciSearch(arr, x);
        if (index >= 0) {
            System.out.println("找到元素 " + x + " 在索引: " + index);
        } else {
            System.out.println("元素 " + x + " 未在数组中找到");
        }
    }
}
