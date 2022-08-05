package thetitle;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-06
 * Time: 0:45
 */
public class MyStack {
    /**
     * 队列实现栈
     * 易知应该使用两个队列
     *
     * void push(int x) 将元素 x 压入栈顶。
     * int pop() 移除并返回栈顶元素。
     * int top() 返回栈顶元素。
     * boolean empty() 如果栈是空的，返回 true ；否则，返回 false
     */

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;


    public MyStack() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }


    public void push(int x) {
        if (this.queue1.isEmpty()){
            this.queue2.offer(x);
        }else {
            this.queue1.offer(x);
        }

    }

    public int pop() {
        int tmp = -1;
        if (this.queue1.isEmpty() && this.queue2.isEmpty()){
            return -1;
        }else if (this.queue1.isEmpty()){
            int usedSize = this.queue2.size()-1;
            for (int i = 0; i < usedSize; i++) {
                tmp = this.queue2.poll();
                this.queue1.offer(tmp);
            }
            return this.queue2.poll();
        }else {
            int usedSize = this.queue1.size()-1;
            for (int i = 0; i < usedSize; i++) {
                tmp = this.queue1.poll();
                this.queue1.offer(tmp);
            }
            return this.queue1.poll();
        }
    }

    public int top() {
        int tmp = -1;
        if (this.queue1.isEmpty() && this.queue2.isEmpty()){
            return -1;
        }else if (this.queue1.isEmpty()){
            int usedSize = this.queue2.size();
            for (int i = 0; i < usedSize; i++) {
                tmp = this.queue2.poll();
                this.queue1.offer(tmp);
            }
            return tmp;

        }else {
            int usedSize = this.queue1.size();
            for (int i = 0; i < usedSize; i++) {
                tmp = this.queue1.poll();
                this.queue1.offer(tmp);
            }
            return tmp;
        }
    }


    public boolean empty() {
        if (this.queue1.isEmpty() && this.queue2.isEmpty())
            return true;
        return false;
    }
}
