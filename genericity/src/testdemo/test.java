package testdemo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-07-31
 * Time: 18:48
 */


public class test {
    public static void main(String[] args) {
        Integer[] integers = new Integer[5];

        System.out.println(integers[0]);//null
        System.out.println(integers[1]);//null
        System.out.println(integers[2]);//null
        System.out.println(integers[3]);//null
        System.out.println(integers[4]);//null
        System.out.println(integers);   //[Ljava.lang.Integer;@1b6d3586

        integers[0] = new Integer(11);
        integers[1] = new Integer(12);
        integers[2] = new Integer(13);
        integers[3] = new Integer(14);
        integers[4] = new Integer(15);
        System.out.println(integers[0]);//11
        System.out.println(integers[1]);//12
        System.out.println(integers[2]);//13
        System.out.println(integers[3]);//14
        System.out.println(integers[4]);//15
        System.out.println(integers);   //[Ljava.lang.Integer;@1b6d3586
    }
}
