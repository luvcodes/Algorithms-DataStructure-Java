public class BinarySearchExample {
    public static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] == target) {
                return mid; // 目标元素找到
            } else if (array[mid] < target) {
                low = mid + 1; // 搜索右半部分
            } else {
                high = mid - 1; // 搜索左半部分
            }
        }

        return -1; // 未找到目标元素
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9}; // 已排序的数组

        // 测试不同的目标值
        int[] targets = {3, 7, 8};

        for (int target : targets) {
            int result = binarySearch(array, target);

            if (result != -1) {
                System.out.println("元素 " + target + " 找到在索引: " + result);
            } else {
                System.out.println("元素 " + target + " 在数组中未找到");
            }
        }
    }
}
