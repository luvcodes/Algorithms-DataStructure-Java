import java.util.*;

/**
 * LeetCode107: 从下往上层序遍历二叉树
 * */
@SuppressWarnings("all")
public class _5levelOrderII107 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);

        _5levelOrderII107 solution = new _5levelOrderII107();
        System.out.println(solution.levelOrderBottom(treeNode));
    }
    public List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // 迭代法实现
        checkFun01(root);

        return result;
    }


    /**
     * 迭代法实现
     * */
    public void checkFun01(TreeNode root) {
        // 1. 判断root节点是否为null
        if (root == null) return;

        // 2. root不为null，创建队列逐行来进行存储节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 3. 判断当前队列是否为empty，不为empty继续执行。就是在遍历当前树的一层
        while (!queue.isEmpty()) {
            // 4. 创建一个新的ArrayList数组来进行存储当前层的节点值
            List<Integer> list = new ArrayList<>();
            int len = queue.size();

            // 5. 判断当前ArrayList是否还有节点
            while (len > 0) {
                // 6. 有节点，弹出当前节点并存储到result。
                TreeNode currNode = queue.poll();
                list.add(currNode.val);

                // 7. 存入当前节点的左子节点和右子节点
                if (currNode.left != null) queue.offer(currNode.left);
                if (currNode.right != null) queue.offer(currNode.right);

                // 8. ArrayList长度 - 1
                len--;
            }

            // 9. result数组添加当前层
            result.add(list);
        }

        // 10. 反转result数组
        // 10.1 使用Collections.reverse API来实现反转
        // Collections.reverse(result);

        // 10.2 当前result数组直接反转
        for (int i = 0; i < result.size() / 2; i++) {
            List<Integer> temp = result.get(i);
            result.set(i, result.get(result.size() - 1 - i));
            result.set(result.size() - 1 - i, temp);
        }

        // 10.3 定义新数组成绩进行反转
        //        List<List<Integer>> finalResult = new ArrayList<>();
        //        for (int i = result.size() - 1; i >= 0; i--) {
        //            finalResult.add(result.get(i));
        //        }
        //        return finalResult;
    }

    /**
     * 递归法实现
     * */
    public void checkFun02(TreeNode root, Integer depth) {}

}
