import java.util.Arrays;

/**
 * @author ryanw
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4,6,8,5,9};

        heapSort(arr);
    }

    public static void heapSort(int[] arr){
        System.out.println("堆排序");
        int temp = 0;

        // 完成最终代码
        // 将无序序列构建成一个，根据升序需求选择大顶堆或者小顶堆
        for (int i = arr.length/2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        // 将堆顶元素与末尾元素交换，将最大元素“沉”到数组末端
        // 重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整 + 交换步骤，直到整个序列有序
        for (int j = arr.length - 1; j > 0; j--) {
            // 交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }

        System.out.println("数组 = " + Arrays.toString(arr));


        // 分步完成
//        adjustHeap(arr, 1, arr.length);
//        System.out.println("第一次调整 " + Arrays.toString(arr));
//
//        adjustHeap(arr, 0, arr.length);
//        System.out.println("第二次调整 " + Arrays.toString(arr));
    }

    /**
     * 将一个数组调整成一个大顶堆
     * 功能: 完成将以i对应的非叶子节点的树调整成大顶堆
     * */
    public static void adjustHeap(int[] arr, int i, int length) {
        // 先取出当前元素的值，保存在临时变量
        int temp = arr[i];
        // 从i结点的左子结点开始，也就是2i+1处开始
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            // 如果左子结点小于右子结点，k指向右子结点
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                // k指向右子结点
                k++;
            }
            // 如果子节点大于父节点
            if (arr[k] > temp) {
                // 将子节点值赋给父节点
                arr[i] = arr[k];
                // 将i指向子节点
                i = k;
            } else {
                break;
            }
        }

        // 当for循环结束后，已经将以i为父节点的树的最大值，放在了最顶
        // 将temp值放到调整后的位置
        arr[i] = temp;
    }
}