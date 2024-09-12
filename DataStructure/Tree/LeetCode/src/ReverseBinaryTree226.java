import java.util.ArrayDeque;

@SuppressWarnings("all")
public class ReverseBinaryTree226 {
    public static void main(String[] args) {

    }

    // DFS
    /**
     * 前后序遍历都可以
     * 中序不行，因为先左孩子交换孩子，再根交换孩子（做完后，右孩子已经变成了原来的左孩子），再右孩子交换孩子（此时其实是对原来的左孩子做交换）
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        swapChildren(root);
        return root;
    }

    private void swapChildren(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    // BFS
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {return null;}
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                TreeNode node = deque.poll();
                swap(node);
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
        }
        return root;
    }

    public void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
//DFS递归
class Solution {

}