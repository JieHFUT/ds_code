package mybinarytree;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-06
 * Time: 17:40
 */
public class TestMyBinaryTree {

    public static void main(String[] args) {

        MyBinaryTree myBinaryTree = new MyBinaryTree();
        MyBinaryTree.TreeNote root = myBinaryTree.createBinaryTree();


        myBinaryTree.preOrder(root);
        System.out.println();

        myBinaryTree.inOrder(root);
        System.out.println();

        myBinaryTree.postOrder(root);
        System.out.println();




    }





}













