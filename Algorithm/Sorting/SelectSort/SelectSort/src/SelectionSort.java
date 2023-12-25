import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        selectSort(arr);
    }

    //
    public static void selectSort(int[] arr) {
        // 使用循环来解决
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) { // 说明假定的最小值并不是真正的最小值
                    // 更新最小值和最小值索引
                    min = arr[j];
                    minIndex = j;
                }
            }
            // 交换元素
            if (minIndex != i) {
//                int temp = arr[minIndex];
//                arr[minIndex] = arr[i];
//                arr[i] = temp;

                // 把 arr[i] 赋值给 arr[minIndex] 时，
                // 我们实际上是把未排序部分的第一个元素放在了最小元素应该在的位置。
                // 然后我们把 min（已经保存了最小值）赋给 arr[i]，
                // 这样就完成了交换。
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}