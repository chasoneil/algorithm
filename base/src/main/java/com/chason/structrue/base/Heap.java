package com.chason.structrue.base;

import com.chason.structrue.utils.Utils;

/**
 * 堆的简单实现
 */
public class Heap {

    private int heapSize;

    private static final int DEFAULT_LIMIT = 10;

    private int capacity;

    private int[] heap;

    public int size() {
        return heapSize;
    }

    public Heap (int capacity) {
        this.capacity = capacity > DEFAULT_LIMIT ? capacity : DEFAULT_LIMIT;
        heap = new int[this.capacity];
    }

    public Heap() {
        this(DEFAULT_LIMIT);
    }



    /**
     * 向堆中放元素
     * @param value
     */
    public void push (int value) {

        if (heapSize >= capacity) {
            throw new RuntimeException("Heap is full");
        }

        heap[heapSize] = value;
        heapSize++;
        heapInsert(heap, heapSize-1);
    }

    /**
     * 重新组织堆结构，将新插入的元素排进堆中
     */
    public static void heapInsert(int[] arr, int index) {

        // 当前数 > 父节点 || 父节点就是跟那也满足前面一个条件
        while (arr[index] > arr[(index-1)/2]) {
            Utils.swap(arr, index, (index-1)/2);
            index = (index-1)/2;
        }

    }

    // 大根堆的头节点 其实就是最大值
    public int pop() {
        int res = heap[0];
        // 将数组结尾的数和数组头的数交换
        Utils.swap(heap, 0, heapSize-1);
        heapSize--;
        heapIfy(heap, 0, heapSize);
        return res;
    }

    /*
        重新调整堆结构，经过交换，现在堆的 0 位置可能不合适
        通过向下调整 保证堆结构的正确性
     */
    public static void heapIfy (int[] arr, int index, int heapSize) {

        int left = index * 2 + 1;
        // 还有子节点 (先有left,right再说) && 子节点中存在比他还大的值
        while (left < heapSize) {
            int right = index *2 + 2;
            int maxIndex = left;
            if (right < heapSize) { // 存在right
                maxIndex = arr[left] > arr[right] ? left : right;
                maxIndex = arr[index] > arr[maxIndex] ? index : maxIndex;
            } else {
                maxIndex = arr[left] > arr[index] ? left : index;
            }

            if (maxIndex == index) {
                break;
            }

            Utils.swap(arr, index, maxIndex);
            index = maxIndex;
            left = 2 * index + 1;
        }
    }

    public static void main(String[] args) {

        Heap heap1 = new Heap();

        heap1.push(3);
        heap1.push(2);
        heap1.push(4);
        heap1.push(6);
        heap1.push(1);
        heap1.push(7);

        Utils.printArray(heap1.heap);

        System.out.println(heap1.pop());

        Utils.printArray(heap1.heap);

    }


}
