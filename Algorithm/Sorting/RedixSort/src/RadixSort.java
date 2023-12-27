public class RadixSort {
    public static void main(String[] args) {

    }


    public static void radixSort(int[] arr) {
        // 第一轮 针对个位数排序
        // 定义一个二维数组，表示桶的数量，每个桶就是一个一维数组
        // 1. 二维数组包含10个1维数组
        // 2. 为了防止在放入数的时候，数据溢出，则每个一维数组(桶), 大小定为arr.length
        //      因为假如说所有的原数组数字的个位数都是一样的数，那实际上就是所有的数都堆在同一个桶里了
        // 3. 基数排序是空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];

    }
}