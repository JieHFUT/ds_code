package myquene;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-05
 * Time: 22:46
 */
public class MyLinkedListEmptyException extends RuntimeException{
    public MyLinkedListEmptyException() {
        super();
    }

    public MyLinkedListEmptyException(String message) {
        super(message);
    }
}
