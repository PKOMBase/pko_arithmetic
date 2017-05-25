package com.arithmetic.array;

/**
 * 
 * 堆排序
 * 
 * **思路：
 * 
 * 1、将数组重构为大根堆或小根堆
 * 
 * 2、将堆结构最后一个元素与首个元素交换，将首个元素踢出堆结构，作为结果记录
 * 
 * 3、将剩余（比第2步少了一个元素）结构重新调整为堆
 * 
 * 4、重复2、3步，直到堆结构的元素全部被踢出
 * 
 * **调整为堆结构：
 * 
 * 1、将数组想象为二叉树
 * 
 * 2、排除叶子节点（每个叶子节点我们认为是一个堆结构，因为它不存在子节点），倒序遍历非叶子节点
 * 
 * 3、比较每个非叶子节点和他的最大子点（所有子节点中最大的），若子节点大，则交换位置
 * 
 * 4、交换位置后，替换的这个子节点继续执行3，直到没有子节点，或所有子节点均小于它
 * 
 * 
 * @author sunjie at 2017年5月25日
 *
 */
public class HeapSort {

    public static void main(String[] args) {
        // 初始化一个序列
        int[] array = new int[] { 3, 5, 7, 2, 6, 1, 3, 8, 4 };

        heapSort(array);

        System.out.print("\nresult:\n");
        print(array);
    }

    private static void print(int[] array) {
        for (int i : array) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    public static void heapAdjust(int[] array, int parent, int length) {
        int temp = array[parent]; // temp保存当前父节点
        int child = 2 * parent + 1; // 先获得左孩子

        while (child < length) {
            // 选择最大值的子节点（如果有的话）
            if (child + 1 < length && array[child] < array[child + 1]) {
                child++;
            }

            // 如果父结点的值已经大于子结点的值，则直接结束
            if (temp >= array[child])
                break;

            // 交换
            array[parent] = array[child];
            array[child] = temp;

            // 继续向下筛选
            parent = child;
            child = 2 * child + 1;
        }
    }

    public static void heapSort(int[] list) {
        // 循环建立初始堆
        for (int i = list.length / 2; i >= 0; i--) {
            heapAdjust(list, i, list.length - 1);
        }
        System.out.print("init heap:\n");
        print(list);

        // 进行n-1次倒序循环，完成排序
        for (int i = list.length - 1; i > 0; i--) {
            // 交换最后一个元素和第一元素
            int temp = list[i];
            list[i] = list[0];
            list[0] = temp;

            // 筛选 R[0] 结点，得到i-1个结点的堆
            heapAdjust(list, 0, i);

            System.out.format("\nthe " + (list.length - i) + " step: \n");
            print(list);
        }
    }

}
