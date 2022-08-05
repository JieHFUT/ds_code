package myquene;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-05
 * Time: 23:50
 */
public class MyListListIsFullException extends RuntimeException{
    public MyListListIsFullException() {
    }

    public MyListListIsFullException(String message) {
        super(message);
    }
}
