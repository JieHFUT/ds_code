package mylinkedlist;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-04
 * Time: 22:07
 */
public class TestMyLinkedList {


    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(1);
        myLinkedList.addLast(2);
        myLinkedList.addLast(3);
        myLinkedList.addFirst(4);
        myLinkedList.addFirst(5);

        System.out.println(myLinkedList.size());
        myLinkedList.display();


        System.out.println("========任意位置插入===========");
        myLinkedList.addIndex(0,11);
        myLinkedList.display();
        myLinkedList.addIndex(4,22);
        myLinkedList.display();
        myLinkedList.addIndex(7,33);
        myLinkedList.display();


        System.out.println(myLinkedList.contains(11));
        System.out.println(myLinkedList.contains(99));


        System.out.println("=========删除第一个出现的key===============");
        myLinkedList.display();
        myLinkedList.remove(22);
        myLinkedList.display();
        myLinkedList.remove(11);
        myLinkedList.display();
        myLinkedList.remove(33);
        myLinkedList.display();




        System.out.println("=========删除所有出现的key===============");
        MyLinkedList myLinkedList1 = new MyLinkedList();
        myLinkedList1.addLast(1);
        myLinkedList1.addLast(2);
        myLinkedList1.addLast(1);
        myLinkedList1.addLast(1);
        myLinkedList1.addLast(3);
        myLinkedList1.addLast(4);
        myLinkedList1.addLast(5);
        myLinkedList1.addLast(1);
        myLinkedList1.addLast(1);
        myLinkedList1.display();
        myLinkedList1.removeAllKey(1);
        myLinkedList1.display();



    }
}
