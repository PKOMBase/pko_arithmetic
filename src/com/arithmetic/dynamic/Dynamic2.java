package com.arithmetic.dynamic;

/**
 * 
 * **题目：
 * 
 * 给定一个字符串s1s2...sn。求这字符串子序列的个数。子序列指可以表示为Si1Si2...Sim(1<=i1<i2< ...<in<=n)的序列
 * 
 * 输入：
 * 
 * n=4,s="abcd"
 * 
 * 输出：
 * 
 * 3
 * 
 * ("bcd")
 * 
 * **思路：
 * 
 * 1、推理动态规划公式：
 * 
 * 若dp[i]已知（前i个字符组成字符串的子序列个数），则dp[i+1]有两种情况，一是尾部追加s[i]，一是不追加s[i]，故
 * 
 * dp[i+1]=(dp[i]+1)+dp[i] = 2*dp[i]+1
 * 
 * 
 * @author sunjie at 2017年6月13日
 *
 */
public class Dynamic2 {

    private static int n = 4;

    private static char[] s = new char[] { 'a', 'b', 'c', 'd', 'e' };
    // 0字符
    // 0

    // 1个字符
    // 1

    // 2个字符
    // 2
    // 1

    // 3个字符
    // 3
    // 3
    // 1

    // 4个字符
    // 1字符:4
    // 2字符:a:4;b:2;c:1;d:0;e:=6
    // 3字符:a:2+1;b:1;c:0;d:0=4
    // 4字符:1

    // 5个字符
    // 1字符:5
    // 2字符:a:4;b:3;c:2;d:1;e:0=10
    // 3字符:a:3+2+1;b:2+1;c:1;d:0;e:0=10
    // 4字符:a:2+1;b:1;=4
    // 5字符:1

    private static int[] dp = new int[n + 1];

    public static void main(String[] args) {
        dp();
        for (int i = 0; i < n + 1; i++) {
            System.out.println("i:" + i + ", value:" + dp[i]);
        }
    }

    public static void dp() {
        for (int i = 0; i < n; i++) {
            dp[i + 1] = dp[i] * 2 + 1;
        }
    }

}
