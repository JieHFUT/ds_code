package generic;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-07-30
 * Time: 10:26
 */
class Message<T> {
    private T message ;
    public T getMessage() {
        return message;
    }
    public void setMessage(T message) {
        this.message = message;
    }
}




public class Generic6 {

    public static void main(String[] args) {
        Message<Integer> message = new Message() ;
        message.setMessage(1);
        fun(message);
    }
    public static void main1(String[] args) {
        Message<String> message = new Message() ;
        message.setMessage("比特就业课欢迎您");
        fun(message);
    }
    public static void fun(Message<?> temp){
        //temp.setMessage(); ========= 是不能往里面添加元素的，所以源码里面通配符居多
        System.out.println(temp.getMessage());
    }
//    public static void fun(Message<String> temp){
//        System.out.println(temp.getMessage());
//    }
}
