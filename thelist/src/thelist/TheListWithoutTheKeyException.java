package thelist;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-02
 * Time: 0:04
 */
public class TheListWithoutTheKeyException extends RuntimeException{
    public TheListWithoutTheKeyException() {
        super();
    }

    public TheListWithoutTheKeyException(String message) {
        super(message);
    }
}
