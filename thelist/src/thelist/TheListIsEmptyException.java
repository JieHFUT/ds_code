package thelist;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-01
 * Time: 23:50
 */
public class TheListIsEmptyException extends RuntimeException{
    public TheListIsEmptyException() {
        super();
    }

    public TheListIsEmptyException(String message) {
        super(message);
    }
}
