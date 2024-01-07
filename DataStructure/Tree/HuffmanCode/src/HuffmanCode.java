import java.io.UnsupportedEncodingException;
import java.util.*;

public class HuffmanCode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String content = "i like like like java do you like a java";
        // 得到字节数组
        byte[] contentBytes = content.getBytes();
        System.out.println(contentBytes.length);

        List<Node> nodes = getNodes(contentBytes);
        System.out.println("nodes = " + nodes);

        // 创建赫夫曼树
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        System.out.println("前序遍历");
        preOrder(huffmanTreeRoot);

    }

    /**
     * @param bytes 接收字节数组
     * @return 返回的就是List形式 [Node [data=97 weight=5], Node[data=32 weight=9]]
     * */
    private static List<Node> getNodes(byte[] bytes) {
        ArrayList<Node> nodes = new ArrayList<>();
        // 遍历bytes，统计每个byte出现的次数
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            // 说明map中还没有这个字符数据
            if (count == null) {
                // 字符放进去，第一次
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }
        // 把每个键值对转成一个Node对象，并加入到nodes集合
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    // 第四步，通过List创建对应的赫夫曼树
    private static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            // 排序, 从小到大
            Collections.sort(nodes);
            // 取出权值最小的两个节点
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            // 构建一个新的节点
            Node parent = new Node(null, left.weight + right.weight);
            parent.left = left;
            parent.right = right;
            // 从nodes中删除已经处理过的节点
            nodes.remove(left);
            nodes.remove(right);
            // 把新节点加入到nodes中
            nodes.add(parent);
        }
        // 返回根节点，就是赫夫曼树的根节点。
        return nodes.get(0);
    }


    // 前序遍历方法
    private static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("是空树");
        }
    }
}

class Node implements Comparable<Node> {
    // 存放数据本身, 比如'a' => 97, ' ' => 32
    Byte data;
    // 权值
    int weight;
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }


    @Override
    public int compareTo(Node o) {
        // 从小到大排序
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

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
}