import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-05
 * Time: 1:13
 */
public class MyStack<E> {

    public E[] elem;
    public int usedSize;

    public MyStack() {
        this.elem = (E[])new Object[2];
    }

    /**
     * 入栈
     * @param val
     */
    public void push(E val) {
        if(isFull()) {
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }
        this.elem[this.usedSize++] = val;
    }

    /**
     * 判断当前栈是否为满
     * @return
     */
    public boolean isFull() {
        return usedSize == elem.length;
    }

    /**
     * 出栈
     * @return
     */
    public E pop() {
        if(empty()) {
            throw new RuntimeException("栈为空！");
        }
        E ret = elem[usedSize-1];
        elem[usedSize-1] = null; //注意 栈内存当中 存储引用类型的时候 要把它置为空
        usedSize--;
        return ret;
    }

    public boolean empty() {
        return usedSize==0;
    }

    /**
     * 获取栈顶元素 不删除！
     * @return
     */
    public E peek() {
        if(empty()) {
            throw new RuntimeException("栈为空！");
        }
        return elem[usedSize-1];
    }

    /**
     * 获取大小
     * @return
     */
    public int getUsedSize() {
        return usedSize;
    }


}
