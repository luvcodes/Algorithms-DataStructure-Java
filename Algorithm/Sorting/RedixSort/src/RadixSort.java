import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
    }


    public static void radixSort(int[] arr) {

        // 1. 得到数组中最大的数的位数
        int max = arr[0]; // 假设第一数是最大数
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // 得到最大数是几位数
        int maxLength = (max + "").length(); // max + ""就是max加空串转换成了一个字符串
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n*=10) {
            // 针对每个元素的对应位进行排序，第一次是个位，第二次是十位，第三次是百位
            for (int j = 0; j < arr.length; j++) {
                // 去除每个元素的对应位的值
                int digitOfElement = arr[j] / n % 10;
                // 放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }

            // 按照规则，将桶中的数据，放入到原数组
            int index = 0;
            // 遍历每一个桶，并将桶中的数据，放入到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                // 如果桶中有数据，才放入到原数组
                if (bucketElementCounts[k] != 0) {
                    // 循环该桶，也就是第k个桶，也就是第k个一维数组。放入数据
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        // 将数据放入到原数组
                        arr[index] = bucket[k][l];
                        index += 1;
                    }
                    // 第i+1轮处理后需要将每个bucketElementCounts[k] = 0
                    // 现在这步就相当于是清理数据，以备填入新的数据
                    bucketElementCounts[k] = 0;
                }
            }

            System.out.println("第" + (i + 1) + "轮 对数字的排序arr = " + Arrays.toString(arr));
        }

    }
}


//
//        // 第一轮 针对个位数排序
//        // 定义一个二维数组，表示桶的数量，每个桶就是一个一维数组
//        // 1. 二维数组包含10个1维数组
//        // 2. 为了防止在放入数的时候，数据溢出，则每个一维数组(桶), 大小定为arr.length
//        //      因为假如说所有的原数组数字的个位数都是一样的数，那实际上就是所有的数都堆在同一个桶里了
//        // 3. 基数排序是空间换时间的经典算法
//        int[][] bucket = new int[10][arr.length];
//
//        // 为了记录每个桶中，实际存放了多少个数据，我们定义一个一维数组来记录各个桶的每次放入的数据个数
//        // 可以这样理解: bucketElementCounts[0]，记录的就是bucket[0] 桶的放入数据个数
//        int[] bucketElementCounts = new int[10];
//
//        for (int j = 0; j < arr.length; j++) {
//            // 得到每个元素的个位数
//            int digitOfElement = arr[j] / 1 % 10;
//            // 放入到对应的桶中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//            bucketElementCounts[digitOfElement]++;
//        }
//
//        // 按照规则，将桶中的数据，放入到原数组
//        int index = 0;
//        // 遍历每一个桶，并将桶中的数据，放入到原数组
//        for (int k = 0; k < bucketElementCounts.length; k++) {
//            // 如果桶中有数据，才放入到原数组
//            if (bucketElementCounts[k] != 0) {
//                // 循环该桶，也就是第k个桶，也就是第k个一维数组。放入数据
//                for (int l = 0; l < bucketElementCounts[k]; l++) {
//                    // 将数据放入到原数组
//                    arr[index] = bucket[k][l];
//                    index += 1;
//                }
//                // 第一轮处理后需要将每个bucketElementCounts[k] = 0, 因为在第一轮完成后并没有清理桶中的数据
//                // 现在这步就相当于是清理数据，以备填入新的数据
//                bucketElementCounts[k] = 0;
//            }
//        }
//
//        System.out.println("第一轮 对个位数字的排序arr = " + Arrays.toString(arr));
//
//
//
//        // 第二轮 针对十位数排序
//        for (int j = 0; j < arr.length; j++) {
//            // 得到每个元素的个位数
//            int digitOfElement = arr[j] / 10 % 10;
//            // 放入到对应的桶中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//            bucketElementCounts[digitOfElement]++;
//        }
//
//        index = 0;
//        for (int k = 0; k < bucketElementCounts.length; k++) {
//            if (bucketElementCounts[k] != 0) {
//                for (int l = 0; l < bucketElementCounts[k]; l++) {
//                    arr[index] = bucket[k][l];
//                    index += 1;
//                }
//                bucketElementCounts[k] = 0; // 清理数据，以备填入新的数据
//            }
//        }
//
//        System.out.println("第二轮 对十位数字的排序arr = " + Arrays.toString(arr));
//
//
//
//
//        // 第三轮 针对百位数排序
//        for (int j = 0; j < arr.length; j++) {
//            // 得到每个元素的个位数
//            int digitOfElement = arr[j] / 100 % 10;
//            // 放入到对应的桶中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//            bucketElementCounts[digitOfElement]++;
//        }
//
//        index = 0;
//        for (int k = 0; k < bucketElementCounts.length; k++) {
//            if (bucketElementCounts[k] != 0) {
//                for (int l = 0; l < bucketElementCounts[k]; l++) {
//                    arr[index] = bucket[k][l];
//                    index += 1;
//                }
//            }
//        }
//
//        System.out.println("第三轮 对百位数字的排序arr = " + Arrays.toString(arr));