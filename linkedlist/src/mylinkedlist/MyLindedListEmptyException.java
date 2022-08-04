package mylinkedlist;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-04
 * Time: 23:28
 */
public class MyLindedListEmptyException extends RuntimeException{
    public MyLindedListEmptyException() {
    }

    public MyLindedListEmptyException(String message) {
        super(message);
    }
}
