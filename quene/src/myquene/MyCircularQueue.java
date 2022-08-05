package myquene;




class MyCircularQueue {

    private int[] elem;
    public int front;
    public int rear;


    /**
     * 构造方法，K表示数组的大小
     * @param k
     */
    public MyCircularQueue(int k) {
        this.elem = new int[k+1];
    }

    /**
     * 入队
     * 判断队列是否已满
     * 未满情况下则队列rear位置插入，rear移动
     * @param value
     * @return
     */
    public boolean enQueue(int value) {
        if (this.isFull()){
            //throw new MyListListIsFullException("队列入队时队列已满异常！");
            return false;
        }
        this.elem[rear] = value;
        //关注这个位置
        this.rear = (this.rear+1) % this.elem.length;
        return true;
    }

    /**
     * 出队
     * @return
     */
    public boolean deQueue() {
        if (this.isFull()){
           //throw new MyLinkedListEmptyException("出队时队列为空异常！");
            return false;
        }
        this.elem[front] = 0;
        this.front = (this.front+1) % this.elem.length;
        return true;
    }

    /**
     * 得到对头元素
     * @return
     */
    public int Front() {
        if (this.isFull())
            return -1;
        return this.elem[this.front];
    }

    /**
     * 得到队尾元素
     * @return
     */
    public int Rear() {
        if (this.isFull())
            return -1;
        return this.elem[(this.rear+this.elem.length-1) % this.elem.length];
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return this.front == this.rear;
    }

    /**
     * 判断队列是否已满
     * @return
     */
    public boolean isFull() {
        if ((this.rear + 1) % this.elem.length == this.front)
            return true;
        return false;
    }
}