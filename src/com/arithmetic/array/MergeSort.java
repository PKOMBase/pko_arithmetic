package com.arithmetic.array;

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
