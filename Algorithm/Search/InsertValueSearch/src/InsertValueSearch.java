import java.util.Arrays;

public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }

        int index = insertValueSearch(arr, 0, arr.length - 1, 100);
        System.out.println("index = " + index);
    }

    /**
     * 插值查找算法的使用前提是有序数组
     * findVal < arr[0]和findVal > arr[arr.length - 1] 必须需要
     * 否则我们得到的mid可能越界
     * */
    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {
        System.out.println("查找次数"); // 判断查找了多少次
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }
        // 求出mid值，自适应
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal) { // 说明应该向右边递归
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { // 说明应该向左边递归
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else { // 相等
            return mid; // 找到了就返回下标，找不到就返回-1
        }

    }
}