package priorityqueue;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-08
 * Time: 15:34
 */

public class MyHeap {


    public int[] elem;
    public int usedSize;

    public MyHeap(){
        this.elem = new int[10];
    }



    public void createHeap(int[] array){
        for (int i = 0; i < this.elem.length; i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }
        for (int p = (usedSize-1-1)/2; p >= 0 ; p--) {
            shiftDown(p,usedSize);
        }
    }


    /**
     *
     * @param root 是每棵子树的根节点的下标
     * @param len  是每棵子树调整结束的结束条件
     * 向下调整的时间复杂度：O(logn)
     */
    private void shiftDown(int root,int len) {
        int parent = root;
        int child = 2*parent+1;
        //进入这个循环，说明一定至少有一个孩子
        while (child < len) {
            //如果有孩子，找到左右孩子的最大值
            if(child+1 < len && elem[child] < elem[child+1]) {
                child++;
            }
            //child下标一定保存的是左右孩子最大值的下标
            //接下来，孩子的最大值和根节点去比较大小
            if(elem[child] > elem[parent]) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                parent = child;//开始更新下标，继续看下面的子树是不是大根堆
                child = 2*parent+1;
            }else {
                break;//此时说明已经是大根堆，不需要进行再次调整了
            }
        }
    }


    /**
     * 入队：仍然要保持是大根堆
     * @param val
     */
    public void push(int val) {
        if(isFull()) {
            elem = Arrays.copyOf(elem,2*elem.length);
        }
        //1、放到最后的位置
        elem[usedSize] = val;
        //2、进行向上调整
        shiftUp(usedSize);
        //3、有效数据+1
        usedSize++;
    }

    private void shiftUp(int child) {
        int parent = (child-1) / 2;
        while (child > 0) {
            if(elem[child] > elem[parent]) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                child = parent;
                parent = (child-1)/2;
            }else {
                break;
            }
        }
    }

    public boolean isFull() {
        return usedSize == elem.length;
    }

    /**
     * 出队,每次删除的都是优先级高的元素
     * 仍然要保持是大根堆
     */
    public void pollHeap() {
        if(isEmpty()) {
            System.out.println("优先级队列为空！");
            return;
        }
        int tmp = elem[0];
        elem[0] = elem[usedSize-1];
        elem[usedSize-1] = tmp;
        usedSize--;//9
        shiftDown(0,usedSize);
    }

    public boolean isEmpty() {
        return usedSize == 0;
    }

    /**
     * 获取堆顶元素
     * @return
     */
    public int peekHeap() {
        if(isEmpty()) {
            System.out.println("优先级队列为空！");
            return -1;
        }
        return elem[0];
    }

    //O(n*logn)
    public void heapSort() {
        int end = usedSize-1;
        while (end > 0) {
            int tmp = elem[0];
            elem[0] = elem[end];
            elem[end] = tmp;
            shiftDown(0,end);
            end--;
        }
    }


}
