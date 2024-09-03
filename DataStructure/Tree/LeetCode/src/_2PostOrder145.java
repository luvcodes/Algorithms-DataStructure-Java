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
        // postOrderRecursion(root, result);

        postOrderIterate(root, result);
        Collections.reverse(result);

        // 返回结果
        return result;
    }

    /**
     * 递归法
     * */
    public void postOrderRecursion(TreeNode root, List<Integer> result) {
        // 判断root是否为null
        if (root == null) return;
        // 左右中的顺序访问
        postOrderRecursion(root.left, result);
        postOrderRecursion(root.right, result);
        result.add(root.val);
    }

    /**
     * 迭代法
     * 与前序遍历的迭代法类似，前序遍历是中左右 压入栈的时候是中右左
     * 而在后序遍历的迭代法中，就是中左右 -> 中右左 -> 再进行ArrayList反转
     * */
    public void postOrderIterate(TreeNode root, List<Integer> result) {
        // 判断是否为null
        if (root == null) return;
        // 不为null，创建栈，压入当前根节点 (中)
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        // 循环判断当前栈是否为空
        while (!stack.isEmpty()) {
            // 取中 加入result这个ArrayList中
            TreeNode node = stack.pop();
            result.add(node.val);
            // 访问左节点，压入栈
            if (node.left != null) stack.push(node.left);
            // 访问右节点，压入栈
            if (node.right != null) stack.push(node.right);
        }
    }
}
