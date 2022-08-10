package sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-10
 * Time: 0:19
 */
public class Sorting {


    /**
     * 插入排序
     * 适合于数据量小并且已经趋于有序的情况下
     * @param array
     */
    public void insertSort(int[] array){
        int j = 0;
        int tmp = 0;
        for (int i = 0; i < array.length; i++) {
            j = i - 1;
            tmp = array[i];
            while(j >= 0){
                if (array[j] > tmp){
                    array[j+1] = array[j];
                    j--;
                }else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

    /**
     * 希尔排序，是一种不稳定排序
     * @param array
     */
    public void realShellSort(int[] array,int gap){
        int j = 0;
        int tmp = 0;
        for (int i = gap; i < array.length; i++) {
            j = i - gap;
            tmp = array[i];
            while(j >= 0){
                if (array[j] > tmp){
                    array[j+gap] = array[j];
                    j -= gap;
                }else {
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }

    public void shellSort(int[] array){
        int gap = array.length;
        while(gap > 1){
            realShellSort(array, gap);
            gap /= 2;
        }
        realShellSort(array, 1);
    }


    /**
     * 直接选择排序 不稳定
     * 时间复杂度 O(n2)
     * 空间复杂度 O(1)
     * @param array
     */
    public void selectSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int recode = 0;
            int min = array[i];
            for (int j = i+1; j < array.length; j++) {
                if (min > array[j]){
                    min = array[j];
                    recode = j;
                }
            }
            if (recode != 0){
                array[recode] = array[i];
                array[i] = min;
            }
        }
    }



    private static void swap(int[] array,int i,int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static void shiftDown(int[] array,int root,int len) {
        int parent = root;
        int child = (2*parent) + 1;
        while (child < len) {
            if(child+1 < len && array[child] < array[child+1]) {
                child++;
            }
            if(array[child] > array[parent]) {
                swap(array,child,parent);
                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }

    private static void createHeap(int[] array) {
        for (int p = (array.length-1-1)/2; p >= 0 ; p--) {
            shiftDown(array,p,array.length);
        }
    }

    /**
     * 时间复杂度：O(n*logn)【不管数据是否有序 都是这样的】
     * 空间复杂度：O(1)
     * 稳定性：不稳定排序
     * @param array
     */
    public static void heapSort(int[] array) {
        createHeap(array);
        int end = array.length-1;
        while (end >= 0) {
            swap(array,0,end);
            shiftDown(array,0,end);
            end--;
        }
    }

    /**
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     * @param array
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j] > array[j+1]) {
                    swap(array,j,j+1);
                }
            }
        }
    }

    public static void bubbleSort2(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            boolean flg = false;
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j] > array[j+1]) {
                    swap(array,j,j+1);
                    flg = true;
                }
            }
            if(!flg) {
                break;
            }
        }
    }


    /**
     * 要注意的地方是如果是取左边的作为关键字，就要右边先走
     * Hoare版
     * @param array
     * @param low
     * @param high
     * @return
     */
    private int partitionHoare(int[] array, int low, int high){
        int i = low;
        int pivot = array[low];
        while (low < high){

            while(low < high && array[high] >= pivot){
                high--;
            }

            while (low < high && array[low] <= pivot){
                low++;
            }

            swap(array,low,high);
        }
        swap(array,low,i);

        return low;
    }

    private void quickHoare(int[] array, int low, int high){
        while(low >= high) return;
        int pivot = partitionHoare(array,low,high);
        quickHoare(array,low,pivot-1);
        quickHoare(array,pivot+1,high);
    }

    public void quickSortHoare(int[] array){
        quickHoare(array,0,array.length-1);
    }


    /**
     * 挖坑法
     * @param array
     * @param low
     * @param high
     * @return
     */

    private int partitionPit(int[] array, int low, int high){
        int tmp = array[low];
        while(low < high){

            while(low < high && array[high] >= tmp){
                high--;
            }
            array[low] = array[high];
            while (low < high && array[low] <= tmp){
                low++;
            }
            array[high] = array[low];
        }
        array[low] = tmp;
        return low;
    }

    private void quickPit(int[] array, int low, int high){
        while(low >= high) return;
        int pivot = partitionHoare(array,low,high);
        quickHoare(array,low,pivot-1);
        quickHoare(array,pivot+1,high);
    }

    public void quickSortPit(int[] array){
        quickHoare(array,0,array.length-1);
    }


    /**
     * 双指针法
     * @param array
     * @param low
     * @param high
     */
    private void partitionPointer(int[] array, int low, int high){
        int cur = low + 1;
        int prev = low;
        while(cur <= high){
            while (array[cur] < array[low] && array[++prev] != array[low]){
                swap(array,cur,prev);
            }
            cur++;
        }

    }

    private static int partitionPointer2(int[] array, int left, int right) {
        int d = left + 1;
        int pivot = array[left];
        for (int i = left + 1; i <= right; i++) {
            if (array[i] < pivot) {
                swap(array, i, d);
                d++;
            }
        }
        swap(array, d - 1, left);
        return d - 1;
    }

    private void quickPointer(int[] array, int low, int high){
        while(low >= high) return;
        int pivot = partitionHoare(array,low,high);
        quickHoare(array,low,pivot-1);
        quickHoare(array,pivot+1,high);
    }

    public void quickSortPointer(int[] array){
        quickHoare(array,0,array.length-1);
    }





























    public static void main(String[] args) {
        int[] array = {12,23,4,676,3,4,68,2,43,5,56,7,23};
        Sorting sorting = new Sorting();



    }

    public static void main5(String[] args) {
        int[] array = {12,23,4,676,3,4,68,2,43,5,56,7,23};
        Sorting sorting = new Sorting();
        sorting.quickSortHoare(array);
        System.out.println(Arrays.toString(array));

        array = new int[]{12,23,4,676,3,4,68,2,43,5,56,7,23};
        sorting.quickSortPit(array);
        System.out.println(Arrays.toString(array));

        array = new int[]{12,23,4,676,3,4,68,2,43,5,56,7,23};
        sorting.quickSortPointer(array);
        System.out.println(Arrays.toString(array));

    }



    public static void main4(String[] args) {
        int[] array = {12,23,4,676,3,4,68,2,43,5,56,7,8,23};
        Sorting sorting = new Sorting();
        sorting.heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void main3(String[] args) {
        int[] array = {12,23,4,676,3,4,68,2,43,5,56,7,8,23};
        Sorting sorting = new Sorting();
        sorting.selectSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void main2(String[] args) {
        int[] array = {12,23,4,676,3,4,68,2,43,5,56,7,8,23};
        Sorting sorting = new Sorting();
        sorting.shellSort(array);
        System.out.println(Arrays.toString(array));

        /**
         * 测试希尔排序和插入排序的时间差
         */
        //有序的数据
        int[] arr1 = new int[10_0000];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = i;
        }

        //无序的数据
        Random random = new Random();
        int[] arr2 = new int[100_0000];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = random.nextInt(100_0000);
        }

        //有序的数据  希尔排序：10   插入排序：2
        long startTime = System.currentTimeMillis();
        sorting.shellSort(arr1);
        long endTime = System.currentTimeMillis();
        System.out.println("希尔排序：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        sorting.insertSort(arr1);
        endTime = System.currentTimeMillis();
        System.out.println("插入排序：" + (endTime - startTime));



        //无序的数据    希尔排序：17      插入排序：1
        startTime = System.currentTimeMillis();
        sorting.shellSort(arr2);
        endTime = System.currentTimeMillis();
        System.out.println("希尔排序：" + (endTime - startTime));



        int[] arr3 = new int[100_0000];
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = random.nextInt(100_0000);
        }
        startTime = System.currentTimeMillis();
        sorting.insertSort(arr3);
        endTime = System.currentTimeMillis();
        System.out.println("插入排序：" + (endTime - startTime));


    }

    public static void main1(String[] args) {
        int[] array = {12,23,4,676,3,4,68,2,43,5,56,7,8,23};
        Sorting sorting = new Sorting();
        sorting.insertSort(array);
        System.out.println(Arrays.toString(array));
    }


}
