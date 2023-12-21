public class Maze {
    public static void main(String[] args) {
        int[][] arr = new int[8][7];

        // 使用1 表示墙
        // 上下全部设置为1
        for (int i = 0; i < 7; i++) {
            arr[0][i] = 1;
            arr[7][i] = 1;
        }

        // 左右全部设置为1
        for (int i = 0; i < 8; i++) {
            arr[i][0] = 1;
            arr[i][6] = 1;
        }

        // 设置挡板, 1表示
        arr[3][1] = 1;
        arr[3][2] = 1;

        // 输出地图
        System.out.println("地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 使用递归回溯来给小球找路
    // i, j表示从地图哪个为止开始出发
    // 如果小球能到达maze[6][5], 则成功
    // 约定:  当maze[i][j] 为0表示该点没有走过, 为1表示墙, 为2表示通路可以走, 为3表示该位置已经走过，但是走不通
    // 在走迷宫时，需要确定一个策略 (方法) 下 -> 右 -> 上 -> 左
    /**
     * @param maze 表示地图
     * @param i 从哪个位置开始找
     * @param j
     * @return 如果找到通路，就返回true，否则返回false
     * */
    public static boolean setWay(int[][] maze, int i, int j) {

    }
}
