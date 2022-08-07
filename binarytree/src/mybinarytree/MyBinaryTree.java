package mybinarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-06
 * Time: 4:40
 */


public class MyBinaryTree<E> {

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
    public TreeNote<Character> createBinaryTree(){
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
    public void preOrder(TreeNote<E> root){
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
        return;
    }
    public void inOrder(TreeNote<E> root){
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
        return;
    }
    public void postOrder(TreeNote<E> root){
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
        return;
    }


    /**
     * 另外形式的遍历方式
     * @param root
     * @return
     */


    public List<E> otherPreOrder(TreeNote<E> root){

        List<E> ret = new ArrayList<>();

        if (root == null) return ret;
        ret.add(root.val);

        List<E> leftTree = otherPreOrder(root.left);
        ret.addAll(leftTree);

        List<E> rightTree = otherPreOrder(root.right);
        ret.addAll(rightTree);

        return ret;
    }


    public List<E> otherInOrder(TreeNote<E> root){

        List<E> ret = new ArrayList<>();

        if (root == null) return ret;

        List<E> leftTree = otherPreOrder(root.left);
        ret.addAll(leftTree);

        ret.add(root.val);

        List<E> rightTree = otherPreOrder(root.right);
        ret.addAll(rightTree);

        return ret;
    }



    public List<E> otherPostOrder(TreeNote<E> root){

        List<E> ret = new ArrayList<>();

        if (root == null) return ret;

        List<E> leftTree = otherPreOrder(root.left);
        ret.addAll(leftTree);

        List<E> rightTree = otherPreOrder(root.right);
        ret.addAll(rightTree);

        ret.add(root.val);

        return ret;
    }


    /**
     * 一些方法
     * @param root
     * @return
     */

    private static int numTreeNote;
    // 获取树中节点的个数
    public int size(TreeNote<E> root){
        if (root == null) return this.numTreeNote;
        this.numTreeNote++;
        size(root.left);
        size(root.right);
        return this.numTreeNote;
    }
    public int otherSize(TreeNote<E> root){
        if (root == null) return 0;
        return otherSize(root.left) +
                otherSize(root.right) + 1;
    }







    private static int numLeafNode;
    // 获取叶子节点的个数
    public int getLeafNodeCount(TreeNote<E> root){
        if (root == null) return this.numLeafNode;
        if (root.left == null && root.right == null)
            this.numLeafNode++;
        getLeafNodeCount(root.left);
        getLeafNodeCount(root.right);
        return this.numLeafNode;
    }

    public int otherGetLeafNodeCount(TreeNote<E> root){
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        return otherGetLeafNodeCount(root.left) +
                otherGetLeafNodeCount(root.right);
    }







    // 子问题思路-求叶子结点个数
    // 获取第K层节点的个数
    public int getKLevelNodeCount(TreeNote<E> root, int k){
        if (root == null) return 0;
        if (k == 1 && root != null)
            return 1;
        return getKLevelNodeCount(root.left,k-1) +
                getKLevelNodeCount(root.right,k-1);
    }



    // 获取二叉树的高度
    public int getHeight(TreeNote<E> root){

        if (root == null) return 0;
        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);
        return leftH > rightH ? leftH+1 : rightH+1;


        /*if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return Math.max(getHeight(root.left),getHeight(root.right)) + 1;*/


        /*if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null)
            return getHeight(root.right) + 1;
        if (root.right == null)
            return getHeight(root.left) + 1;
        return Math.max(getHeight(root.left),getHeight(root.right)) + 1;*/
    }
    // 检测值为value的元素是否存在
    public TreeNote<E> find(TreeNote<E> root, int val){
        if (root == null) return null;
        if (root.val.equals(val)) return root;

        TreeNote<E> ret = find(root.left, val);
        if (ret != null)
            return ret;

        ret = find(root.right,val);
        if (ret != null)
            return ret;

        return null;
    }

    //层序遍历
    public void levelOrder(TreeNote<E> root){
        Queue<TreeNote> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            root = queue.peek();
            System.out.print(queue.poll().val+" ");
            if (root.left != null)
                queue.offer(root.left);
            if (root.right != null)
                queue.offer(root.right);
        }
    }

    public List<List<E>> otherLevelOrder(TreeNote<E> root) {
        List<List<E>> lists = new ArrayList<>();
        Queue<TreeNote<E>> eQueue = new LinkedList<>();
        eQueue.offer(root);

        while(!eQueue.isEmpty()){
            List<E> treeNoteList = new ArrayList<>();
            int size = eQueue.size();
            while(size != 0){
                treeNoteList.add(eQueue.peek().val);
                size--;
                root = eQueue.poll();
                if (root.left != null)
                    eQueue.offer(root.left);
                if (root.right != null)
                    eQueue.offer(root.right);
            }
            lists.add(treeNoteList);
        }

        return lists;
    }
    // 判断一棵树是不是完全二叉树
    public boolean isCompleteTree(TreeNote<E> root){
        if (root == null) return false;
        Queue<TreeNote> treeNoteQueue = new LinkedList<>();
        treeNoteQueue.offer(root);
        while(!treeNoteQueue.isEmpty()){
            root = treeNoteQueue.poll();
            if (root != null){
                treeNoteQueue.offer(root.left);
                treeNoteQueue.offer(root.right);
            }else {
                break;
            }
        }
        while(!treeNoteQueue.isEmpty()){
            TreeNote treeNote = treeNoteQueue.peek();
            if (treeNote == null){
                treeNoteQueue.poll();
            }else {
                return false;
            }
        }
        return true;
    }


    /**
     * 判断两棵树是否相同
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNote p, TreeNote q) {
        if (p == null && q == null) return true;
        if (p == null) return false;
        if (q == null) return false;
        if (q.val != p.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);

    }


    /**
     * 判断一颗树是否包含另外一棵树 Omin(m*n)
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree(TreeNote root, TreeNote subRoot) {

        if (root == null) return false;
        if (this.isSameTree(root,subRoot)) return true;
        return this.isSameTree(root.left,subRoot.left) || this.isSameTree(root.right,subRoot.right);
    }


    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * 一棵高度平衡二叉树定义为：
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNote root) {
        if (root == null) return true;
        int leftHeight = this.getHeight(root.left);
        int rightHeight = this.getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1)
            return false;
        if (!isBalanced(root.left)) return false;
        if (!isBalanced(root.right)) return false;
        return true;
    }







    public boolean otherIsBalanced(TreeNote root) {
        if (root == null) return true;
        if (otherGetHeight(root) != -1){
            return false;
        }else {
            return true;
        }
    }

    public int otherGetHeight(TreeNote root) {

        if (root == null) return 0;
        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);
        if (leftH >= 0 && rightH >= 0 && Math.abs(leftH - rightH) <= 1){
            return Math.max(leftH,rightH) + 1;
        }else {
            return -1;
        }
    }
    /**
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNote root) {
        if (root == null) return true;
        TreeNote current = inTurnOneTree(root.left);
        boolean flg = this.isSameTree(current,root.right);
        inTurnOneTree(root.left);
        return flg;
    }

    /**
     * 将一颗树的每个节点的 left和 right的指向反过来
     * @param root
     * @return
     */
    public TreeNote inTurnOneTree(TreeNote root){
        if (root == null) return null;
        TreeNote current = root.left;
        root.left = root.right;
        root.right = current;
        inTurnOneTree(root.left);
        inTurnOneTree(root.right);
        return root;
    }
















}

















