package com.arithmetic.exhaust;

import java.util.LinkedList;
import java.util.Queue;

/**
 * **题目：
 * 
 * 有一个大小为N*M的迷宫，由通道和墙壁组成，每一步可以向相邻的上下左右四个方位的通道移动。求从起点到终点所需的最小步数。
 * 
 * 输入：
 * 
 * N=10,M=10,迷宫如下(#表示墙，.表示通道，S表示起点，G表示终点)：
 * 
 * #S######.#<br>
 * ......#..#<br>
 * .#.##.##.#<br>
 * .#........<br>
 * ##.##.####<br>
 * ....#....#<br>
 * .#######.#<br>
 * ....#.....<br>
 * .####.###.<br>
 * ....#...G#<br>
 * 
 * 输出：
 * 
 * 22
 * 
 * **思路：
 * 
 * 从S开始，使用广度优先穷竭（BFS）由近至远顺序搜索（借用队列），将起点距离每个点的最小距离管理起来。
 * 
 * 时间复杂度O(4*N*M)
 * 
 * @author sunjie at 2017年5月31日
 */
public class BroadExhaust1 {
    static final int n = 10, m = 10;
    static final char[][] field = new char[][] { /**/
    { '#', 'S', '#', '#', '#', '#', '#', '#', '.', '#' },/* 0 */
    { '.', '.', '.', '.', '.', '.', '#', '.', '.', '#' },/* 1 */
    { '.', '#', '.', '#', '#', '.', '#', '#', '.', '#' },/* 2 */
    { '.', '#', '.', '.', '.', '.', '.', '.', '.', '.' },/* 3 */
    { '#', '#', '.', '#', '#', '.', '#', '#', '#', '#' },/* 4 */
    { '.', '.', '.', '.', '#', '.', '.', '.', '.', '#' },/* 5 */
    { '#', '#', '#', '#', '#', '#', '#', '#', '.', '#' },/* 6 */
    { '.', '.', '.', '.', '#', '.', '.', '.', '.', '.' },/* 7 */
    { '#', '#', '#', '#', '#', '.', '#', '#', '#', '.' },/* 8 */
    { '.', '.', '.', '.', '#', '.', '.', '.', 'G', '#' },/* 9 */
    };
    // 起点、终点坐标
    static final int sx = 0, sy = 1;
    static final int gx = 9, gy = 8;
    // 距离默认值
    static final int INIT_VALUE = Integer.MAX_VALUE;
    // 记录距离的数组，需初始化
    static int[][] d = new int[n][m];

    static class Pair<X, Y> {

        private X x;

        private Y y;

        public X getX() {
            return x;
        }

        public void setX(X x) {
            this.x = x;
        }

        public Y getY() {
            return y;
        }

        public void setY(Y y) {
            this.y = y;
        }

        public Pair(X x, Y y) {
            super();
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pair [x=" + x + ", y=" + y + "]";
        }

    }

    public static void main(String[] args) {
        // 初始化
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                d[i][j] = INIT_VALUE;
            }
        }
        bds();

        System.out.println("距离终点 (" + gx + "," + gy + ") 点距离:" + d[gx][gy]);

        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[0].length; j++) {
                System.out.println("距离 (" + i + "," + j + ") 点距离:" + (d[i][j] == INIT_VALUE ? "墙" : d[i][j]));
            }
        }
    }

    /**
     * 
     * 计算起点距离每个点的距离
     *
     * @author sunjie at 2017年6月2日
     *
     */
    private static void bds() {
        // 方向向量,上下左右
        Pair<Integer, Integer>[] dpoints = new Pair[] { new Pair<Integer, Integer>(0, 1),
                new Pair<Integer, Integer>(0, -1), new Pair<Integer, Integer>(-1, 0), new Pair<Integer, Integer>(1, 0) };
        // queue
        Queue<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();
        // 起点放入queue中+计算距离
        queue.add(new Pair<Integer, Integer>(sx, sy));
        d[sx][sy] = 0;

        // 从S开始遍历，并放入queue中+计算距离
        while (queue.size() > 0) {
            // 取队列中的点
            Pair<Integer, Integer> point = queue.poll();
            // // 如果是终点则返回，若只求到终点的则加上该代码
            // if (gx == point.x && gy == point.y) {
            // System.out.println("终点，最小步数：" + d[gx][gy]);
            // return;
            // }
            // 取该点能达到的4个位置，排除墙、和已经计算过的点，放入queue中+计算距离
            for (Pair<Integer, Integer> dpoint : dpoints) {
                int newx = point.x + dpoint.x;
                int newy = point.y + dpoint.y;
                // 越界判断
                if (newx < 0 || newx >= n) {
                    continue;
                }
                if (newy < 0 || newy >= m) {
                    continue;
                }
                // 墙判断
                if (field[newx][newy] == '#') {
                    continue;
                }
                // 已经计算过的点
                if (d[newx][newy] != INIT_VALUE) {
                    continue;
                }
                queue.add(new Pair<Integer, Integer>(newx, newy));
                d[newx][newy] = d[point.x][point.y] + 1;
            }
        }
    }
}
