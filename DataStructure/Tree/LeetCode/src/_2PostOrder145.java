import java.util.*;

/**
 * LeetCode145: 后序遍历二叉树
 * */
@SuppressWarnings("all")
public class _2PostOrder145 {
    public static void main(String[] args) {}

    public List<Integer> postorderTraversal(TreeNode root) {
        // 定义ArrayList存储最终结果
        List<Integer> result = new ArrayList<>();
        // 调用postOrder方法
        postOrder(root, result);
        // 返回结果
        return result;
    }

    /**
     * 递归法
     * */
    public void postOrder(TreeNode root, List<Integer> result) {
        // 判断root是否为null
        if (root == null) return;
        // 左右中的顺序访问
        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.val);
    }
}
