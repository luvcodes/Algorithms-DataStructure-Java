package LeetCode;

/**
 * @author yangrunze
 * LeetCode59
 * 给你一个正整数n，生成一个包含 1 到 n2 所有元素，
 * 且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */
@SuppressWarnings("all")
public class _6SpiralMatrixII59 {
    public static void main(String[] args) {
        int[][] nums = generateMatrix(3);

        // Iterate matrix
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
        }
    }

    /**
     * 核心思想就是左闭右开的区间, 主要的思路意思就是无论是横着还是竖着，
     * 都是第一个元素开始计算，而不需要走到最后一个元素，最后一个元素就是下一个行或列的第一个元素。
     * */
    public static int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        // 实际填充进数组的数字
        int count = 1;
        // 每一圈的起始点的横坐标以及纵坐标, 即每一圈左上角的坐标。
        // 随着每一圈的完成，这两个变量都会递增，表示螺旋的起始位置向内缩进。
        int startX = 0;
        int startY = 0;
        // 记录当前的圈数
        int loop = 1;
        // offset的初始值设为1，它的主要作用是帮助计算每一圈填充的终止条件
        int offset = 1;
        // 用于在填充过程中遍历矩阵的行和列。
        // 在实际填充矩阵时，i和j是数组索引，用于指定当前填充的具体位置。
        int i, j = 0;

        while (loop <= n / 2) {
            // 最外圈的顶部的元素
            // 保证左闭右开的原则，边界条件: j不能等于n - offset
            for (j = startY; j < n - offset; j++) {
                nums[startX][j] = count++;
            }

            // 最外圈右侧的元素, 从右上角元素开始
            for (i = startX; i < n - offset; i++) {
                nums[i][j] = count++;
            }

            // 最外圈底部的元素，从右下角元素开始
            for (; j > startY; j--) {
                nums[i][j] = count++;
            }

            // 左侧的元素，从左下角元素开始
            for (; i > startX; i--) {
                nums[i][j] = count++;
            }

            startX++;
            startY++;
            offset++;
            loop++;
        }

        // n为奇数，矩阵最中心的值，单独处理
        if (n % 2 == 1) {
            nums[startX][startY] = count;
        }

        return nums;
    }


    /**
     * 第二种解法
     * */
    public int[][] generateMatrix2(int n) {
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int[][] matrix = new int[n][n];
        // 定义初始值和最终值
        int num = 1, target = n * n;
        // 终止条件是num > tar, 因此用while循环判断num <= tar
        while (num <= target) {
            // left to right
            for (int i = left; i <= right; i++) matrix[top][i] = num++;
            top++;
            // top to bottom
            for (int i = top; i <= bottom; i++) matrix[i][right] = num++;
            right--;
            // right to left
            for (int i = right; i >= left; i--) matrix[bottom][i] = num++;
            bottom--;
            // bottom to top
            for (int i = bottom; i >= top; i--) matrix[i][left] = num++;
            left++;
        }

        return matrix;
    }
}
