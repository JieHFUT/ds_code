package generic;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-07-29
 * Time: 19:37
 *
 * 泛型的上界
 * class Alg<T extends Comparable<T>> {}
 * 其在编译的时候转换为 Object类，所以只有Object类的方法，想要实现其他的方法，
 * 就要实现接口，然后重写，而如果这个泛型类->其他类，如泛型类->Inerger类，由于Inerger已经重写了compareTo方法，所以
 * 只要实现了这个接口的，都可以接收 -- 就像Interger实现了这个接口，就可以接收
 */


class Alg<T extends Comparable<T>> {
    public T findMax(T[] array){
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(max.compareTo(array[i]) < 0){
                max = array[i];
            }
        }
        return max;
    }
}

//静态的泛型方法
class Alg2 {
    public static<T extends Comparable<T> > T findMax(T[] array){
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(max.compareTo(array[i]) < 0){
                max = array[i];
            }
        }
        return max;
    }
}


class Student implements Comparable<Student>{
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
    }
}


public class Generic3 {



    public static void main(String[] args) {

        //引用类型不可以直接比较大小
        Alg<Integer> alg =new Alg<>();
        Integer[] array = {1,2,3,4,5};
        Integer max = alg.findMax(array);
        System.out.println(max);


        Integer max2 = Alg2.findMax(array);
        Integer max3 = Alg2.<Integer>findMax(array);



        Alg<Student> alg1 = new Alg<>();
        Student[] students = new Student[3];
        students[0] = new Student("wangrenjei",23);
        students[1] = new Student("wdqjhwqbdw",43);
        students[2] = new Student("fhwegweyuy",53);
        Student student = alg1.findMax(students);
        System.out.println(student);
    }

}
