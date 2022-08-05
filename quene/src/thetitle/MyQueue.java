package thetitle;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-06
 * Time: 0:53
 */
public class MyQueue {
    /**
     * 栈实现队列
     * 易知应该使用两个栈
     *
     * void push(int x) 将元素 x 推到队列的末尾
     * int pop() 从队列的开头移除并返回元素
     * int peek() 返回队列开头的元素
     * boolean empty() 如果队列为空，返回 true ；否则，返回 false
     *
     */

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void push(int x) {
        if (this.stack1.isEmpty() && this.stack2.isEmpty()){
            this.stack1.push(x);
            this.stack2.push(this.stack1.pop());
        }else {
            int len = this.stack2.size();
            for (int i = 0; i < len; i++) {
                this.stack1.push(this.stack2.pop());
            }
            this.stack2.push(x);
            for (int i = 0; i < len; i++) {
                this.stack2.push(this.stack1.pop());
            }
        }
    }

    public int pop() {
        return this.stack2.pop();
    }

    public int peek() {
        return this.stack2.peek();
    }

    public boolean empty() {
        return this.stack2.empty();
    }
}
