import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-05
 * Time: 16:56
 */
public class PolishExpression {

    private boolean isOperations(String s){
        if (s.equals("+") || s.equals("-") ||s.equals("*") ||s.equals("/"))
            return true;
        return false;
    }

    public static void main(String[] args) {

       PolishExpression polishExpression = new PolishExpression();



        String[] tokens = {"1","2","3","*","+","4","5","*","6","+","7","*","+"};
        Stack<String> stringStack = new Stack<>();
        //遍历这个字符串数组，如果是数字就进栈，否则就出栈
        for (int i = 0; i < tokens.length; i++) {
            String string = tokens[i];
            if (!polishExpression.isOperations(string)){
                stringStack.push(string);
            }else {
                // + - * /
                /*int num1 = Integer.valueOf(stringStack.pop());
                int num2 = Integer.valueOf(stringStack.pop());
                int num3 = 0;
                if (string.equals("+"))
                    num3 = num2 + num1;
                if (string.equals("-"))
                    num3 = num2 - num1;
                if (string.equals("*"))
                    num3 = num2 * num1;
                if (string.equals("/"))
                    num3 = num2 / num1;
                stringStack.push(String.valueOf(num3));*/


                int num1 = Integer.valueOf(stringStack.pop());
                int num2 = Integer.valueOf(stringStack.pop());
                String str = null;
                switch (string){
                    case "+":
                        str = stringStack.push(String.valueOf(num1 + num2));
                        break;
                    case "-":
                        str = stringStack.push(String.valueOf(num1 - num2));
                        break;
                    case "*":
                        str = stringStack.push(String.valueOf(num1 * num2));
                        break;
                    case "/":
                        str = stringStack.push(String.valueOf(num1 / num2));
                        break;
                    default:
                        break;
                }
                stringStack.push(str);

            }
        }
        int ret = Integer.valueOf(stringStack.pop());
        System.out.println(ret);


    }


}
