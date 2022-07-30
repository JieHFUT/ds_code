package sqlist;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-07-30
 * Time: 18:09
 */
public class MyArrayListInputExption extends RuntimeException{
    public MyArrayListInputExption(){

    }
    public MyArrayListInputExption(String message){
        super(message);
    }
}
