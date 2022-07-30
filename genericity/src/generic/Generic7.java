package generic;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-07-30
 * Time: 10:47
 */

/**
 * 通配符的上下界
 * ? extends 类：设置通配符上界
 * ? super 类：设置通配符下界，可以传入的实参类型是Number或者Number的子类
 */


//上界
class Food {
}
class Fruit extends Food {
}
class Apple extends Fruit {
}
class Banana extends Fruit {
}
class Plate<T> { // 设置泛型上限
    private T plate ;
    public T getPlate() {
        return plate;
    }
    public void setPlate(T plate) {
        this.plate = plate;
    }
}

//通配符的上界一般用来读取元素，不能写入数据
public class Generic7 {
    public static void fun(Plate<? extends Fruit> temp){
        //temp.setPlate(new Banana()); //仍然无法修改！
        //temp.setPlate(new Apple()); //仍然无法修改！
        Fruit b = temp.getPlate();
        System.out.println(b);
    }

    //通配符的下界一般用来写入数据，不适合读取数据
    public static void func(Plate<? super Fruit> temp){
        temp.setPlate(new Apple());
        temp.setPlate(new Banana());
        //不安全
        Fruit fruit = (Fruit) temp.getPlate();
    }





    public static void main(String[] args) {

        Plate<Apple> plate = new Plate<>();
        plate.setPlate(new Apple());
        fun(plate);

        Plate<Banana> plate2 = new Plate<>();
        plate2.setPlate(new Banana());
        fun(plate2);

        Plate<Fruit> plate3 = new Plate<>();
        plate3.setPlate(new Banana());
        func(plate3);

        Plate<Food> plate4 = new Plate<>();
        func(plate4);

    }

}
