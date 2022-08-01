package thelist;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-01
 * Time: 1:17
 */


public class TheListOne {



    static class ListNode{
        public int value;//数值域

        public ListNode next;//存储下一个节点的地址

        public ListNode(int value) {
            this.value = value;
        }
    }

    public ListNode head;//代表单链表的头节点的引用


    public ListNode buildLinkedList(){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        this.head = listNode1;
        return head;
    }

    public void diaplay(){
        ListNode current = this.head;
        while(current !=null){
            System.out.print(current.value + " ");
            current = current.next;
        }
    }



    //头插法
    public void addFirst(int data){

    }
    //尾插法
    public void addLast(int data){

    }
    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data){

    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){

    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){

    }
    //删除所有值为key的节点
    public void removeAllKey(int key){

    }
    //得到单链表的长度
    public int size(){

    }

    public void clear(){

    }












}
