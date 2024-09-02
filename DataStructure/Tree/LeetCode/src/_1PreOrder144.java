import java.util.List;
import java.util.ArrayList;

/**
 * LeetCode144: 二叉树的前序遍历
 * */
public class _1PreOrder144 {
    public static void main(String[] args) {}


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    /**
     * 递归法实现二叉树的前序遍历
     * 中、前、后的顺序进行存储、递归
     * */
    public static void preOrder(TreeNode root, List<Integer> result) {
        // 判断root是否为null，是null的话就直接返回
        if (root == null) return;

        result.add(root.val);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
