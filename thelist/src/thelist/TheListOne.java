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
        System.out.println();
    }



    //头插法
    public void addFirst(int data){
        ListNode listNode = new ListNode(data);

        listNode.next = this.head;
        this.head = listNode;
    }

    //尾插法
    public void addLast(int data){
        ListNode listNode = new ListNode(data);
        ListNode current = this.head;
        if (current == null){
            current = listNode;
            this.head = current;
            return;
        }
        while(current.next != null){
            current = current.next;
        }
        current.next = listNode;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data) throws TheListAddIndexOutOfException{

        while(index < 0 || index > this.size()){
            throw new TheListAddIndexOutOfException("任意位置插入时，位置不合法！");
        }

        ListNode listNode = new ListNode(data);
        int count = 0;
        ListNode current = this.head;
        if (index == 0){
            this.addFirst(data);
            return;
        }
        if (index == this.size()){
            this.addLast(data);
            return;
        }
        while(current != null){
            count++;
            if (count == index-1){
                ListNode listNode1 = current;
                listNode.next = listNode1.next;
                current.next = listNode;
                return;
            }
            current = current.next;
        }
        return;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode current = this.head;
        while (current != null){
            if (current.value == key){
                return true;
            }
            current = current.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){

        if (this.head == null){
            throw new TheListIsEmptyException("链表为空！无法删除！");
        }
        if (this.head.value == key){
            this.head = this.head.next;
        }
        ListNode current = this.head;
        while(current.next != null){
            if (current.next.value == key){
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
        throw new TheListWithoutTheKeyException("链表中没有要删除的值！");
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        if (this.head == null) {
            return;
        }
        ListNode current = this.head.next;
        ListNode preL = this.head;
        while (current != null){
            if (current.value == key){
                preL.next = current.next;
                current = current.next;
            }else {
                preL = current;
                current = current.next;
            }
        }
        if(this.head.value == key){
            this.head = this.head.next;
        }
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

    public void clear(){
        ListNode current = this.head;
       while(current != null){
           current.next = null;
           current = this.head.next;
           this.head = current;
       }
    }



















    /**
     * 接下来的这些题目时单链表的在线OJ题，在TheListThree文件调用
     * @param
     * @return
     */
    //反转一个单链表
    public void reverse(){
        if (this.head == null){
            throw new TheListIsEmptyException("反转单链表时，单链表为空异常！");
        }
        ListNode current = this.head;
        ListNode curNext = current.next;
        ListNode curPre = current;
        while(curNext != null){
            current = curNext;
            curNext = current.next;
            current.next = curPre;
            curPre = current;
        }
        this.head.next = null;
        this.head = current;
        return;
    }

    //给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
    //如果有两个中间结点，则返回第二个中间结点
    public ListNode returnMiddle(){
        ListNode slow = this.head;
        ListNode fast = this.head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //输入一个链表，输出该链表中倒数第k个结点
    public ListNode soutLastNumK(int k){
        if (k < 0){
            throw new TheListAddIndexOutOfException("输出该链表倒数第k个结点时输入不合法！");
        }
        ListNode slow = this.head;
        ListNode fast = this.head;
        while(k - 1 > 0){
            if (fast != null){
                fast = fast.next;
            }else {
                throw new TheListAddIndexOutOfException("输出该链表倒数第k个结点时输入不合法！");
            }
            k--;
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    //将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
    public TheListOne returnNew(TheListOne theListOne2){
        ListNode current1 = this.head;
        ListNode current2 = theListOne2.head;
        TheListOne theListOne = new TheListOne();
        while (current1 != null && current2 != null){
            if (current1.value <= current2.value){
                theListOne.addLast(current1.value);
                current1 = current1.next;
            }else {
                theListOne.addLast(current2.value);
                current2 = current2.next;
            }
        }
       while(current1 != null){
           theListOne.addLast(current1.value);
           current1 = current1.next;
       }
       while(current2 != null){
            theListOne.addLast(current2.value);
            current2 = current2.next;
        }
       return theListOne;
    }

    //编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
    public void segmentation(int x){
        ListNode current = this.head;
        TheListOne preList = new TheListOne();
        TheListOne latterList = new TheListOne();
        while(current != null){
            if (current.value <= x){
                preList.addLast(current.value);
                current = current.next;
            }else {
                latterList.addLast(current.value);
                current = current.next;
            }
        }
        TheListOne theListOne = preList.returnNew(latterList);
        this.head = theListOne.head;
    }


    /**
     * 关于判断链表是不是回文结构，时间复杂度O(n) 空间复杂度O(1)
     * @return
     */
//    public TheListOne create(){
//        ListNode current = this.head;
//        TheListOne theListOne = new TheListOne();
//        while(current != null){
//            theListOne.addLast(current.value);
//            current = current.next;
//        }
//        return theListOne;
//    }
//    //链表的回文结构
//    public boolean palindrome(){
//        if (this.head == null){
//            throw new TheListIsEmptyException("判断回文结构时，单链表为空异常！");
//        }
//        TheListOne theListOne = this.create();
//        TheListOne theListOne1 = this.create();
//        theListOne.reverse();
//        while(theListOne.head != null){
//            if (theListOne.head.value != theListOne1.head.value){
//                return false;
//            }
//            theListOne1.head = theListOne1.head.next;
//            theListOne.head  = theListOne.head.next;
//        }
//        return true;
//    }


    //链表的回文结构
    public boolean palindrome() {
        if (this.head == null){
            throw new TheListIsEmptyException("判断回文结构中，链表为空产生异常！");
        }
        ListNode slow = this.head;
        ListNode fast = this.head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode middle = slow;
        ListNode slowPre = slow;
        ListNode slowNext = slow.next;
        while(slowNext != null) {
            slow = slowNext;
            slowNext = slow.next;
            slow.next = slowPre;
            slowPre = slow;
        }
        middle.next = null;
        while(slow != middle){
            if (slow.value != this.head.value){
                return false;
            }
            slow = slow.next;
            this.head = this.head.next;
        }
        if (this.head.next != null){
            if (this.head.value != this.head.next.value){
                return false;
            }
        }
        return true;
    }



//    //输入两个链表，找出它们的第一个公共结点
//    public ListNode theCommon(TheListOne theListOne1, TheListOne theListOne2){
//
//    }
//    //给定一个链表，判断链表中是否有环
//    public boolean judgeHasRing(TheListOne theListOne){
//
//    }
//    //给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 NULL
//    public ListNode returnTheRingFirstListcode(TheListOne theListOne){
//
//    }
}
