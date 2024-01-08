import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author ryanw
 */
public class HuffmanCode {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        String content = "i like like like java do you like a java";
//        byte[] contentBytes = content.getBytes();
//        System.out.println(contentBytes.length);
//
//        HuffmanZipResult zipResult = huffmanZip(contentBytes);
//        System.out.println("压缩后的结果是: " + Arrays.toString(zipResult.zipBytes));
//
//        byte[] sourceBytes = decode(huffmanCodes, zipResult);
//        System.out.println("原来的字符串 = " + new String(sourceBytes));


        // 验证文件压缩、解压缩
        try {
            // 确保该文件存在
            String originalFilePath = "C:\\Users\\ryanw\\IdeaProjects\\Algorithms-DataStructure-Java\\DataStructure\\Tree\\HuffmanCode\\src\\input.txt";
            String compressedFilePath = "C:\\Users\\ryanw\\IdeaProjects\\Algorithms-DataStructure-Java\\DataStructure\\Tree\\HuffmanCode\\src\\compressedFile.zip";
            String decompressedFilePath = "C:\\Users\\ryanw\\IdeaProjects\\Algorithms-DataStructure-Java\\DataStructure\\Tree\\HuffmanCode\\src\\decompressedFile.txt";


            compressFile(originalFilePath, compressedFilePath);
            System.out.println("文件压缩完成");

            decompressFile(compressedFilePath, decompressedFilePath);
            System.out.println("文件解压缩完成");

            byte[] originalContent = Files.readAllBytes(Paths.get(originalFilePath));
            byte[] decompressedContent = Files.readAllBytes(Paths.get(decompressedFilePath));
            if (Arrays.equals(originalContent, decompressedContent)) {
                System.out.println("验证成功：原始文件和解压缩后的文件内容相同");
            } else {
                System.out.println("验证失败：原始文件和解压缩后的文件内容不同");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    static class Node implements Comparable<Node> {
        Byte data; // 字符数据
        int weight; // 权值（频率）
        Node left;
        Node right;

        public Node(Byte data, int weight) {
            this.data = data;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }

        public void preOrder() {
            System.out.println(this);
            if (this.left != null) {
                this.left.preOrder();
            }
            if (this.right != null) {
                this.right.preOrder();
            }
        }

        @Override
        public String toString() {
            return "Node{" + "data=" + data + ", weight=" + weight + '}';
        }
    }

    static class HuffmanZipResult {
        byte[] zipBytes;
        int originalBinaryStringLength;

        public HuffmanZipResult(byte[] zipBytes, int originalBinaryStringLength) {
            this.zipBytes = zipBytes;
            this.originalBinaryStringLength = originalBinaryStringLength;
        }
    }

    private static List<Node> getNodes(byte[] bytes) {
        ArrayList<Node> nodes = new ArrayList<>();
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    private static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            Node parent = new Node(null, left.weight + right.weight);
            parent.left = left;
            parent.right = right;
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    static Map<Byte, String> huffmanCodes = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();

    private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if (node != null) {
            if (node.data == null) {
                getCodes(node.left, "0", stringBuilder2);
                getCodes(node.right, "1", stringBuilder2);
            } else {
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }
    }

    private static Map<Byte, String> getCodes(Node root) {
        if (root == null) {
            return null;
        }
        getCodes(root.left, "0", stringBuilder);
        getCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
    }

    public static HuffmanZipResult zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }
        int originalLength = stringBuilder.length();
        int len = (originalLength + 7) / 8;
        byte[] huffmanBytes = new byte[len];
        int index = 0;
        for (int i = 0; i < originalLength; i += 8, index++) {
            String strByte = stringBuilder.substring(i, Math.min(i + 8, originalLength));
            huffmanBytes[index] = (byte) Integer.parseInt(strByte, 2);
        }
        return new HuffmanZipResult(huffmanBytes, originalLength);
    }

    public static HuffmanZipResult huffmanZip(byte[] bytes) {
        List<Node> nodes = getNodes(bytes);
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
        return zip(bytes, huffmanCodes);
    }

    private static String byteToBitString(boolean flag, byte b) {
        int temp = b;
        if (flag) {
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);
        if (flag || str.length() > 8) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }

    public static byte[] decode(Map<Byte, String> huffmanCodes, HuffmanZipResult huffmanZipResult) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < huffmanZipResult.zipBytes.length; i++) {
            boolean flag = (i == huffmanZipResult.zipBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, huffmanZipResult.zipBytes[i]));
        }
        stringBuilder.setLength(huffmanZipResult.originalBinaryStringLength);

        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }

        ArrayList<Byte> list = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length(); ) {
            int count = 1;
            boolean flag = true;
            Byte b = null;

            while (flag) {
                if (i + count > stringBuilder.length()) {
                    break;
                }
                String key = stringBuilder.substring(i, i + count);
                b = map.get(key);

                if (b == null) {
                    count++;
                } else {
                    flag = false;
                }
            }

            if (b != null) {
                list.add(b);
            }
            i += count;
        }

        byte[] bytes = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            bytes[i] = list.get(i);
        }
        return bytes;
    }


    // 压缩文件方法
    public static void compressFile(String inputFilePath, String outputFilePath) throws IOException {
        byte[] fileContent = Files.readAllBytes(Paths.get(inputFilePath));
        HuffmanZipResult zipResult = huffmanZip(fileContent);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFilePath))) {
            oos.writeObject(zipResult.zipBytes); // 压缩后的数据
            oos.writeObject(huffmanCodes);       // 编码表
            oos.writeInt(zipResult.originalBinaryStringLength); // 原始二进制串长度
        }
    }


    // 解压文件方法
    public static void decompressFile(String inputFilePath, String outputFilePath) throws IOException, ClassNotFoundException {
        byte[] compressedData;
        Map<Byte, String> huffmanCodes;
        int originalBinaryStringLength;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFilePath))) {
            compressedData = (byte[]) ois.readObject();
            huffmanCodes = (Map<Byte, String>) ois.readObject();
            originalBinaryStringLength = ois.readInt();
        }

        HuffmanZipResult zipResult = new HuffmanZipResult(compressedData, originalBinaryStringLength);
        byte[] decompressedData = decode(huffmanCodes, zipResult);
        Files.write(Paths.get(outputFilePath), decompressedData);
    }



}
