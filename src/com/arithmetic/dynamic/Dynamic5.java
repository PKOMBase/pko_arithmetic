package com.arithmetic.dynamic;

/**
 * 
 * **题目：
 * 
 * 有n个种不同大小的数字ai,每种各mi个。判断是否可以从这些数字中选出若干，使它们和为K。
 * 
 * 输入：
 * 
 * n=3，a={3,5,8}，m={3,2,2},K=17
 * 
 * 输出：
 * 
 * yes
 * 
 * (3*3+8=17)
 * 
 * **思路：
 * 
 * 推理动态规划公式：
 * 
 * 如果dp[i][j]已知（在前ai种数中，能否选出数字和为j的），则dp[i+1][j]：
 * 
 * dp[i][j-a[i]*x]
 * 
 * 
 * 
 * @author sunjie at 2017年6月13日
 *
 */
public class Dynamic5 {

    private static int n = 3, k = 17;

    private static int[] a = new int[] { 3, 5, 8 };

    private static int[] m = new int[] { 3, 2, 2 };

    private static boolean[][] dp = new boolean[n + 1][k + 1];

    public static void main(String[] args) {
        dp();
        System.out.println(dp[n][k]);
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                System.out.println("(" + i + "," + j + "), value:" + dp[i][j]);
            }
        }

    }

    public static void dp() {
        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                for (int x = 0; j >= a[i] * x && m[i] >= x; x++) {
                    if (dp[i][j - a[i] * x]) {// 如果循环已经找到true，则不再执行
                        dp[i + 1][j] = true;
                        break;
                    } else {
                        dp[i + 1][j] = false;
                    }
                    // dp[i + 1][j] = dp[i + 1][j] | dp[i][j - a[i] * x];
                }
            }
        }
    }
}
