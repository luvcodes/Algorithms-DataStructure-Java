import java.util.Arrays;

/**
 * @author ryanw
 */
public class Dijkstra {

    private static final int INF = Integer.MAX_VALUE;

    // Dijkstra算法的实现
    public static void dijkstra(int[][] graph, int startVertex) {
        int numVertices = graph.length;
        boolean[] visited = new boolean[numVertices];
        int[] distance = new int[numVertices];
        Arrays.fill(distance, INF);
        distance[startVertex] = 0;

        for (int i = 0; i < numVertices - 1; i++) {
            int u = findMinDistance(distance, visited);
            visited[u] = true;

            for (int v = 0; v < numVertices; v++) {
                if (!visited[v] && graph[u][v] != 0 && distance[u] != INF && distance[u] + graph[u][v] < distance[v]) {
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }

        printSolution(distance);
    }

    // 找到未访问顶点中距离最小的顶点
    private static int findMinDistance(int[] distance, boolean[] visited) {
        int minDistance = INF, minIndex = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    // 打印最短路径数组
    private static void printSolution(int[] distance) {
        System.out.println("Vertex\tDistance from Source");
        for (int i = 0; i < distance.length; i++) {
            System.out.println(i + "\t\t" + distance[i]);
        }
    }

    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        final int N = 65535;
        int[][] matrix = {
                {N, 5, 7, N, N, N, 2},
                {5, N, N, 9, N, N, 3},
                {7, N, N, N, 8, N, N},
                {N, 9, N, N, N, 4, N},
                {N, N, 8, N, N, 5, 4},
                {N, N, N, 4, 5, N, 6},
                {2, 3, N, N, 4, 6, N}
        };

        // 从顶点A开始计算最短路径
        dijkstra(matrix, 0);
    }
}
