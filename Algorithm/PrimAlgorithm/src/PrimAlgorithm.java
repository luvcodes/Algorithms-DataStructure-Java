import java.util.Arrays;

/**
 * @author ryanw
 */
public class PrimAlgorithm {

    public static void main(String[] args) {
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        // 顶点个数
        int verxs = data.length;

        //邻接矩阵的关系使用二维数组表示,10000这个大数，表示两个点不联通
        int[][] weight = {
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},};

        MGraph graph = new MGraph(verxs);
        MinTree minTree = new MinTree();
        minTree.createGraph(graph, verxs, data, weight);
        //输出
//        minTree.showGraph(graph);


        // 测试普利姆算法
        minTree.prim(graph, 0);
    }

}

//创建最小生成树->村庄的图
class MinTree {
    //创建图的邻接矩阵
    /**
     * @param graph 图对象
     * @param verxs 图对应的顶点个数
     * @param data 图的各个顶点的值
     * @param weight 图的邻接矩阵
     */
    public void createGraph(MGraph graph, int verxs, char data[], int[][] weight) {
        int i, j;
        // 顶点
        for(i = 0; i < verxs; i++) {
            // graph.data[i] = data[i] 这一步是在做数据复制，将外部传入的顶点数据复制到图中
            graph.data[i] = data[i];
            // 邻接矩阵初始化
            for(j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    //显示图的邻接矩阵
    public void showGraph(MGraph graph) {
        for(int[] link: graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * 编写prim算法，得到最小生成树
     * @param graph 图
     * @param v 表示从图的第几个顶点开始生成'A'->0 'B'->1... 这个就是对应字符数组的下标
     */
    public void prim(MGraph graph, int v) {
        // 标记顶点是否被访问过
        int[] visited = new int[graph.verxs];

        //把当前这个结点标记为已访问
        visited[v] = 1;
        //h1 和 h2 记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        //将 minWeight 初始成一个大数，后面在遍历过程中，会被替换
        int minWeight = 10000;

        //因为有graph.verxs个顶点，普利姆算法结束后，应该生成graph.verxs - 1条边
        for(int k = 1; k < graph.verxs; k++) {
            //这个是确定每一次生成的子图和哪个结点的距离最近
            // i表示被访问过的结点
            // j表示还没有访问过的结点
            // if语句的意思是针对每一个访问过的节点，查找它连同的没有被访问过的节点，并且它们之间的权重是小于10000的，进行替换
            for(int i = 0; i < graph.verxs; i++) {
                for(int j = 0; j < graph.verxs; j++) {
                    if(visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        //替换minWeight(寻找已经访问过的结点和未访问过的结点间的权值最小的边)
                        minWeight = graph.weight[i][j];
                        // 记录两个顶点的下标，以便后面输出边信息
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            // 退出这个for循环的时候，就代表找到最小的一条边
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + "> 权值:" + minWeight);
            //将当前这个结点标记为已经访问。只更新了h2的原因是因为h1是已经访问过的节点，h2才是原来未被访问的节点，现在设置成已访问
            visited[h2] = 1;
            //minWeight 重新设置为最大值 10000
            minWeight = 10000;
        }

    }
}

class MGraph {
    // 表示图的节点个数
    int verxs;
    // 存放结点数据，这里使用字符数组是因为每个节点用一个字符来标识，如 'A', 'B', 'C' 等。
    char[] data;
    // 存放边，就是我们的邻接矩阵。weight[i][j] 表示节点 i 和节点 j 之间的边的权重
    int[][] weight;

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}
