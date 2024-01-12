/**
 * @author ryanw
 */
public class BinarySearchRecursion {

    /**
     * 使用递归的方式实现二分查找
     *
     * @param arr   要进行查找的有序数组
     * @param left  查找范围的左边界
     * @param right 查找范围的右边界
     * @param x     要查找的元素
     * @return 元素在数组中的索引，如果未找到则返回 -1
     */
    public static int binarySearch(int[] arr, int left, int right, int x) {
        if (left > right) {
            // 基本情况，元素未找到
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == x) {
            // 找到元素，返回其索引
            return mid;
        } else if (arr[mid] > x) {
            // 在左子数组中递归查找
            return binarySearch(arr, left, mid - 1, x);
        } else {
            // 在右子数组中递归查找
            return binarySearch(arr, mid + 1, right, x);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40};
        int x = 10;

        int result = binarySearch(arr, 0, arr.length - 1, x);

        if (result == -1) {
            System.out.println("元素未找到");
        } else {
            System.out.println("元素找到，位置为索引: " + result);
        }
    }
}

