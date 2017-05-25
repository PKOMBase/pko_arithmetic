package com.arithmetic.greedy;

/**
 * 
 * **题目：
 * 
 * 有1，5，10，50，100，500元面值的硬币，每个硬币有C1、C5、C10、C50、C100、C500个，现在需要用这些硬币支付N元钱，
 * 最少需要多少硬币。
 * 
 * 输入：
 * 
 * C1=3，C5=2，C10=1，C50=3，C100=0，C500=2，N=620
 * 
 * 输出：
 * 
 * 6
 * 
 * (其中500=1,50=2,10=1,5=2)
 * 
 * **思路：
 * 
 * 贪心算法：优选选择面值大的硬币
 * 
 * 1、从大到小遍历6种硬币
 * 
 * 2、每一种硬币的使用最大值，与硬币数量的最小值，即是使用该硬币的数量
 * 
 * 3、余额减去已经使用的硬币，继续循环
 * 
 * @author sunjie at 2017年5月25日
 *
 */
public class Greedy1 {

    public static void main(String[] args) {
        int[] v = new int[] { 1, 5, 10, 50, 100, 500 };
        int[] c = new int[] { 3, 2, 1, 3, 0, 2 };
        int n = 620;
        int count = 0;
        // 从大面值开始
        for (int i = v.length - 1; i >= 0; i--) {
            // 使用硬币的数量
            int t = Math.min(n / v[i], c[i]);
            n = n - v[i] * t;
            count = count + t;
        }
        System.out.println(count);
    }
}
