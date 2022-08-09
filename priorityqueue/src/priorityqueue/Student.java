package priorityqueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-09
 * Time: 22:08
 */
public class Student implements Comparable<Student>{
    public int age;


    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                '}';
    }


    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
    }
}
