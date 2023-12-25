import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 89};
        insertSort(arr);
    }

    public static void insertSort(int[] arr){
        // 使用for循环来把代码简化
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i]; // 定义待插入的数
            int insertIndex = i - 1; // 即arr[1]的前面这个数的下标

            // 给insertVal找到插入的位置
            // insertIndex >= 0保证找插入位置过程中不越界
            // insertVal < arr[insertIndex] 待插入的数还没有找到插入位置
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                // 将arr[insertIndex]后移
                arr[insertIndex + 1] = arr[insertIndex]; // {101, 101, 119, 1}
                insertIndex--; // 前移
            }
            // 退出while循环时，说明插入的位置找到，insertIndex + 1
            arr[insertIndex + 1] = insertVal; // 这时insertIndex是-1，而不是0。加一以后肯定就是index = 0的位置了

            System.out.println("第" + i + "轮插入后：" + Arrays.toString(arr));
        }

//
//        // 第一轮{101, 34, 119, 1} => {34, 101, 119, 1}
//        int insertVal = arr[1]; // 定义待插入的数
//        int insertIndex = 1 - 1; // 即arr[1]的前面这个数的下标
//
//        // 给insertVal找到插入的位置
//        // insertIndex >= 0保证找插入位置过程中不越界
//        // insertVal < arr[insertIndex] 待插入的数还没有找到插入位置
//        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
//            // 将arr[insertIndex]后移
//            arr[insertIndex + 1] = arr[insertIndex]; // {101, 101, 119, 1}
//            insertIndex--; // 前移
//        }
//        // 退出while循环时，说明插入的位置找到，insertIndex + 1
//        arr[insertIndex + 1] = insertVal; // 这时insertIndex是-1，而不是0。加一以后肯定就是index = 0的位置了
//
//        System.out.println("第一轮插入后：" + Arrays.toString(arr));
//
//
//        // 第二轮
//        insertVal = arr[2];
//        insertIndex = 2 - 1;
//        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
//            arr[insertIndex + 1] = arr[insertIndex];
//            insertIndex--;
//        }
//        arr[insertIndex + 1] = insertVal;
//        System.out.println("第二轮插入后：" + Arrays.toString(arr));
//
//
//        // 第3轮
//        insertVal = arr[3];
//        insertIndex = 3 - 1;
//        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
//            arr[insertIndex + 1] = arr[insertIndex];
//            insertIndex--;
//        }
//        arr[insertIndex + 1] = insertVal;
//        System.out.println("第3轮插入后：" + Arrays.toString(arr));
    }
}