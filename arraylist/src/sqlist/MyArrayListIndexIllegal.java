package sqlist;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-07-30
 * Time: 15:12
 */
public class MyArrayListIndexIllegal extends RuntimeException{
    public MyArrayListIndexIllegal(){

    }
    public MyArrayListIndexIllegal(String message){
        super(message);
    }
}
