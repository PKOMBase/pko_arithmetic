package com.arithmetic.greedy;

/**
 * 
 * **题目：
 * 
 * 直线上有N个点，点i的位置是Xi。从这N个点中选择若干个，加上标记。对每一个点，其距离R以内需要有带标记的点。若想满足条件，至少有多少个点被标记。
 * 
 * 输入：
 * 
 * n=6,r=10,x={1,7,15,20,30,50}
 * 
 * 输出：
 * 
 * 3
 * 
 * (7,20,50)
 * 
 * 
 * **思路：
 * 
 * 贪心算法：从最左边点开始，取据最左边点右侧R距离范围内的最远点，进行标记。然后移除该标记点所覆盖R距离内的点，在剩余的点中重复算法，直到点都被移除。
 * 
 * @author sunjie at 2017年5月26日
 *
 */
public class Greedy4 {
    public static void main(String[] args) {
        int n = 6, r = 10;

        // 需要有序，若无序，需要小到大排序
        int[] x = new int[] { 1, 7, 15, 20, 30, 50 };

        int count = 0;

        // 最左侧点
        int i = 0;
        while (i < n) {
            int distance = x[i] + r;
            // 找到离max最近的点,进行标记（标记下表应为p=i-1）
            while (i < n && x[i] <= distance) {
                i++;
            }
            System.out.println("p index:" + (i - 1) + ", value:" + x[i - 1]);
            // 移除p=i-1右侧距离R内的点
            int pDistance = x[i - 1] + r;
            while (i < n && x[i] <= pDistance) {
                i++;
            }
            count++;
        }
        System.out.println("result:" + count);
    }
}
