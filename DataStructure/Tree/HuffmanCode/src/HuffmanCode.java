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

        // 测试是否生成了对应的赫夫曼编码
        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
        System.out.println("生成的赫夫曼编码表: " + huffmanCodes);


        byte[] huffmanCodeBytes = zip(contentBytes, huffmanCodes);
        System.out.println("压缩后的字节长度: " + Arrays.toString(huffmanCodeBytes));
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


    // 生辰赫夫曼树对应的赫夫曼编码
    // 思路
    // 1. 将赫夫曼编码表存放在Map<Byte, String> 形式
    static Map<Byte, String> huffmanCodes = new HashMap<Byte, String>();
    // 2. 在生成赫夫曼码表示的时候，需要去拼接路径，定义一个StringBuilder存储某个叶子节点的路径
    static StringBuilder stringBuilder = new StringBuilder();

    /**
     * 功能: 将传入的node节点的所有叶子节点的赫夫曼编码得到，并放入到huffmanCodes这个hashmap里
     *
     * @param node          传入的节点
     * @param code          路径: 左子节点是0，右子节点是1
     * @param stringBuilder 用于拼接路径
     * @return
     */
    private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        // 将code加入到stringBuilder2
        stringBuilder2.append(code);
        if (node != null) {
            // 判断当前这个node是叶子节点还是非叶子节点
            // node.data == null说明是非叶子节点
            if (node.data == null) {
                // 递归处理
                // 向左
                getCodes(node.left, "0", stringBuilder2);
                // 向右
                getCodes(node.right, "1", stringBuilder2);
            } else {
                // 说明是一个叶子节点
                // 表示找到了某个叶子节点的最后
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }
    }


    // 为了调用方便，重载getCodes方法
    private static Map<Byte, String> getCodes(Node root) {
        if (root == null) {
            return null;
        }
        // 处理root的左子树
        getCodes(root.left, "0", stringBuilder);
        getCodes(root.right, "1", stringBuilder);
        // 返回赫夫曼编码表
        return huffmanCodes;
    }


    // 将字符串对应的byte数组，通过生成的赫夫曼编码表，返回一个赫夫曼编码压缩后的byte数组
    /**
     * @param bytes 原始的字符串对应的byte[]，就是contentBytes包含原始的字符串
     * @param huffmanCodes 生成的赫夫曼编码map
     * @return 返回压缩后的byte数组
     * */
    public static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        // 1. 利用赫夫曼编码表huffmanCodes将bytes转成赫夫曼编码的字符串 (二进制的那一串)
        StringBuilder stringBuilder = new StringBuilder();
        // 遍历bytes
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }
        // 这里已经得到了长串字符串
        // System.out.println("压缩后的字符串: " + stringBuilder.toString());

        // 2. 将stringBuilder变成一个byte数组
        int len;
        // 二进制8位数字，代表一个字节
        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        // 创建存储压缩后的byte数组
        byte[] huffmanBytes = new byte[len];
        // 记录是第几个byte
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i += 8) { // 因为是每8位对应一个byte，步长是+8
            String strByte;
            strByte = stringBuilder.substring(i, i + 8);
            if (i + 8 > stringBuilder.length()) { // 不够8位
                // 说明是最后一个字节
                strByte = stringBuilder.substring(i);
            } else {
                // 将strByte转成一个byte，放入到huffmanBytes
                huffmanBytes[index] = (byte) Integer.parseInt(strByte, 2);
                index++;
            }
        }

        // 返回压缩后的byte数组
        return huffmanBytes;
    }
}
