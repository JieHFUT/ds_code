package quene;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-05
 * Time: 19:14
 */
public class TheQuene {

    /**
     * 队列和栈相反，是先进先出的一种模式
     * @param args
     */
    public static void main(String[] args) {

        /**
         * boolean offer(E e) 入队列
         * E poll() 出队列
         * peek() 获取队头元素但是不删除
         * int size() 获取队列中有效元素个数
         * boolean isEmpty() 检测队列是否为空
         */
        Queue<Integer> integerQueue = new LinkedList<>();
        integerQueue.offer(11);
        integerQueue.offer(22);
        integerQueue.offer(33);
        integerQueue.offer(44);
        System.out.println(integerQueue);//[11, 22, 33, 44]

        //出队列
        Integer val = integerQueue.poll();
        System.out.println(val);

        System.out.println(integerQueue.peek());
    }


}
