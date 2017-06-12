package com.arithmetic.exhaust;

/**
 * 
 * **题目：
 * 
 * 给定整数a1、a2、...、an，判断是否可以从中选出若干数，使他们的和为k
 * 
 * 输入：
 * 
 * n=4,a={1,2,4,7},k=13
 * 
 * 输出：
 * 
 * yes
 * 
 * (13 = 2 + 4 + 7)
 * 
 * **思路：
 * 
 * 深度优先穷竭（DFS）：从a1开始递归，决定每个数加或者不加，在全部n个数都决定后再判断它们的和是不是k。
 * 
 * 时间复杂度O(2^n)效率极低
 * 
 * @author sunjie at 2017年6月12日
 *
 */
public class DeepExhaust1 {

    static final int n = 4, k = 17;

    static final int[] a = new int[] { 1, 2, 4, 7 };

    public static void main(String[] args) {
        boolean dfs = dfs(0, 0);
        System.out.println(dfs);
    }

    public static boolean dfs(int i, int sum) {
        if (i == n) {
            return sum == k;
        }
        // 不加a[i]
        if (dfs(i + 1, sum)) {
            System.out.println("不加：" + a[i]);
            return true;
        }
        // 加a[i]
        if (dfs(i + 1, sum + a[i])) {
            System.out.println("加：" + a[i]);
            return true;
        }
        // 加不加都不等于k
        return false;
    }
}
