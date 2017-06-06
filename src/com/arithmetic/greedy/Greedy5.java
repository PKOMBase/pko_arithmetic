package com.arithmetic.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * **题目：
 * 
 * 将一块长L的木板切割成N块，准备切成的木板长度为L1、L2、...、Ln，未切割前的长度与切割后木板长度相等(L=L1+L2+...+Ln)。
 * 
 * 每次切割木板时，需要的开销==这块木板的长度。例如：将L=21的木板切割成5、8、8三块时，首先切成13、8，开销为21；然后将13切成5、8，开销为13
 * ；则总开销为21+13=34
 * 
 * 求切割指定长度木板需要的最小开销
 * 
 * 输入：
 * 
 * n=3,L={8，5，8}
 * 
 * 输出：
 * 
 * 34
 * 
 * ({21}->{13、8}->{5、8、8})
 * 
 * 
 * **思路：
 * 
 * 贪心算法：由于切割次数固定为n-1，故最短的两块应该最后切，才能保证开销小。
 * 
 * 原因：
 * 
 * 若切割顺序为：
 * {L1、Lother1(L-L1)}->{L1、L2、Lother2(L-L1-L2)}->{L1、L2、L3、Lother3(L-L1-L2
 * -L3)}->...{L1、L2、...、Ln-1、Lothern-1(L-L1-L2-...-Ln-1)}<BR>
 * 
 * 则所需的开销为(其中L=L1+L2+...+Ln)：
 * 
 * =L1+Lother1<BR>
 * +L2+Lother2<BR>
 * +L3+Lother3<BR>
 * +...<BR>
 * +Ln-1+Lothern-1(L-L1-L2-...-Ln-1)<BR>
 * 
 * =L1+(L-L1)<BR>
 * +L2+(L-L1-L2)<BR>
 * +L3+(L-L1-L2-L3)<BR>
 * +...<BR>
 * +Ln-1+(L-L1-L2-...-Ln-1)<BR>
 * 
 * =L1+(L1+L2+...+Ln-L1)<BR>
 * +L2+(L1+L2+...+Ln-L1-L2)<BR>
 * +L3+(L1+L2+...+Ln-L1-L2-L3)<BR>
 * +...<BR>
 * +Ln-1 +(L1+L2+...+Ln-L1-L2-...-Ln-1)<BR>
 * 
 * =L1+L2+...Ln<BR>
 * +L2+L3+...+Ln<BR>
 * +L3+L4+...+Ln<BR>
 * +...<BR>
 * +Ln-1+Ln<BR>
 * 
 * =L1 + 2*L2 + 3*L3 + ... + (n-1)*Ln-1 + (n-1)*Ln
 * 
 * 故如果取最小值，需要Ln和Ln-1最小，...L1最大。(例子中5、8、8，按照公式则最小开销为=1*8 + 2*8 + 2*5=34)
 * 
 * 
 * @author sunjie at 2017年5月26日
 *
 */
public class Greedy5 {
    public static void main(String[] args) {
        int n = 3;

        Integer[] l = new Integer[] { 8, 5, 8 };

        int sum = 0;

        // 排序，大到小
        Arrays.sort(l, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        System.out.println("sort:" + Arrays.toString(l));

        // 代入公式
        for (int i = 0; i < l.length; i++) {
            if (i == l.length - 1) {
                sum += i * l[i];
            } else {
                sum += (i + 1) * l[i];
            }
        }

        System.out.println("result:" + sum);
    }
}
