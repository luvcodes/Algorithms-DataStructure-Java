package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangrunze
 * LeetCode 118: 杨辉三角 https://leetcode.cn/problems/pascals-triangle/
 * 1. **初始化结果列表 `result`**：这是一个 `List` 的列表，即一个二维列表。它最终将存储整个杨辉三角。
 * 2. **遍历每一行**：外层的 `for` 循环负责生成每一行，循环变量 `i` 表示当前行号。
 * 3. **创建当前行的列表 `currRow`**：这是一个一维列表，用于存储当前行的所有元素。
 * 4. **计算当前行的元素**：内层的 `for` 循环用来计算当前行的每一个元素。根据杨辉三角的规则，行首和行尾元素为1，其他元素由上一行的两个相邻元素之和得到。
 * 5. **添加当前行到结果列表**：每次计算完一行后，使用 `result.add(currRow);` 将这行添加到 `result` 列表中。这样，当前行的数据就保存在结果列表中了。
 * 6. **返回整个杨辉三角**：当所有行都被添加到 `result` 中后，函数返回 `result`，这时 `result` 包含了完整的杨辉三角，其中每一行都是一个列表。
 */
public class YanghuiTriangle {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> generate(int numRows) {
        // 创建承载杨辉三角二维数组结果的容器
        List<List<Integer>> result = new ArrayList<>();

        // 思路是按照一行一行的数据进行添加
        for (int i = 0; i < numRows; ++i) {
            // 这个ArrayList就是用来承载每一行的元素的，一维数组
            ArrayList<Integer> row = new ArrayList<>();
            // 用这个循环来进行遍历当前行的所包括的元素，j <= i的条件是为了保证每增加一行，循环的次数就增加一次，
            // 确保每行有正确数量的元素，这些元素的索引也从0开始，递增到行号 i。
            // 这种循环结构确保了每一行能正确地填充其元素。
            for (int j = 0; j < i; j++) {
                // 判断当前元素所在的位置是中间还是两端，两端直接加一
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // 这个部分的计算就是因为杨辉三角的特性：当前这一行的当前元素 = 上一行的左侧位置元素 + 上一行同一位置元素
                    row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            // 最后结果的二维数组，是在这个循环中添加当前所在行的一维数组
            result.add(row);
        }

        return result;
    }
}
