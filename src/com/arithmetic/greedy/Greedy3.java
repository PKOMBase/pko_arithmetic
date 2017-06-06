package com.arithmetic.greedy;

/**
 * 
 * **题目：
 * 
 * 
 * 
 * 
 * **思路：
 * 
 * 贪心算法1(复杂，难实现)：优先取S开头或结尾较小字符的放入T。若首位相等，则递归比较下一个字符。
 * 
 * 贪心算法2(源于1，实现简单):按字典顺序比较S和S'(S的反串)。若S小，则取S的开头放入T；若S'小，则取S'的结尾放入T。<BR>
 * （特别的：如果S=S'，则取那个都可以）
 * 
 * @author sunjie at 2017年5月26日
 *
 */
public class Greedy3 {
    public static void main(String[] args) {
        int n = 6;
        String s = "ACDBCB";
        char[] sChars = s.toCharArray();
        String t = "";

        // 定义两个游标，指向首和尾
        int a = 0, b = sChars.length - 1;

        while (a <= b) {
            boolean isLeft = false;
            // 逐位比较正串和反串
            for (int i = 0; a + i < b; i++) {
                if (sChars[a + i] < sChars[b - i]) {
                    isLeft = true;
                    break;
                }
                if (sChars[a + i] > sChars[b - i]) {
                    isLeft = false;
                    break;
                }
            }
            if (isLeft) {
                t += sChars[a++];
            } else {
                t += sChars[b--];
            }
        }

        System.out.println("result:" + t);
    }
}
