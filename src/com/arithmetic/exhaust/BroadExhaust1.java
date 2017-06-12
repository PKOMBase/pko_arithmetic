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
 * @author sunjie at 2017年6月12日
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

    static final int INIT_VALUE = Integer.MAX_VALUE;
    // 记录每个点距离s最小距离的数组
    static int[][] d = new int[n][m];

    public static class Pair<X, Y> {
        private X x;
        private Y y;

        public Pair(X x, Y y) {
            super();
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pair [x=" + x + ", y=" + y + "]";
        }

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

    }

    public static void main(String[] args) {
        // 初始化d
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                d[i][j] = INIT_VALUE;
            }
        }

        bfs();

        System.out.println("终点(" + gx + "," + gy + ")距离起点的最小距离是：" + d[gx][gy]);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println("(" + i + "," + j + ")距离起点的最小距离是：" + (d[i][j] == INIT_VALUE ? "墙" : d[i][j]));
            }
        }
    }

    public static void bfs() {

        // 方向向量
        Pair<Integer, Integer>[] dpoints = new Pair[] { new Pair<Integer, Integer>(0, 1),
                new Pair<Integer, Integer>(0, -1), new Pair<Integer, Integer>(-1, 0), new Pair<Integer, Integer>(1, 0) };

        // queue
        Queue<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();
        // 起点放入queue
        queue.add(new Pair<Integer, Integer>(sx, sy));
        d[sx][sy] = 0;

        while (queue.size() > 0) {
            // 去队列列首
            Pair<Integer, Integer> point = queue.poll();
            // 上下左右
            for (Pair<Integer, Integer> dpoint : dpoints) {
                int newx = point.x + dpoint.x;
                int newy = point.y + dpoint.y;
                // 判断边界
                if (newx < 0 || newx >= n) {
                    continue;
                }
                if (newy < 0 || newy >= m) {
                    continue;
                }
                // 判断墙
                if (field[newx][newy] == '#') {
                    continue;
                }
                // 已经处理过的
                if (d[newx][newy] != INIT_VALUE) {
                    continue;
                }
                // 处理
                queue.add(new Pair<Integer, Integer>(newx, newy));
                d[newx][newy] = d[point.x][point.y] + 1;
            }
        }
    }
}
