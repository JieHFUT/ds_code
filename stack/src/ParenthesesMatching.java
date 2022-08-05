import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-05
 * Time: 17:37
 */
public class ParenthesesMatching {
    /**
     * 判断括号是否匹配
     * @param chars
     */
    public boolean judgeParenthesesMatching(char[] chars){
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == '[' || ch == '(' || ch == '{')
                characterStack.push(ch);
            else{
                if (characterStack.empty()){
                    return false;
                }
                switch (ch){
                    case ')':
                        if (characterStack.pop() != '(')
                            return false;
                        break;
                    case ']':
                        if (characterStack.pop() != '[')
                            return false;
                        break;
                    case '}':
                        if (characterStack.pop() != '{')
                            return false;
                        break;
                    default:
                        break;
                }
            }
        }
        if (!characterStack.empty())
            return false;

        return true;
    }

    public static void main(String[] args) {


        ParenthesesMatching parenthesesMatching = new ParenthesesMatching();

        char[] chars = {'(','{','(','(',')',')','(',')','}','[',']',')'};
        System.out.println(parenthesesMatching.judgeParenthesesMatching(chars));
    }



}
