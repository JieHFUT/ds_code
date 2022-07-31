package officiallist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-07-30
 * Time: 18:50
 */








public class OfficialList {


    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(0,11);
        arrayList1.add(1,22);
        arrayList1.add(2,33);
        arrayList1.add(3,55);
        System.out.println(arrayList1);//[11, 22, 33, 55]

        //sublist函数实在其本身上截取一段，没有创建一个新的对象，注意返回值是List<E>
        List<Integer> list = arrayList1.subList(1,3);
        System.out.println(list);
        System.out.println("====================================");


        //将list的1下标改成99
        list.set(1,99);
        System.out.println("list：" + list);//[22, 99]
        System.out.println("arrayList1：" + arrayList1);//[11, 22, 99, 55]


        System.out.println("====================================");


        /**
         * 输出方法
         */
        System.out.println(arrayList1);
        for (int i = 0; i < arrayList1.size(); i++) {
            System.out.print(arrayList1.get(i)+" ");
        }
        System.out.println();
        for (Integer x:
             arrayList1) {
            System.out.print(x + " ");
        }
        System.out.println();


        System.out.println("=====================================");

        //使用迭代器打印
        Iterator<Integer> it = arrayList1.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();




        Iterator<Integer> it2 = arrayList1.listIterator();
        while(it2.hasNext()){
            System.out.print(it2.next() + " ");
        }
        System.out.println();
        
    }
    public static void main3(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(0,1);
        arrayList1.add(1,2);
        arrayList1.add(2,44);
        arrayList1.add(3,99);
        System.out.println(arrayList1);
        //删除(依据下标)
        arrayList1.remove(0);
        System.out.println(arrayList1);

        //删除(依据数值)
        //arrayList1.remove(4);//IndexOutOfBoundsException
        arrayList1.remove(new Integer(44));
        System.out.println(arrayList1);//[2, 99]


        //从后往前找某一个数值，返回下标
        int index = arrayList1.lastIndexOf(new Integer(99));
        System.out.println(index);//1



    }
    public static void main2(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(0,1);
        System.out.println(arrayList1);

        ArrayList<Integer> arrayList2 = new ArrayList<>();
        //尾插C中的元素
        arrayList2.addAll(arrayList1);
        arrayList2.add(1,2);
        System.out.println(arrayList2);

    }
    public static void main1(String[] args) {

        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(1);
        arrayList1.add(2);
        arrayList1.add(3);
        arrayList1.add(4);
        arrayList1.add(5);
        arrayList1.add(6);
        System.out.println(arrayList1);//[1, 2, 3, 4, 5, 6]
        System.out.println(arrayList1.size());
        System.out.println(arrayList1.get(2));

        //构造方法！使用其他的集合，来构造当前的List====就是添加同类型的一个整体
        ArrayList<Integer> arrayList2 = new ArrayList<>(arrayList1);
        arrayList2.add(11);
        arrayList2.add(22);
        System.out.println(arrayList2);//[1, 2, 3, 4, 5, 6, 11, 22]

        //指定容量的构造方法
        ArrayList arrayList3 = new ArrayList(15);

    }

}
