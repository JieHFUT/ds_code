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
        theListOne.addLast(18);
        theListOne.addLast(24);
        theListOne.addLast(34);
        theListOne.addLast(41);
        theListOne.addLast(54);
        theListOne.addLast(67);
        theListOne.addLast(75);
        theListOne.addLast(82);
        theListOne.diaplay();


        //反转单链表
        try{
            theListOne.reverse();
            theListOne.diaplay();
        }catch (TheListIsEmptyException E){
            System.out.println(E);
            System.out.println("这是反转单链表时，单链表为空的实际处理！");
        }


        TheListOne.ListNode returnMiddle = theListOne.returnMiddle();
        theListOne.diaplay();
        System.out.println(returnMiddle.value);


        TheListOne.ListNode soutLastNumK = theListOne.soutLastNumK(4);
        System.out.println(soutLastNumK.value);





        theListOne.reverse();
        System.out.println("================合并链表并且排序==================");
        TheListOne theListOne1 = new TheListOne();
        theListOne1.addLast(32);
        theListOne1.addLast(44);
        theListOne1.addLast(47);
        theListOne1.addLast(49);
        theListOne1.addLast(51);
        theListOne1.addLast(55);
        theListOne1.addLast(99);
        theListOne.diaplay();
        theListOne1.diaplay();

        TheListOne theListOne2 = theListOne.returnNew(theListOne1);
        theListOne2.diaplay();


        System.out.println("=================切割链表=================");

        TheListOne theListOne4 = new TheListOne();
        theListOne4.addLast(47);
        theListOne4.addLast(44);
        theListOne4.addLast(67);
        theListOne4.addLast(49);
        theListOne4.addLast(89);
        theListOne4.addLast(55);
        theListOne4.addLast(23);
        theListOne4.diaplay();
        theListOne4.segmentation(56);
        theListOne4.diaplay();


        System.out.println("============链表是否是回文结构==============");
        TheListOne theListOne3 = new TheListOne();
        theListOne3.addLast(32);
        theListOne3.addLast(44);
        theListOne3.addLast(41);
        theListOne3.addLast(47);
        theListOne3.addLast(44);
        theListOne3.addLast(32);
        try {
            boolean flg = theListOne3.palindrome();
            System.out.println(flg);
        }catch (TheListIsEmptyException E){
            System.out.println(E);
        }












    }


}
