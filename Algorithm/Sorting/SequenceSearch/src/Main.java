public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 9, 11, -1, 34, 89};
        int index = seqSearch(arr, 11);
        if (index == -1) {
            System.out.println("Did not find the target index");
        } else {
            System.out.println("Found the target index: "+ index);
        }
    }

    /**
     * 这里我们实现的线性查找是找到一个满足条件的值，就返回
     * */
    public static int seqSearch(int[] arr, int value) {
        // 线性查找是逐一比对，发现有相同的值时，就返回下标
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}

