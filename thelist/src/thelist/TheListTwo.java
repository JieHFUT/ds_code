package thelist;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-01
 * Time: 12:11
 */
public class TheListTwo {
    public static void main(String[] args) {

        TheListOne theListOne = new TheListOne();
        theListOne.buildLinkedList();
        theListOne.diaplay();

        System.out.println(theListOne.size());

        boolean flg = theListOne.contains(4);
        System.out.println(flg);

        theListOne.addFirst(99);
        theListOne.diaplay();
        theListOne.addFirst(33);
        theListOne.diaplay();
        theListOne.addFirst(33);
        theListOne.diaplay();
        theListOne.addFirst(99);
        theListOne.diaplay();
        theListOne.addFirst(33);
        theListOne.diaplay();
        theListOne.addLast(199);
        theListOne.diaplay();


       try{
           theListOne.addIndex(3,999);
           theListOne.diaplay();
       }catch (TheListAddIndexOutOfException E){
           System.out.println(E);
           System.out.println("针对添加时位置异常的处理方法！");
       }finally {
           System.out.println("这是一定会执行的语句！");
       }



       try {
           theListOne.remove(1199);
           theListOne.diaplay();
       }catch (TheListIsEmptyException E){
           System.out.println(E);
           System.out.println("针对删除时链表空异常的处理方法！");
       }catch (TheListWithoutTheKeyException E){
           System.out.println(E);
           System.out.println("针对链表无删除数据异常的处理方法！");
       } finally {
           System.out.println("这是一定会执行的语句！");
       }


        System.out.println("==================================");
        theListOne.diaplay();
        theListOne.removeAllKey(33);
        theListOne.diaplay();



        //清空
        theListOne.clear();
        theListOne.diaplay();

    }
}
