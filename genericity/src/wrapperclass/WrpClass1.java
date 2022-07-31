package wrapperclass;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-07-30
 * Time: 11:46
 */

/**
 * 包装类
 * int -> Interger
 * char -> Character
 * 拆箱 -------- 把基本数据类型---包装类类型
 * 装箱 --------把包装类类型 ---基本数据类型
 *
 * 自动装箱：
 * 手动装箱：
 */
public class WrpClass1 {

    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;
        System.out.println(a == b);//true
        Integer c = 200;
        Integer d = 200;
        System.out.println(c == d);//false

        System.out.println(a.equals(b));//true
        System.out.println(c.equals(d));//true

    }
    public static void main2(String[] args) {
        Integer a = 10;//自动装箱
        int b = a;//自动拆箱
        double d1 = a;//intValue();
        double d2 = Double.valueOf(a);
        System.out.println(a);
    }
    public static void main1(String[] args) {
        int a = 10;

        Integer b = a;//自动装箱
        Integer c = Integer.valueOf(a);//手动装箱
        System.out.println(b);//10
    }
}
