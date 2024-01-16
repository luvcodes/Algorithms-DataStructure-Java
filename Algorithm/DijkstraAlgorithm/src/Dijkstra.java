public class Dijkstra {

    private static final int INF = 65535; // 用N表示不可连接

    // 方法：寻找最短路径
    int minDistance(int[] dist, Boolean[] sptSet, int V) {
        int min = INF, minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // 打印构建的距离数组
    void printSolution(int[] dist, char[] vertex) {
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < vertex.length; i++)
            System.out.println(vertex[i] + " \t\t\t " + dist[i]);
    }

    // 实现Dijkstra算法
    void dijkstra(int[][] graph, int src, char[] vertex) {
        int V = vertex.length;
        int[] dist = new int[V];
        Boolean[] sptSet = new Boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = INF;
            sptSet[i] = false;
        }

        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, sptSet, V);
            sptSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (!sptSet[v] && graph[u][v] != INF && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        printSolution(dist, vertex);
    }

    public static void main(String[] args) {
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        final int N = 65535; // 表示不可连接
        int[][] matrix = {
                {N, 5, 7, N, N, N, 2},
                {5, N, N, 9, N, N, 3},
                {7, N, N, N, 8, N, N},
                {N, 9, N, N, N, 4, N},
                {N, N, 8, N, N, 5, 4},
                {N, N, N, 4, 5, N, 6},
                {2, 3, N, N, 4, 6, N}
        };

        Dijkstra t = new Dijkstra();
        t.dijkstra(matrix, 0, vertex); // 从顶点A开始寻找最短路径
    }
}
