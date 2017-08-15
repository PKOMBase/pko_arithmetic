package com.arithmetic.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * **题目：
 * 
 * 有n个工作，每个工作的开始时间是s[],结束时间是t[],同一时刻不能干两个工作（工作时间不能重叠，前一段工作的结束时间等于后一段的开始时间也算作重叠）
 * 
 * 最多能承接多少份工作
 * 
 * 输入：
 * 
 * n=5,s={1,3,5,7,9},t={4,6,8,10,12}
 * 
 * 输出：
 * 
 * 3
 * 
 * ({1,4},{5,8},{9,12})
 * 
 * 
 * **思路：
 * 
 * 贪心算法：在可选工作中，优先选择结束时间最小的工作
 * 
 * 
 * 
 * @author sunjie at 2017年5月25日
 *
 */
public class Greedy2 {

    private static int[] s = new int[] { 1, 3, 5, 7, 9 };

    private static int[] t = new int[] { 10, 6, 8, 10, 12 };

    private static Pair<Integer, Integer>[] pairs = new Pair[s.length];

    static class Pair<F, S> {

        private F first;

        private S second;

        public F getFirst() {
            return first;
        }

        public void setFirst(F first) {
            this.first = first;
        }

        public S getSecond() {
            return second;
        }

        public void setSecond(S second) {
            this.second = second;
        }

        @Override
        public String toString() {
            return "Pair [first=" + first + ", second=" + second + "]";
        }

    }

    public static void main(String[] args) {
        // 组装pairs
        Pair<Integer, Integer> pair;
        for (int i = 0; i < t.length; i++) {
            pair = new Pair<Integer, Integer>();
            pair.setFirst(s[i]);
            pair.setSecond(t[i]);
            pairs[i] = pair;
        }
        // 排序
        Arrays.sort(pairs, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                if (o1 == null || o2 == null) {
                    return 0;
                }
                return o1.getSecond().compareTo(o2.getSecond());
            }
        });

        int count = 0;
        int prevt = 0;// 上一段的结束时间
        for (int i = 0; i < pairs.length; i++) {
            // 判断有效工作段
            if (prevt >= pairs[i].getFirst()) {
                continue;
            }
            prevt = pairs[i].getSecond();
            count++;
            System.out.println("result:" + pairs[i]);
        }
        System.out.println(count);
    }
}
