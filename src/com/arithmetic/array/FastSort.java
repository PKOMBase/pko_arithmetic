package com.arithmetic.array;

/**
 * 
 * 快速算法排序
 * 
 * **思路：
 * 
 * 1、选择一个数据中的值作为基准值（可以取第0个元素），将数组分为两段。
 * 
 * 2、左段首位、右段尾位各设置两个游标，比较两个游标所指向的元素，首先以右侧游标位基准。
 * 
 * 2.1、若左侧小于等于右侧，则右侧游标向左移动，移动后继续比较，直到两个游标相撞或满足2.2
 * 
 * 2.2、若左侧大于右侧，则用右侧游标指向的元素替换左侧游标指向的元素（小到大的情况），基准改为左侧游标，左侧游标右移后重复2；
 * 
 * 3、重复2，直到两个游标相撞，用基准值替换两个游标指向的元素（同一个），这是，以基准值切分的两段数组，左侧的元素均小于右侧的（小到大的情况）
 * 
 * 4、将这两段数组分别重复1、2、3步骤，直到每组只剩一个元素
 * 
 * @author sunjie at 2017年5月25日
 *
 */
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
