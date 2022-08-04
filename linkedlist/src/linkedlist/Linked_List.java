package linkedlist;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-05
 * Time: 0:22
 */
public class Linked_List {

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(1);//默认是尾插法
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        System.out.println(linkedList);
        for (int x:
             linkedList) {
            System.out.print(x + " ");
        }
        System.out.println();


        //迭代器打印
        Iterator<Integer> it = linkedList.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();



        ListIterator<Integer> listIterator1 = linkedList.listIterator();
        while(listIterator1.hasNext()){
            System.out.print(listIterator1.next() + " ");
        }
        System.out.println();


        ListIterator<Integer> listIterator2 = linkedList.listIterator(6);
        while(listIterator2.hasPrevious()){
            System.out.print(listIterator2.previous() + " ");
        }
        System.out.println();









    }


}
