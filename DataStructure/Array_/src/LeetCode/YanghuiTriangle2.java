package LeetCode;

import java.util.ArrayList;
import java.util.*;

/**
 * @author ryanw
 * LeetCode119: https://leetcode.cn/problems/pascals-triangle-ii/description/
 */
public class YanghuiTriangle2 {
    public static void main(String[] args) {

    }

    /**
     * 第一种方式
     * */
    public List<Integer> getRowVer1(int rowIndex) {
        List<List<Integer>> matrix = new ArrayList<>();
        // 这里和杨辉三角I题(118)不一样的地方是在于，杨辉三角要的是从第一行到目标-1行全都输出
        // 而这里我使用 <= 的原因是在于为了能够覆盖到请求的那一行，即第 rowIndex 行。
        for (int i = 0; i <= rowIndex; ++i) {
            List<Integer> result = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    result.add(1);
                } else {
                    result.add(matrix.get(i - 1).get(j - 1) + matrix.get(i - 1).get(j));
                }
            }

            matrix.add(result);
        }

        // 上面都与LeetCode118杨辉三角的实现一样，只是这里返回的不是matrix结果
        // 而是直接用matrix.get()方法拿到目标索引的对应一维数组
        return matrix.get(rowIndex);
    }

    /**
     * 优化版: 第二种方式
     * 注意到对第 i+1 行的计算仅用到了第 i 行的数据，因此可以使用滚动数组的思想优化空间复杂度。
     * 思路: 逐行更新，最终只保留需要的那一行。
     * */
    public List<Integer> getRowVer2(int rowIndex) {
        // 这个列表用于存储上一行的结果，初始化为空列表，将在每次循环中被更新为当前行。
        List<Integer> result = new ArrayList<>();
        // 外层循环从0到rowIndex，用于生成每一行直到目标行。每次循环结束时，pre会被更新为最新生成的行cur。
        for (int i = 0; i <= rowIndex; ++i) {
            List<Integer> current = new ArrayList<>();
            // 内层循环负责生成当前行的所有元素。如果是行的开头或结尾（j == 0 || j == i），元素为1。
            // 否则，元素值是上一行的相邻两个元素之和，result.get(j - 1) + result.get(j)。
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == rowIndex) {
                    current.add(1);
                } else {
                    current.add(result.get(j - 1) + result.get(j));
                }
            }
            result = current;
        }

        // 最后一行的result即为所求的第rowIndex行
        return result;
    }


    /**
     * 再优化: 第三种方式
     * 操作的具体解释：
     * 行的开始（添加1）：在每次外层循环的开始，我们首先通过 row.add(1); 向数组中添加1，这代表每一行的第一个元素，也是上一行结束时的最后一个元素（因为每行的结束元素总是1）。
     * 逆序更新：接下来的逆序更新从当前行的倒数第二个元素开始，一直更新到第二个元素。通过 row.set(j, row.get(j) + row.get(j - 1)) 来更新：
     * row.get(j) 在更新之前代表“上一行”在位置 j 的值（因为我们是从行末尾开始向前更新，所以 j 位置的值还未被新的值覆盖）。
     * row.get(j - 1) 是上一行在位置 j-1 的值，这个值在这一轮迭代中没有被修改，所以它是有效的“上一行”的值。
     * */
    public List<Integer> getRowVer3(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add(0);
            for (int j = i; j > 0; --j) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }

}
