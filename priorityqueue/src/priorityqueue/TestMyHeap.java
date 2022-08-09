package priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-09
 * Time: 20:31
 */
public class TestMyHeap {

    public static void main1(String[] args) {

        int[] array = { 27,15,19,18,28,34,65,49,25,37 };
        MyHeap myHeap = new MyHeap();


        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>(
                new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 02 - 01;
            }
        });

        //只有Student实现了Comparator接口才能进行比较
        PriorityQueue<Student> priorityQueue2 = new PriorityQueue<>();


        /**
         * top K问题   n*logn
         */
        PriorityQueue<Integer> priorityQueue3 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int[] arr1 = {2,5,76,34,55,6,98,79,2,67,88};
        //创建大根堆  n*logn
        for (int i = 0; i < arr1.length; i++) {
            priorityQueue3.add(arr1[i]);
        }
        //取前三个最大的  n*logn
        for (int i = 0; i < 3; i++) {
            System.out.print(priorityQueue3.poll() + " ");
        }
        System.out.println();


        /**
         * 优化
         * 1. 用数据集合中前K个元素来建堆
         * 前k个最大的元素，则建小堆
         * 前k个最小的元素，则建大堆
         * 2. 用剩余的 N-K个元素依次与堆顶元素来比较，不满足则替换堆顶元素
         * nlog2K
         */

        PriorityQueue<Integer> priorityQueue4 = new PriorityQueue<>();

        int[] arr2 = {2,5,76,34,55,6,98,79,2,67,88};
        //求取这个数组里面的前3个最大的元素
        int k = 3;
        for (int i = 0; i < arr2.length; i++) {
            if (priorityQueue4.size() < k){
                priorityQueue4.offer(arr2[i]);
            }else {
                if (arr2[i] < priorityQueue4.peek()){
                    priorityQueue4.poll();
                    priorityQueue4.offer(arr2[i]);
                }
            }
        }

        int[] arr3 = new int[k];
        for (int i = 0; i < k; i++) {
            arr3[i] = priorityQueue4.poll();
        }

    }


    public static void main(String[] args) {
        /**
         * 堆排序的问题
         * 1. 建堆
         * 升序：建大堆
         * 降序：建小堆
         * 2. 利用堆删除思想来进行排序
         */

        int[] array = {2,5,76,34,55,6,98,79,2,67,88};
        //从小到大进行排序
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < array.length; i++) {
            priorityQueue.offer(array[i]);
        }




    }
}
