/**
 * @author ryanw
 */
public class HeapSort {
    public void sort(int[] arr) {
        int n = arr.length;

        // 构建最大堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 一个个从堆顶取出元素
        for (int i = n - 1; i > 0; i--) {
            // 将当前堆顶元素与末尾元素交换，确保末尾元素最大
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 调整剩余数组，使其满足最大堆的性质
            heapify(arr, i, 0);
        }
    }

    // 将以非叶子节点为根的子树调整为最大堆
    void heapify(int[] arr, int n, int i) {
        // 初始化最大值为根
        int largest = i;
        // 左子节点
        int l = 2 * i + 1;
        // 右子节点
        int r = 2 * i + 2;

        // 如果左子节点大于根
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        // 如果右子节点大于当前最大值
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        // 如果最大值不是根
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // 递归地调整受影响的子树
            heapify(arr, n, largest);
        }
    }

    // 将以非叶子节点为根的子树调整为最小堆
    void heapify2(int[] arr, int n, int i) {
        // 初始化最小值为根
        int smallest = i;
        // 左子节点
        int l = 2 * i + 1;
        // 右子节点
        int r = 2 * i + 2;

        // 如果左子节点小于根
        if (l < n && arr[l] < arr[smallest]) {
            smallest = l;
        }

        // 如果右子节点小于当前最小值
        if (r < n && arr[r] < arr[smallest]) {
            smallest = r;
        }

        // 如果最小值不是根
        if (smallest != i) {
            int swap = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = swap;

            // 递归地调整受影响的子树
            heapify(arr, n, smallest);
        }
    }


    // 打印数组的方法
    static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 测试方法
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr);

        System.out.print("Sorted array is: ");
        printArray(arr);
    }
}
