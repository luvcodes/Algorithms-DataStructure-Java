import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, -2};
        bubbleSort(arr);

    }

    public static void bubbleSort(int[] arr) {
        // 时间复杂度 O(n^2)
        // 空间复杂度 O(1)
        // 稳定性：稳定
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第" + (i+1) + "趟排序后的数组: ");
            System.out.println(Arrays.toString(arr));

            // 如果一趟排序没有发生交换，说明数组已经有序，提前结束
            if (!flag) {
                break;
            } else {
                flag = false; // 重置flag，方便进行下次判断
            }
        }
    }
}

//        // 冒泡排序的演变过程
//        // 第一趟排序，就是最大的数排在最后
//        int temp = 0;
//        for (int j = 0; j < arr.length - 1; j++) {
//            if (arr[j] > arr[j + 1]) {
//                temp = arr[j];
//                arr[j] = arr[j + 1];
//                arr[j + 1] = temp;
//            }
//        }
//        System.out.println("第一趟排序后的数组: ");
//        System.out.println(Arrays.toString(arr));
//
//
//        // 第二趟排序，就是将第二大的数排在倒数第二位
//        for (int j = 0; j < arr.length - 1 - 1; j++) {
//            if (arr[j] > arr[j + 1]) {
//                temp = arr[j];
//                arr[j] = arr[j + 1];
//                arr[j + 1] = temp;
//            }
//        }
//        System.out.println("第二趟排序后的数组: ");
//        System.out.println(Arrays.toString(arr));
//
//
//        // 第三趟排序，就是将第二大的数排在倒数第二位
//        for (int j = 0; j < arr.length - 1 - 2; j++) {
//            if (arr[j] > arr[j + 1]) {
//                temp = arr[j];
//                arr[j] = arr[j + 1];
//                arr[j + 1] = temp;
//            }
//        }
//        System.out.println("第三趟排序后的数组: ");
//        System.out.println(Arrays.toString(arr));
//
//
//        // 第四趟排序，就是将第二大的数排在倒数第二位
//        for (int j = 0; j < arr.length - 1 - 2; j++) {
//            if (arr[j] > arr[j + 1]) {
//                temp = arr[j];
//                arr[j] = arr[j + 1];
//                arr[j + 1] = temp;
//            }
//        }
//        System.out.println("第四趟排序后的数组: ");
//        System.out.println(Arrays.toString(arr));