package com.arithmetic.dynamic;

/**
 * 
 * **题目：
 * 
 * 给定2个字符串s1s2...sn和t1t2...tm。求这两个字符串最长的公共子序列的长度。公共子序列指可以表示为Si1Si2...Sin(i1<i2<
 * ...<in)的序列
 * 
 * 输入：
 * 
 * n=4,m=4,s="abcd",t="becd"
 * 
 * 输出：
 * 
 * 3
 * 
 * ("bcd")
 * 
 * **思路：
 * 
 * 推理动态规划公式：
 * 
 * 若dp[i][j]已知（s1s2...si和t1t2...tj字符串的最长公共子序列长度），则dp[i+1][j+1]情况如下：
 * 
 * 1.若s[i+1]=t[j+1]，则将s[i+1]/t[j+1]这个字符添加在dp[i][j]这个最长公共子序列之后，即是dp[i+1][j+1]
 * 的最大公共子序列，dp[i+1][j+1]=dp[i][j]+1
 * 
 * 
 * 2.若s[i+1]!=t[j+1]，则dp[i+1][j+1]的最大公共子序列是dp[i+1][j]、dp[i][j+1]两者之一，dp[i+1][j+1
 * ]=max(dp[i+1][j]、 dp[i][j+1])。
 * 
 * @author sunjie at 2017年6月13日
 *
 */
public class Dynamic3 {

    private static int n = 6, m = 5;

    private static char[] s = new char[] { 'a', 'b', 'c', 'd', 'f', 'e' };

    private static char[] t = new char[] { 'b', 'e', 'c', 'd', 'e' };

    private static int[][] dp = new int[n + 1][m + 1];

    public static void main(String[] args) {
        dp();

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                System.out.println("(" + i + "," + j + "),results:" + dp[i][j]);
            }
        }
    }

    public static void dp() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (s[i] == t[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
    }
}
