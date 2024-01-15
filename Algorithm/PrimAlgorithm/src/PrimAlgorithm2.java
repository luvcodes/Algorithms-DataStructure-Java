import java.util.Arrays;

/**
 * @author ryanw
 */
public class PrimAlgorithm2 {
    public static void main(String[] args) {
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] weight = {
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000},
        };

        MiniGraph graph = new MiniGraph(data.length);
        MiniTree minTree = new MiniTree();
        minTree.createGraph(graph, data, weight);
        minTree.showGraph(graph);
        minTree.prim(graph, 0);
    }
}

// Prim 算法类
class MiniTree {
    public void createGraph(MiniGraph graph, char[] data, int[][] weight) {
        for (int i = 0; i < graph.verxs; i++) {
            graph.data[i] = data[i];
            for (int j = 0; j < graph.verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    public void showGraph(MiniGraph graph) {
        for (int[] row : graph.weight) {
            System.out.println(Arrays.toString(row));
        }
    }

    public void prim(MiniGraph graph, int v) {
        boolean[] visited = new boolean[graph.verxs];
        visited[v] = true;
        int h1 = -1;
        int h2 = -1;
        int minWeight;
        for (int k = 1; k < graph.verxs; k++) {
            minWeight = 10000;
            for (int i = 0; i < graph.verxs; i++) {
                for (int j = 0; j < graph.verxs; j++) {
                    if (visited[i] && !visited[j] && graph.weight[i][j] < minWeight) {
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            System.out.println("Edge<" + graph.data[h1] + "," + graph.data[h2] + "> Weight: " + minWeight);
            visited[h2] = true;
        }
    }
}

// 图的数据结构类
class MiniGraph {
    int verxs; // 图的节点个数
    char[] data; // 存放节点数据
    int[][] weight; // 存放边，即邻接矩阵

    public MiniGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}
