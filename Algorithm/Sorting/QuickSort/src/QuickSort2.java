public class QuickSort2 {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 寻找基准数据的正确索引
            int index = partition(arr, low, high);

            // 对基准值左边的子数组进行快速排序
            quickSort(arr, low, index - 1);

            // 对基准值右边的子数组进行快速排序
            quickSort(arr, index + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        // 选择最左边的元素作为基准值
        int pivot = arr[low];
        while (low < high) {
            // 当队尾的元素大于等于基准数据时，向前挪动high指针
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            // 如果队尾元素小于pivot了，则需要将其赋值给low
            arr[low] = arr[high];
            // 当队首元素小于等于pivot时,向前挪动low指针
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            // 当队首元素大于pivot时，则需要将其赋值给high
            arr[high] = arr[low];
        }
        // 跳出循环时low和high相等，此时的low或high就是pivot的正确索引位置
        // 由于已经找到这个位置，可以直接将pivot赋值给它
        arr[low] = pivot;
        // 返回pivot的正确位置
        return low;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后的数组：");
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
}

