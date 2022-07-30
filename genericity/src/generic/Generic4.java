package generic;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-07-29
 * Time: 21:26
 */


/**
 * 没有指定类型边界 E，可以视为 E extends Object
 * @param <E>
 */
class Test<E extends Number> {

}


public class Generic4 {

    public static void main(String[] args) {

        Test<Integer> test1 = new Test<>();
        Test<Float> test2 = new Test<>();
        Test<Double> test3 = new Test<>();
        Test<Number> test4 = new Test<>();

    }
}
