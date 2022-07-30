package sqlist;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-07-30
 * Time: 14:29
 */
public class TestMyArrayList {

    public static void main(String[] args) {
        MyArrayList myArrayList1 = new MyArrayList();
        myArrayList1.add(1);
        myArrayList1.add(2);
        myArrayList1.add(3);
        myArrayList1.add(4);
        myArrayList1.add(5);
        myArrayList1.display();
        System.out.println("================================================");

        MyArrayList myArrayList2 = new MyArrayList();
        myArrayList2.add(0,1);
        myArrayList2.add(1,2);
        myArrayList2.add(2,3);
        myArrayList2.add(3,4);
        myArrayList2.display();

        myArrayList2.add(0,111);//111 1 2 3 4
        myArrayList2.display();
        System.out.println("================================================");

        MyArrayList myArrayList3 = new MyArrayList();
        try {
            int num1 = myArrayList3.get(1);
            System.out.println(num1);
        }catch (MyArrayIsEmptyExption E){
            E.getStackTrace();
            System.out.println(E);
        }catch (MyArrayListIndexIllegal E){
            System.out.println(E);
        }
        myArrayList3.add(1);
        myArrayList3.add(2);
        myArrayList3.add(3);
        myArrayList3.add(4);
        myArrayList3.add(5);
        try {
            int num2 = myArrayList3.get(1);
            System.out.println(num2);
        }catch (MyArrayIsEmptyExption E){
            E.getStackTrace();
            System.out.println("空数组异常！");
        }
        System.out.println("================================================");

        MyArrayList myArrayList4 = new MyArrayList();
        try {
            myArrayList4.set(1,2);
            System.out.println(myArrayList4.elem[1]);
        }catch (MyArrayListIndexIllegal E){
            System.out.println(E);
        }catch (MyArrayIsEmptyExption E){
            System.out.println(E);
        }
        myArrayList4.add(1);
        myArrayList4.add(2);
        myArrayList4.add(3);
        myArrayList4.add(4);
        myArrayList4.add(5);
        try {
            myArrayList4.set(4,22);
            System.out.println(myArrayList4.elem[4]);
        }catch (MyArrayListIndexIllegal E) {
            System.out.println(E);
        }
        System.out.println("================================================");


        MyArrayList myArrayList5 = new MyArrayList();
        myArrayList5.add(1);
        myArrayList5.add(2);
        myArrayList5.add(3);
        myArrayList5.add(4);
        myArrayList5.add(5);
        try{
            myArrayList5.remove(7);
        }catch (MyArrayListInputExption E){
            System.out.println(E);
        }
        myArrayList5.display();






    }
}
