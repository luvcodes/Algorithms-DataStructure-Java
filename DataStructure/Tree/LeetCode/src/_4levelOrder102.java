import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode102: 层序遍历
 * */
@SuppressWarnings("all")
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
        // checkFun01(root, 0);

        // 调用迭代法
         checkFun02(root);

        return result;
    }

    /**
     * 递归法实现
     * 对于每一个节点，先检查当前深度的列表是否存在，如果不存在则创建。然后将该节点的值放入相应深度的列表中。
     * 递归处理其左子节点和右子节点。
     * 结果存储在 result 中，result 是一个二维列表，每一层的节点值都按顺序存放在其中
     */
    public void checkFun01(TreeNode root, Integer depth) {
        if (root == null) return;
        // 递归进入子节点时，深度加一
        depth++;

        if (result.size() < depth) {
            // 初始化一个新的列表来存储该层的节点
            List<Integer> item = new ArrayList<>();
            // 把当前节点的值添加到相应的层级列表中
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
        // 判断根节点是否为null
        if (root == null) return;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            List<Integer> itemList = new ArrayList<>();
            int len = que.size();

            while (len > 0) {
                TreeNode tmpNode = que.poll();
                itemList.add(tmpNode.val);
                if (tmpNode.left != null) que.offer(tmpNode.left);
                if (tmpNode.right != null) que.offer(tmpNode.right);
                len--;
            }

            result.add(itemList);
        }
    }
}
