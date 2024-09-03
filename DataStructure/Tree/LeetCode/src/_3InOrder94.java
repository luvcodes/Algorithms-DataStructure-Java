import java.util.*;

/**
 * LeetCode94: 中序遍历二叉树
 * */
@SuppressWarnings("all")
public class _3InOrder94 {
    public static void main(String[] args) {}

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrderRecursion(root, result);
        return result;
    }

    /**
     * 递归法中序遍历二叉树
     * */
    public void inOrderRecursion(TreeNode root, List<Integer> result) {
        if (root == null) return;

        inOrderRecursion(root.left, result);
        result.add(root.val);
        inOrderRecursion(root.right, result);
    }

    /**
     * 迭代法中序遍历二叉树
     * */
    public void inOrderIterate(TreeNode root, List<Integer> result) {
        // 判断root是否为null
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        // 设置current指针指向当前节点
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                // 去除节点，存入result数组中
                cur = stack.pop();
                result.add(cur.val);
                // 访问右子节点
                cur = cur.right;
            }
        }
    }
}
