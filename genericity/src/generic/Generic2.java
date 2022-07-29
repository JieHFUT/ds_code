package generic;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-07-29
 * Time: 18:53
 */

/**
 * Object[] array = new Object[10];
 * public T[] array = new T[10]; ====== 报错的原因是由
 * 于数组的特殊性质，在实例化数组的时候 T不是一个具体类型
 * public T[] array = (T[])new Object[10];
 *
 *
 *
 * <T> --------- 泛型 ------- 占位符，表示当前类是一个泛型类
 *
 */
public class Generic2<T> {


    public T[] array = (T[])new Object[10];
    /**
     * 得到下标为 pos的数据
     * @param pos
     * @return
     */
    public T getPos(int pos){
        return array[pos];
    }

    /**
     * 给下标为 pos的位置赋值
     * @param pos
     * @param val
     * @return
     */
    public void setPos(int pos, T val){
        array[pos] = val;
    }

    public T[] getArray(){
        return array;
    }


    public static void main(String[] args) {

        /**
         * 1、<Integer>表示当前类中，使用的类型是Integer类型
         * 2、泛型在帮我们编译的时候，进行类型的检查
         *      2.1、存放元素的时候，进行类型的检查
         *      2.2、取元素的时候，帮我们紧张类型的转换
         * 3、<>里面必须是一个引用类型，不能是基本类型，至于后面的<>里面的内容可以省略
         */
        Generic2<Integer> generic = new Generic2<Integer>();

        generic.setPos(0,1);
        generic.setPos(1,2);
//        generic.setPos(1,"wqefwef");
//        String ret = (String) generic.getPos(1);
        Integer ret = generic.getPos(1);
        System.out.println(ret);//2


        Generic2<String> generic2 = new Generic2<String>();

        generic2.setPos(1,"dwq");
        generic2.setPos(2,"qdwsdc");
        String str1 = generic2.getPos(2);
        System.out.println(str1);



        //泛型类的使用如果不使用<> 称裸类型
        Generic2 generic21 = new Generic2();
        Integer integer = new Integer(12);


        /**
         * Java的泛型，是在编译的时候，将类型 T擦除为了Object
         */

    }
}
