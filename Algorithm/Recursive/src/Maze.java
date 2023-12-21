public class Maze {
    public static void main(String[] args) {
        int[][] map = new int[8][7];

        // 使用1 表示墙
        // 上下全部设置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        // 左右全部设置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        // 设置挡板, 1表示
        map[3][1] = 1;
        map[3][2] = 1;

        // 下面两个是为了验证回溯
//        map[1][2] = 1;
//        map[2][2] = 1;

        // 输出地图
        System.out.println("地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

//        setWay(map, 1, 1);
        setWay2(map, 1, 1);

        // 输出新的地图，小球走过，并标识过的地图
        System.out.println("走过后的地图");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 使用递归回溯来给小球找路
    // i, j表示从地图哪个为止开始出发
    // 如果小球能到达map[6][5], 则成功
    // 约定:  当map[i][j] 为0表示该点没有走过, 为1表示墙, 为2表示通路可以走, 为3表示该位置已经走过，但是走不通
    // 在走迷宫时，需要确定一个策略 (方法) 下 -> 右 -> 上 -> 左，如果该点走不通，再回溯
    /**
     * @param map 表示地图
     * @param i 从哪个位置开始找
     * @param j
     * @return 如果找到通路，就返回true，否则返回false
     * */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) { // 如果小球能到达终点
            return true;
        } else {
            if (map[i][j] == 0) { // 如果当前这个点还没有走过
                // 按照策略 下 -> 右 -> 上 -> 左 走
                // 假定该点可以走通
                map[i][j] = 2;
                if (setWay(map, i + 1, j)) { // 先向下走
                    return true;
                } else if (setWay(map, i, j + 1)) { // 向右走
                    return true;
                } else if (setWay(map, i - 1, j)) { // 向上走
                    return true;
                } else if (setWay(map, i, j - 1)) { // 向左走
                    return true;
                } else {
                    // 说明该点走不通
                    map[i][j] = 3;
                    return false;
                }
            } else { // 如果不为0, 说明当前点已可能是1，2，3，墙，走过，走过但是死路
                return false;
            }
        }
    }


    // 修改找路的策略，改成上 -> 右 -> 下 -> 左
    public static boolean setWay2(int[][] map, int i, int j) {
        if (map[6][5] == 2) { // 如果小球能到达终点
            return true;
        } else {
            if (map[i][j] == 0) { // 如果当前这个点还没有走过
                // 按照策略 下 -> 右 -> 上 -> 左 走
                // 假定该点可以走通
                map[i][j] = 2;
                if (setWay2(map, i - 1, j)) { // 先向上走
                    return true;
                } else if (setWay2(map, i, j + 1)) { // 向右走
                    return true;
                } else if (setWay2(map, i + 1, j)) { // 向下走
                    return true;
                } else if (setWay2(map, i, j - 1)) { // 向左走
                    return true;
                } else {
                    // 说明该点走不通
                    map[i][j] = 3;
                    return false;
                }
            } else { // 如果不为0, 说明当前点已可能是1，2，3，墙，走过，走过但是死路
                return false;
            }
        }
    }
}
