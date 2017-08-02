package com.arithmetic.dynamic;

/**
 * 
 * **题目：
 * 
 * 有n个重量和价值分别为Wi,Vi的物品。从这些物品中选出总重量不超过k的物品，求所有方案中价值总和的最大值
 * 
 * 输入：
 * 
 * n=4，(w,v)={(2,3),(1,2),(3,4),(2,2)}, k=5
 * 
 * 输出：
 * 
 * 7
 * 
 * (选0，1，3号)
 * 
 * **思路：
 * 
 * 1、深度优先穷竭算法：针对每个物品都做两种选择：放入、不放入。直到没有剩余的物品
 * 
 * 2、记忆化算法：将每一次的结果都记录下来，供之后使用
 * 
 * 3、推理动态规划公式：
 * 
 * 如果dp[i][j]已知（在前i件物品中，选出总重量不超过j的物品，价值总和的最大值），则dp[i+1][j]有两种情况，一是放入第i个物品（dp[i][
 * j-w[i]]+v [i]），一是不放入（dp[i][j]）， 取这两者最大的。
 * 
 * dp[i+1][j] = max(dp[i][j],dp[i][j-w[i]]+v[i])
 * 
 * 等同于：
 * 
 * 若j<w[i] dp[i][j] = dp[i+1][j]
 * 
 * 若j>=w[i] dp[i][j] = max(dp[i+1][j],dp[i+1][j-w[i]]+v[i])
 * 
 * 
 * @author sunjie at 2017年6月13日
 *
 */
public class Dynamic1 {

    private static int n = 4, k = 5;

    private static int[] w = new int[] { 2, 1, 3, 2 };

    private static int[] v = new int[] { 3, 2, 4, 2 };

    public static void main(String[] args) {
        // System.out.println(dfs(0, k));
        //
        // for (int i = 0; i < n + 1; i++) {
        // for (int j = 0; j < k + 1; j++) {
        // dp[i][j] = -1;
        // }
        // }
        // System.out.println(dynamic(0, k));
        // dp();
        // for (int i = 0; i < n + 1; i++) {
        // for (int j = 0; j < k + 1; j++) {
        // System.out.println("(" + i + "," + j + "), value:" + dp[i][j]);
        // }
        // }
        dp1();
        for (int j = 0; j < k + 1; j++) {
            System.out.println("(" + j + "), value:" + dp1[j]);
        }

    }

    /**
     * 
     * 
     *
     * @author sunjie at 2017年6月14日
     *
     * @param i
     * @param w
     * @return
     */
    public static int dfs(int i, int w) {
        // 如果没有剩余的物品了
        if (i == n) {
            return 0;
        }
        // 若选择该物品超出重量
        else if (Dynamic1.w[i] > w) {
            return dfs(i + 1, w);
        }
        // 不放、放入两种情况都处理，取比较大的v
        else {
            return Math.max(dfs(i + 1, w), dfs(i + 1, w - Dynamic1.w[i]) + v[i]);
        }
    }

    private static int[][] dp = new int[n + 1][k + 1];
    private static int[] dp1 = new int[k + 1];

    public static int dynamic(int i, int w) {
        if (dp[i][w] >= 0) {
            return dp[i][w];
        }
        int result = 0;
        // 如果没有剩余的物品了
        if (i == n) {
            result = 0;
        }
        // 若选择该物品超出重量
        else if (Dynamic1.w[i] > w) {
            result = dynamic(i + 1, w);
        }
        // 放入、不放入两种情况都处理，取比较大的v
        else {
            result = Math.max(dynamic(i + 1, w), dynamic(i + 1, w - Dynamic1.w[i]) + v[i]);
        }
        dp[i][w] = result;
        System.out.println("(" + i + "," + w + "),res:" + result);
        return result;
    }

    public static void dp() {
        for (int i = 0; i < n; i++) {// 从第0个物品到第n-1个共n次
            for (int j = 0; j <= k; j++) {// 从重0到重k共k+1次（0也算）
                // dp[i+1][j] = max(dp[i][j],dp[i][j-w[i+1]]+v[i+1])
                if (j < w[i]) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - w[i]] + v[i]);
                }
            }
        }
    }

    public static void dp1() {
        for (int i = 0; i < n; i++) {// 从第0个物品到第n-1个共n次
            for (int j = k; j >= w[i]; j--) {//
                // if (j < w[i]) {
                // dp1[j] = 0;
                // } else {
                dp1[j] = Math.max(dp1[j], dp1[j - w[i]] + v[i]);// 只会用到j或者比j小的（j-w[i]）下标，故通过j的倒遍历即可使用一个数组进行处理
                // }
                System.out.println("(" + i + "," + j + "), value:" + dp1[j]);
            }
        }
    }
}
