package com.arithmetic.array;

/**
 * 
 * 并归算法排序
 * 
 * **思路：
 * 
 * 将数组划分为若干个有序数组（一般查分为每组1个元素），将这些有序数组两两合并为一个有序数组，不断重复该步骤，直到合成为一个数组。
 * 
 * **两个有序数组合并：
 * 
 * 1、新建结果数组，两个数组分别设置两个游标
 * 
 * 2、比较两个游标指向的数据，将较小（小到大的情况）的插入结果数组，并且右移该游标继续比较
 * 
 * 3、直到某一个游标指向数组末尾，将另一个数组游标指向的元素及之后的所有元素放入结果数组
 * 
 * @author sunjie at 2017年5月25日
 *
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = { 3, 5, 7, 2, 6, 1, 3, 8, 4 };
        // O(nlogn)
        mergeSort(array, 0, array.length - 1);

        for (int i : array) {
            System.out.print(i + ",");
        }
    }

    private static void mergeSort(int[] array, int l, int r) {
        if (l == r) {
            return;
        }
        int m = (l + r) / 2;
        mergeSort(array, l, m);// 左

        mergeSort(array, m + 1, r);// 右

        mergeArray(array, l, m, r);
    }

    private static void mergeArray(int[] array, int l, int m, int r) {
        // start1 = l; end1 = m;
        // start2 = m+1; end2 = r;
        int[] temp = new int[r - l + 1];
        int i = l;
        int j = m + 1;
        int k = 0;// temp下标

        while (i <= m && j <= r) {
            temp[k++] = array[i] < array[j] ? array[i++] : array[j++];
        }
        // 右侧数组用完
        while (i <= m) {
            temp[k++] = array[i++];
        }
        // 左侧数组用完
        while (j <= r) {
            temp[k++] = array[j++];
        }

        for (int x = 0, y = l; x < temp.length; x++, y++) {
            array[y] = temp[x];
        }
    }
}
