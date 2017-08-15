package com.arithmetic.greedy;

/**
 * 
 * **题目：
 * 
 * 长度为N的字符串S，要构造一个长度为N的字符串T。起初，T是一个空串，随后反复进行如下任意操作：
 * 
 * -从S的头部移除一个字符，加到T的尾部
 * 
 * -从S的尾部移除一个字符，加到T的尾部
 * 
 * 目标是构造字典顺序（逐位自然比较）最小的T
 * 
 * 输入：
 * 
 * n=6,s="ACDBCB"
 * 
 * 输出：
 * 
 * ABCBCD
 * 
 * ({s="ACDBCB",T=""}->{s="CDBCB",T="A"}->{s="CDBC",T="AB"}->{s="CDB",T="ABC"}->
 * {s="CD",T="ABCB"}->{s="D",T="ABCBC"}->{s="",T="ABCBCD"})
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

    private static int n = 6;

    private static String s = "ACDBCB";

    public static void main(String[] args) {

        char[] sChars = s.toCharArray();
        String t = "";

        int a = 0, b = sChars.length - 1;

        while (a <= b) {
            boolean isLeft = false;
            // 逐位比较正串反串
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
            // 拼装t
            if (isLeft) {
                t += sChars[a++];
            } else {
                t += sChars[b--];
            }
        }
        System.out.println("result:" + t);
    }
}
