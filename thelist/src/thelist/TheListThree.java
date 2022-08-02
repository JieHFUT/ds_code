package thelist;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-02
 * Time: 18:21
 */
public class TheListThree {

    public static void main(String[] args) {

        TheListOne theListOne = new TheListOne();
        theListOne.addLast(1);
        theListOne.addLast(2);
        theListOne.addLast(3);
        theListOne.addLast(4);
        theListOne.addLast(5);
        theListOne.addLast(6);
        theListOne.addLast(7);
        theListOne.addLast(8);
        theListOne.diaplay();


        //反转单链表
        try{
            theListOne.reverse();
            theListOne.diaplay();
        }catch (TheListIsEmptyException E){
            System.out.println(E);
            System.out.println("这是反转单链表时，单链表为空的实际处理！");
        }















    }


}
