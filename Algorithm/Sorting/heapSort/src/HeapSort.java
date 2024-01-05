public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4,6,8,5,9};


    }

    public static void heapSort(int[] arr){
        System.out.println("堆排序");
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