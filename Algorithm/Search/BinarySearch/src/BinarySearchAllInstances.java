import java.util.ArrayList;
import java.util.List;

public class BinarySearchAllInstances {
    public static List<Integer> binarySearchAll(int[] array, int target) {
        List<Integer> resultIndices = new ArrayList<>();
        int index = binarySearch(array, target, 0, array.length - 1);

        if (index != -1) {
            resultIndices.add(index);
            // 查找左侧匹配项
            int leftIndex = index;
            while ((leftIndex = binarySearch(array, target, 0, leftIndex - 1)) != -1) {
                resultIndices.add(leftIndex);
            }

            // 查找右侧匹配项
            int rightIndex = index;
            while ((rightIndex = binarySearch(array, target, rightIndex + 1, array.length - 1)) != -1) {
                resultIndices.add(rightIndex);
            }
        }

        return resultIndices;
    }

    private static int binarySearch(int[] array, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 3, 3, 5, 7, 9, 9};
        int target = 3;
        List<Integer> resultIndices = binarySearchAll(array, target);

        if (!resultIndices.isEmpty()) {
            System.out.println("元素 " + target + " 找到在索引: " + resultIndices);
        } else {
            System.out.println("元素 " + target + " 在数组中未找到");
        }
    }
}
