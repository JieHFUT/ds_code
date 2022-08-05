package thetitle;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-06
 * Time: 0:54
 */
public class MinStack {


    /**
     * MinStack() 初始化堆栈对象。
     * void push(int val) 将元素val推入堆栈。
     * void pop() 删除堆栈顶部的元素。
     * int top() 获取堆栈顶部的元素。
     * int getMin() 获取堆栈中的最小元素。
     */
    private Stack<Integer> integerStack1;
    private Stack<Integer> integerStack2;


    public MinStack() {
        this.integerStack1 = new Stack<>();
        this.integerStack2 = new Stack<>();
    }


    public void push(int val) {
        this.integerStack1.push(val);
        if (integerStack2.empty()){
            this.integerStack2.push(val);
        }else {
            if (val <= this.integerStack2.peek())
                this.integerStack2.push(val);
        }
    }

    public void pop() {
        if (this.integerStack1.peek() == this.integerStack2.peek())
            this.integerStack2.pop();
        this.integerStack1.pop();
    }

    public int top() {
        return this.integerStack1.peek();
    }

    public int getMin() {
        return this.integerStack2.peek();
    }
}
