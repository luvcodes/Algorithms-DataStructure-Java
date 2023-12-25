import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = {-9, 78, 0, 23, -567, 70};

        // 创建要给80000个随机数的数组
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }

        System.out.println("排序前");
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是=" + date1Str);

        quickSort(arr, 0, arr.length - 1);
//        System.out.println("arr = " + Arrays.toString(arr));

        System.out.println("排序后");
        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是=" + date2Str);
//        System.out.println("arr = " + Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int left, int right){
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];

        // while循环的目的是让比pivot值小的放到左边
        // 比pivot值大的放到右边
        while (l < r){
            // 在pivot左边一直找，找到大于等于pivot值才停止
            while (arr[l] < pivot){
                l += 1;
            }
            // 在pivot右边一直找，找到小于等于pivot值才停止
            while (arr[r] > pivot){
                r -= 1;
            }
            // 如果l >= r说明pivot的左右两边的值，已经是左边的值
            // 都小于等于pivot值，右边全都大于等于pivot
            if (l >= r){
                break;
            }

            // 交换
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 如果交换完后，发现这个arr[l] == pivot值，r--，
            if (arr[l] == pivot){
                r -= 1;
            }
            if (arr[r] == pivot){
                l += 1;
            }
        }

        // 如果l == r，必须l++, r--, 否则会出现栈溢出
        if (l == r){
            l += 1;
            r -= 1;
        }

        // 向左递归
        if (left < r){
            quickSort(arr, left, r);
        }
        // 向右递归
        if (right > l){
            quickSort(arr, l, right);  // l, r都是下标，所以不用+1，-1，也可以直接传l, r，这样就不用传left, right了。
        }
    }
}