package com.chason.class05._01_堆;

/**
 * 堆的基本操作和堆排序
 * 用数组实现一个堆
 */
public class Heap {

    private static int DEFAULT_CAPACITY = 4;

    private int capacity;

    private int[] heapArray;

    private int heapSize = 0;

    public Heap (int capacity) {
        this.capacity = capacity < DEFAULT_CAPACITY ? DEFAULT_CAPACITY : capacity;
        heapArray = new int[this.capacity];
    }

    public int[] getHeapArray() {
        int[] arr = new int[heapSize];
        for (int i=0; i<heapSize; i++) {
            arr[i] = heapArray[i];
        }
        return arr;
    }

    /**
     * 向堆中添加一个数
     * @param value 添加的数
     */
    public void add(int value) {

        if (heapSize == capacity) {
            throw new RuntimeException("Heap is full");
        }

        heapArray[heapSize] = value;  // 将 value 放到数组当前的结尾
        heapInsert(heapArray, heapSize++);
    }

    /**
     * 返回当前堆顶的数，不弹出
     * @return 当前堆顶的值
     */
    public int peek() {

        if (heapSize == 0) {
            throw new RuntimeException("Heap is empty");
        }

        return heapArray[0];
    }

    /**
     * 弹出当前堆顶的数
     * @return 弹出堆顶的数
     */
    public int poll() {

        if (heapSize == 0) {
            throw new RuntimeException("Heap is empty");
        }

        int result = heapArray[0];
        swap(heapArray, 0, --heapSize);
        heapIfy(heapArray, 0, heapSize);
        return result;
    }

    public static void heapSort (int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i=0; i<arr.length; i++) {
            heapInsert(arr, i);
        }

        int heapSize = arr.length;
        swap(arr, 0, --heapSize);

        while (heapSize > 0) {
            heapIfy(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }

    }

    /**
     * 在数组 arr 中， 新加入了一个数，新的数位置在index, 通过调整
     * 将 arr 的结构维持为大根堆
     * @param arr 无序数组
     * @param index 新数的index
     */
    private static void heapInsert (int[] arr, int index) {
        while (arr[index] > arr[(index-1)/2]) {    // 当 index =0 这个判断条件必然不成立  arr[0] > arr[0] 必然错
            swap(arr, index, (index-1)/2);
            index = (index-1)/2;
        }
    }

    /**
     * 从 index 位置往下调整
     * 将 整个数组调整成 大根堆结构
     * @param arr  堆数组
     * @param index 从index位置往下看
     * @param heapSize 堆的大小
     */
    private static void heapIfy (int[] arr, int index, int heapSize) {

        int left = 2 * index + 1;

        while (left < heapSize) { // 左子树如果越界,那么右子树一定越界

            int largeIndex = left + 1 < heapSize && arr[left+1] > arr[left] ? left + 1 : left;
            largeIndex = arr[largeIndex] > arr[index] ? largeIndex : index;

            if (index == largeIndex) {
                break;
            }

            swap(arr, largeIndex, index);
            index = largeIndex;
            left = 2 * index + 1;
        }

    }


    private static void swap (int[] arr, int i, int j) {

        if (i == j) {
            return;
        }

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
