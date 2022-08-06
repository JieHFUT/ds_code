package mybinarytree;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-06
 * Time: 4:40
 */


public class MyBinaryTree {

    class TreeNote<E> {
        public E val;
        public TreeNote left;
        public  TreeNote right;

        public TreeNote(E val){
            this.val = val;
        }
    }


    /**
     * 创建一颗字符型二叉树
     * @return
     */
    public TreeNote createBinaryTree(){
        TreeNote<Character> A = new TreeNote<>('A');
        TreeNote<Character> B = new TreeNote<>('B');
        TreeNote<Character> C = new TreeNote<>('C');
        TreeNote<Character> D = new TreeNote<>('D');
        TreeNote<Character> E = new TreeNote<>('E');
        TreeNote<Character> F = new TreeNote<>('F');
        TreeNote<Character> G = new TreeNote<>('G');
        TreeNote<Character> H = new TreeNote<>('H');

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        D.left = H;
        return A;

    }

    /**
     * 二叉树的三种遍历方式
     * @param root
     */
    public void preOrder(TreeNote root){
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        postOrder(root.right);
    }
    public void inOrder(TreeNote root){
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);

    }
    public void postOrder(TreeNote root){
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }







}

















