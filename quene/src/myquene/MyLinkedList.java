package myquene;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-05
 * Time: 21:57
 */
public class MyLinkedList {


    class Code{
        public int value;
        public Code next;

        public Code(int value){
            this.value = value;
        }

    }

    public Code head;
    public Code last;
    public int usedSize;


    /**
     * 入队
     * @param data
     */
    public void offer(int data){
        Code code = new Code(data);
        if (this.head == null){
            this.head = code;
            this.last = code;
        }else {
            this.last.next = code;
            this.last = code;
        }
    }

    /**
     * 出队
     * @return
     */
    public int pop(){
        if (this.head == null)
            throw new MyLinkedListEmptyException("出队时队列为空异常！");
        int val = this.head.value;
        if (this.usedSize == 1)
            this.last = null;
        this.head = this.head.next;
        return val;
    }


    /**
     * 显示队首但是不删除
     * @return
     */
    public int peer(){
        if (this.head == null)
            throw new MyLinkedListEmptyException("出队时队列为空异常！");
        return this.head.value;
    }


    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return this.usedSize == 0;
    }


    /**
     * 队列长度
     * @return
     */
    public int size(){
        return usedSize;
    }


}
