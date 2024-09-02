import java.util.*;

/**
 * LeetCode94: 中序遍历二叉树
 * */
public class _3InOrder94 {
    public static void main(String[] args) {}

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    /**
     * 递归法中序遍历二叉树
     * */
    public void inOrder(TreeNode root, List<Integer> result) {
        if (root == null) return;

        inOrder(root.left, result);
        result.add(root.val);
        inOrder(root.right, result);
    }
}
