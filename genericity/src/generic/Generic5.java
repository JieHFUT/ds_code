package generic;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-07-30
 * Time: 9:59
 */


import java.util.ArrayList;
import java.util.List;

/**
 * 通配符 ?
 *
 */

class Person{

}


class Student2 extends Person{

}

public class Generic5 {

    public static void main(String[] args) {
        List<Person> list1 = new ArrayList<>();
        List<Student2> list2 = new ArrayList<>();

        //list1 = list2;
    }
}
