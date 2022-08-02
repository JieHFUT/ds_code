package thelist;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-01
 * Time: 17:10
 */
public class TheListAddIndexOutOfException extends RuntimeException{
    public TheListAddIndexOutOfException() {
    }

    public TheListAddIndexOutOfException(String message) {
        super(message);
    }
}
