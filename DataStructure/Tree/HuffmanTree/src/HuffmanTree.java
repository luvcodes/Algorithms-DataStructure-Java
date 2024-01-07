import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node root = createHuffmanTree(arr);

        preOrder(root);
    }

    // 编写前序遍历的方法
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("Empty tree");
        }
    }

    // 创建赫夫曼树的方法
    public static Node createHuffmanTree(int[] arr) {
        // 第一步为了操作方便
        // 1. 遍历arr数组
        // 2. 将arr的每一个元素构成一个Node
        // 3.  将Node放入到ArrayList中，便于管理
        List<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }

        // 循环处理
        while (nodes.size() > 1) {
            // 排序, 从小到大
            Collections.sort(nodes);
            System.out.println("After sorting: " + nodes);

            // 第二步: 取出根节点权值最小的两棵二叉树
            // 1. 取出权值最小的节点 (二叉树)
            Node leftNode = nodes.get(0);
            // 2. 取出权值第二小的节点 (二叉树)
            Node rightNode = nodes.get(1);
            // 3. 构建一棵新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            // 4. 从arraylist中删除处理过的二叉树，就是leftNode和rightNode
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            // 5. 将parent加入到nodes中
            nodes.add(parent);
            System.out.println("After removing: " + nodes);
        }

        // 返回赫夫曼树的根节点（二叉树）
        return nodes.get(0);
    }
}

// 定义节点类，用于存储节点权值，指向左子节点和右子节点的指针
// 为了让Node对象持续排序Collections集合排序
// 让Node实现Comparable接口
class Node implements Comparable<Node> {
    // 节点权值
    int value;
    // 指向左子节点
    Node left;
    // 指向右子节点
    Node right;

    // 前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public Node(int value) {
        this.value = value;
    }

    // override the toString method
    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        // 表示从小到大排序
        return this.value - o.value;
    }
}