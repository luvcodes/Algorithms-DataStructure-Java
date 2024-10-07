import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

/**
 * LeetCode144: 二叉树的前序遍历
 * */
@SuppressWarnings("all")
public class _1PreOrder144 {
    public static void main(String[] args) {}

    /**
     * 实现二叉树前序遍历的第一种方式
     * 1. 使用递归法实现前序遍历
     * @return List<Integer> result, arraylist
     * */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrderRecursion(root, result);
        return result;
    }

    /**
     * 递归法实现二叉树的前序遍历
     * 中、前、后的顺序进行存储、递归
     * @return void 返回最终存储到res结果数组的成果即可
     * */
    public static void preOrderRecursion(TreeNode root, List<Integer> result) {
        // 判断root是否为null，是null的话就直接返回
        if (root == null) return;

        result.add(root.val);
        preOrderRecursion(root.left, result);
        preOrderRecursion(root.right, result);
    }

    /**
     * 迭代法实现二叉树的前序遍历
     * 使用栈来实现, 先添加中间节点，再向栈中压入右子节点，再压入左子节点。出栈顺序: 中 左 右
     * */
    public static void preOrderIterate(TreeNode root, List<Integer> result) {
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
            // 访问右节点，压入栈
            if (node.right != null) stack.push(node.right);
            // 访问左节点，压入栈
            if (node.left != null) stack.push(node.left);
        }
    }

    // public static void preOrderIterateUniversal(TreeNode root, List<Integer> result) {}
}

