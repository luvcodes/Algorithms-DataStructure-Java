import java.util.Arrays;

/**
 * @author ryanw
 */
public class MergeSortMethod2 {
    public static void main(String[] args) {
        int[] arr = {8,4,5,7,1,3,6,2};
        int[] temp = new int[arr.length];
        System.out.println("Before merge sort: " + Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1, temp);

        System.out.println("mergeSort: " + Arrays.toString(arr));

    }

    // 分 + 合方法
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 向左递归进行分解
            mergeSort(arr, left, mid, temp);
            // 向右递归进行分解
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }



    /**
     * @param arr 原始数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边有序序列的初始索引
     * @param temp 临时数组，用来存储排序结果
     * */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left; // 初始化i，指向左边有序序列的初始索引
        int j = mid + 1; // 初始化j，指向右边有序序列的初始索引
        int t = 0; // 指向temp数组的当前索引


        // 先把左右两边有序的数据按照规则填充到temp数组
        // 直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) {
            // 如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
            // 就把左边的当前元素存到临时数组中
            // t和i都要往后移动
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else { // 反之，右边的有序序列的当前元素，小于左边的有序序列的当前元素
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }


        // 把有剩余数据的一边的数据依次全部填充到temp
        while (i <= mid) { // 左边的有序序列还有剩余的元素，就全部填充到temp
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }

        // 右边的有序序列还有剩余的元素，就全部填充到temp
        while (j <= right) {
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        // 将temp数组的元素拷贝到arr
        // 注意不是每次都拷贝所有
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[t++]; // 注意这里是tempLeft++，而不是tempLeft += 1，因为tempLeft是int类型，所以不能直接加1，而是要用++来表示加1。同理，temp[t++]也是一样的道理。
        }
    }
}
