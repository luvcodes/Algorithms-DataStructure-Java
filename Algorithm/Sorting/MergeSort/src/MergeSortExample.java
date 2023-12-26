public class MergeSortExample {
    public static void main(String[] args) {
        int[] array = { 12, 11, 13, 5, 6, 7 };

        System.out.println("原始数组:");
        printArray(array);

        mergeSortArray(array); // 数组排序

        System.out.println("\n排序后的数组:");
        printArray(array);
    }

    // 主要的归并排序函数
    private static void mergeSortArray(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        mergeSortRecursive(arr, 0, arr.length - 1);
    }

    // 用于递归的归并排序函数
    private static void mergeSortRecursive(int[] arr, int left, int right) {
        if (left < right) {
            // 计算的中点是相对于由 left 到 right 索引定义的数组段的中点，而不一定是整个数组的中点
            // 因为 left 可能不是从数组的第一个元素（索引为 0）开始的。
            int mid = left + (right - left) / 2;
            mergeSortRecursive(arr, left, mid);
            mergeSortRecursive(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    // 合并两个子数组的函数
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        System.arraycopy(temp, 0, arr, left, temp.length);
    }

    // 打印数组的辅助函数
    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
