package sqlist;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-07-30
 * Time: 15:43
 */
public class MyArrayIsEmptyExption extends RuntimeException{

    public MyArrayIsEmptyExption(){

    }
    public MyArrayIsEmptyExption(String message){
        super(message);
    }
}
