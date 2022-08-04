package mylinkedlist;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-04
 * Time: 22:06
 */
public class MyLinkedList {
    static class ListNode{
        public int value;
        public ListNode prel;
        public ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }
    public ListNode head;
    public ListNode last;







    //头插法
    public void addFirst(int data){
        ListNode listNode = new ListNode(data);
        if (this.head == null){
            this.head = listNode;
            this.last = listNode;
            return;
        }
        this.head.prel = listNode;
        listNode.next = this.head;
        this.head = listNode;
    }
    //尾插法
    public void addLast(int data){
        ListNode listNode = new ListNode(data);
        if (this.head == null){
            this.head = listNode;
            this.last = listNode;
            return;
        }
        this.last.next = listNode;
        listNode.prel = this.last;
        this.last = listNode;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        ListNode listNode = new ListNode(data);
        if (index < 0 || index > this.size())
            throw new MyLInkedListInputException("任意位置添加数据时输入位置有误！");
        ListNode current = this.head;
        if (this.head == null){
            this.head = listNode;
            this.last = listNode;
            return;
        }
        while (index > 0){
            current = current.next;
            index--;
        }
        if (current == this.head){
            this.head.prel = listNode;
            listNode.next = this.head;
            this.head = listNode;
            return;
        }
        if (current == null){
            this.last.next = listNode;
            listNode.prel = this.last;
            this.last = listNode;
            return;
        }

        current.prel.next = listNode;
        listNode.prel = current.prel;
        listNode.next = current;
        current.prel = listNode;
        return;
    }
    //查找是否包含关键字key是否在链表当中
    public boolean contains(int key){
        if (this.head == null)
            throw new MyLindedListEmptyException("查找关键字时链表为空异常！");
        ListNode cuurrent = this.head;
        while(cuurrent != null){
            if (cuurrent.value == key)
                return true;
            cuurrent = cuurrent.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        if (this.head == null)
            throw new MyLindedListEmptyException("删除关键字key时链表为空异常！");

        ListNode current = this.head;
        while(current != null){
            if (current.value == key){
                if (current == this.head){
                    this.head.next.prel = null;
                    this.head = this.head.next;
                    return;
                } else if (current == this.last) {
                    this.last.prel.next = null;
                    this.last = this.last.prel;
                    return;
                }else {
                    current.prel.next = current.next;
                    current.next.prel = current.prel;
                    return;
                }
            }
            current = current.next;
        }


    }
    //删除所有值为key的节点
    public void removeAllKey(int key){

        if (this.head == null)
            throw new MyLindedListEmptyException("删除关键字key时链表为空异常！");

        ListNode current = this.head;
        while(current != null){
            if (current.value == key){
                if (current == this.head){
                    this.head.next.prel = null;
                    this.head = this.head.next;
                } else if (current == this.last) {
                    this.last.prel.next = null;
                    this.last = this.last.prel;
                }else {
                    current.prel.next = current.next;
                    current.next.prel = current.prel;
                }
            }
            current = current.next;
        }
        return;

    }
    //得到单链表的长度
    public int size(){
        int count = 0;
        ListNode current = this.head;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }
    public void display(){
        ListNode cuurent = this.head;
        while(cuurent != null){
            System.out.print(cuurent.value + " ");
            cuurent = cuurent.next;
        }
        System.out.println();
    }
    /*public void clear(){
        if (this.size() > 2){
            ListNode current = this.head.next.next;
            while(current != null){
                current.prel.next = null;
                current.prel.prel = null;
                current = current.next;
            }
        }
        if (this.size() > 1){
            this.head.next = null;
            this.last.prel = null;
        }
        this.head = null;
        this.last = null;

    }*/

    public void clear(){
        ListNode current = this.head;
        while(current != null){
            ListNode curNext = current.next;
            //current.value = null;
            current.prel = null;
            current.next = null;
            current = curNext;
        }
        this.head = null;
        this.last = null;
    }

}
