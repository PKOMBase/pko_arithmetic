package com.arithmetic.array;

public class FastSort {
    public static void main(String[] args) {
        int[] array = new int[] { 3, 5, 7, 2, 6, 1, 3, 8, 4, 2134, 1234, 2134, 2132, 1, 421, 4213214, };

        fastSort(array, 0, array.length - 1);
        print(array);
    }

    private static void fastSort(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }
        int low = l;
        int high = r;
        int key = array[low];
        while (low < high) {
            for (;; high--) {
                if (high <= low) {
                    break;
                }
                if (array[high] < key) {
                    array[low] = array[high];
                    break;
                }
            }
            for (;; low++) {
                if (high <= low) {
                    break;
                }
                if (array[low] > key) {
                    array[high] = array[low];
                    break;
                }
            }
        }
        if (low == high) {
            array[low] = key;
        }
        // 分而治之
        fastSort(array, l, low - 1);

        fastSort(array, low + 1, r);

    }

    private static void print(int[] array) {
        System.out.println();
        for (int i : array) {
            System.out.print(i + ", ");
        }
    }
}
