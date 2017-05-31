package com.arithmetic.exhaust;

/**
 * 
 * **题目：
 * 
 * 有一个大小为N*M的院子，雨后积水。八连通的积水被认为是连接在一起的。求院子共有多少个水洼。
 * 
 * 八连通如下：
 * 
 * 
 * AAA<br>
 * AXA<br>
 * AAA<br>
 * 
 * 输入：
 * 
 * N=10,M=12,院子如下(W表示积水，.表示无水)：
 * 
 * W........WW.<br>
 * .WWW.....WWW<br>
 * ....WW...WW.<br>
 * .........WW.<br>
 * .........W..<br>
 * ..W......W..<br>
 * .W.W.....WW.<br>
 * W.W.W.....W.<br>
 * .W.W......W.<br>
 * ..W.......W.<br>
 * 
 * 输出：
 * 
 * 3
 * 
 * **思路：
 * 
 * 从任意W开始，使用深度优先穷竭（DFS）不断的将本身与相邻的地方（八连通的）用.代替，直到数据中不存在W为止。进行DFS的次数就是答案。
 * 
 * 时间复杂度O(8*N*M)
 * 
 * @author sunjie at 2017年5月26日
 *
 */
public class DeepExhaust2 {
    static final int n = 10, m = 12;
    static final char[][] field = new char[][] { { 'W', '.', '.', '.', '.', '.', '.', '.', '.', 'W', 'W', '.' },
            { '.', 'W', 'W', 'W', '.', '.', '.', '.', '.', 'W', 'W', 'W' },
            { '.', '.', '.', '.', 'W', 'W', '.', '.', '.', 'W', 'W', '.' },
            { '.', '.', '.', '.', '.', '.', '.', '.', '.', 'W', 'W', '.' },
            { '.', '.', '.', '.', '.', '.', '.', '.', '.', 'W', '.', '.' },
            { '.', '.', 'W', '.', '.', '.', '.', '.', '.', 'W', '.', '.' },
            { '.', 'W', '.', 'W', '.', '.', '.', '.', '.', 'W', 'W', '.' },
            { 'W', '.', 'W', '.', 'W', '.', '.', '.', '.', '.', 'W', '.' },
            { '.', 'W', '.', 'W', '.', '.', '.', '.', '.', '.', 'W', '.' },
            { '.', '.', 'W', '.', '.', '.', '.', '.', '.', '.', 'W', '.' } };

    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 如果等于W，则开始进行dfs
                if (field[i][j] == 'W') {
                    dfs(i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void dfs(int x, int y) {
        // 将W替换为.
        field[x][y] = '.';

        // 取该位置八连通位置(x、y分别3种，共9种)，排除.和院外位置
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                int newx = x + dx;
                int newy = y + dy;
                // x坐标越界
                if (newx < 0 || newx >= n) {
                    continue;
                }
                // y坐标越界
                if (newy < 0 || newy >= m) {
                    continue;
                }
                // 该位置已经是.
                if (field[newx][newy] == '.') {
                    continue;
                }
                dfs(newx, newy);
            }
        }
    }
}
