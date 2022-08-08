package structure;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-08
 * Time: 9:27
 */
public class Oj {

    class Node{
        public char val;
        public Node left;
        public Node right;
        public Node(char val){
            this.val = val;
        }

    }
    public static int i;
    public Node createTree(String str){
        Node root = null;
        if(str.charAt(i) != '#'){
            root = new Node(str.charAt(i));
            i++;
            root.left = createTree(str);
            root.right = createTree(str);
        }else{
            i++;
        }
        return root;
    }

    public void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }


    public static void main(String[] args){
        Oj oj = new Oj();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String str = scanner.nextLine();
            Node node = oj.createTree(str);
            oj.inOrder(node);
        }
    }
}
