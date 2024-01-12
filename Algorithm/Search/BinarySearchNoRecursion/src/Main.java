public class Main {
    public static void main(String[] args) {
        int[] arr = {1,3,8,10,11,67,100};
        int index = binarySearch(arr, 1);
        System.out.println(index);
    }

    // 二分查找的非递归实现
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        // 说明可以继续查找
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                // 向左查找
                right = mid - 1;
            } else {
                // 向右查找
                left = mid + 1;
            }
        }
        // 未找到返回-1
        return -1;
    }
}