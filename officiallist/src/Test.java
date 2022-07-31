import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-07-31
 * Time: 23:54
 */
public class Test {

    public List<Character> func(String str1, String str2){

        if (str1 == null || str2 == null){
            return null;
        }

        List<Character> list = new ArrayList<>();

        for (int i = 0; i < str1.length(); i++) {
            char ch1 = str1.charAt(i);
            int j = 0;
            for (j = 0; j < str2.length(); j++) {
                char ch2 = str2.charAt(j);
                if (ch1 == ch2){
                    break;
                }
            }
            if (j == str2.length()){
                list.add(ch1);
            }
        }
        return list;
    }




    public static void main(String[] args) {
        Test test = new Test();
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            List<Character> list = test.func(str1,str2);
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
            }
            System.out.println();
            System.out.println(list);
        }

    }
}
