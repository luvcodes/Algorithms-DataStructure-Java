import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode102: 层序遍历
 * */
public class _4levelOrder102 {
    public List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        // 创建二叉树
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        _4levelOrder102 solution = new _4levelOrder102();
        List<List<Integer>> result = solution.levelOrder(root);

        // 打印结果
        for (List<Integer> level : result) {
            for (Integer value : level) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    /**
     * 层序遍历
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 调用递归法
        checkFun01(root, 0);

        // 调用迭代法
        // checkFun02(root);

        return result;
    }

    /**
     * 递归法实现
     */
    public void checkFun01(TreeNode root, Integer depth) {
        if (root == null) return;
        depth++;

        if (result.size() < depth) {
            List<Integer> item = new ArrayList<>();
            result.add(item);
        }
        result.get(depth - 1).add(root.val);

        checkFun01(root.left, depth);
        checkFun01(root.right, depth);
    }

    /**
     * 迭代法实现
     */
    public void checkFun02(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            List<Integer> itemList = new ArrayList<>();
            int len = que.size();

            while (len > 0) {
                TreeNode tmpNode = que.poll();
                itemList.add(tmpNode.val);

                if (tmpNode.left!= null) que.offer(tmpNode.left);
                if (tmpNode.right!= null) que.offer(tmpNode.right);
                len--;
            }

            result.add(itemList);
        }
    }
}