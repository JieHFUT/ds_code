import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-05
 * Time: 0:59
 */
public class LearnStack {


    /**
     * 栈可以在符合条件是使用，例如链表的逆向输出
     * @param args
     */
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        //puch ----- 入栈
        stack.push(11);
        stack.push(22);
        stack.push(33);
        stack.push(44);
        stack.push(55);
        stack.push(66);
        stack.push(77);

        //pop ------ 出栈
        int num = stack.pop();
        System.out.println(num);

        //peek ---- 获取栈顶元素但是不删除
        num = stack.peek();
        System.out.println(num);

        //empty --- 查询栈是否为空
        boolean flg = stack.empty();
        System.out.println(flg);


    }


}
