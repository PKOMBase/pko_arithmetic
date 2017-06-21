package com.arithmetic.dynamic;

/**
 * 
 * **题目：
 * 
 * 有n个重量和价值分别为Wi,Vi的物品。从这些物品中选出总重量不超过k的物品（每个物品有无限多个，且可以选多个），求所有方案中价值总和的最大值
 * 
 * 输入：
 * 
 * n=3，(w,v)={(3,4),(4,5),(2,3)}, k=7
 * 
 * 输出：
 * 
 * 10
 * 
 * (选0，2，2号)
 * 
 * **思路：
 * 
 * 推理动态规划公式：
 * 
 * 如果dp[i][j]已知（在前i件物品中，选出总重量不超过j的物品，价值总和的最大值），则dp[i+1][j]有两种情况，
 * 
 * 一是放入x个第i个物品（dp[i][j-w[i]*x]+v[i]*x），
 * 
 * 一是不放入（dp[i][j]），取这两者最大的。
 * 
 * 
 * dp[i+1][j] = max(dp[i][j],dp[i][j-w[i]*x]+v[i]*x)
 * 
 * 
 * @author sunjie at 2017年6月13日
 *
 */
public class Dynamic4 {

    private static int n = 3, k = 7;

    private static int[] w = new int[] { 3, 4, 2 };

    private static int[] v = new int[] { 4, 5, 3 };

    private static int[][] dp = new int[n + 1][k + 1];

    public static void main(String[] args) {
        dp();
        System.out.println(dp[n][k]);
    }

    public static void dp() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                // int max = dp[i][j];
                // for (int x = 0; j >= w[i] * x; x++) {
                // max = Math.max(dp[i][j - w[i] * x] + v[i] * x, max);
                // }
                // dp[i + 1][j] = max;
                dp[i + 1][j] = dp[i][j];
                for (int x = 0; j >= w[i] * x; x++) {
                    dp[i + 1][j] = Math.max(dp[i][j - w[i] * x] + v[i] * x, dp[i + 1][j]);
                }
            }
        }
    }
}
