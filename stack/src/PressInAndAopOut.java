import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-05
 * Time: 18:25
 */
public class PressInAndAopOut {

    /**
     * 输入：
     * [1,2,3,4,5],[4,5,3,2,1]
     * 返回值：true
     * 可以通过push(1)=>push(2)=>push(3)=>push(4)=>pop()=>push(5)=>pop()=>pop()=>pop()=>pop()
     * 这样的顺序得到[4,5,3,2,1]这个序列，返回true
     * @param pushA,popA
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int j = 0;
        Stack<Integer> integerStack = new Stack<>();
        for (int i = 0; i < pushA.length; i++) {
            int puch = pushA[i];
            integerStack.push(puch);
            int m = i - j;
            for (int k = 0; k <= m; k++) {
                if (integerStack.peek() == popA[j]){
                    integerStack.pop();
                    j++;
                }
            }
        }
        if (j == popA.length)
            return true;
        return false;
    }

    public static void main(String[] args) {

        int[] puchA = {1,2,3,4,5};
        int[] popA = {4,5,3,2,1};

        PressInAndAopOut pressInAndAopOut = new PressInAndAopOut();
        boolean flg = pressInAndAopOut.IsPopOrder(puchA,popA);
        System.out.println(flg);

    }
}
