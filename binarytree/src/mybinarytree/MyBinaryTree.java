package mybinarytree;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.util.*;

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




    public boolean otherIsSymmetric(TreeNote root) {
        if (root == null) return true;
        return isSymmetricChild(root.left,root.right);
    }

    public boolean isSymmetricChild(TreeNote leftTree, TreeNote rightTree){
        if (leftTree == null && rightTree == null) return true;
        if (leftTree == null) return false;
        if (rightTree == null) return false;
        if (leftTree.val != rightTree.val) return false;
        return isSymmetricChild(leftTree.left, rightTree.right) &&
                isSymmetricChild(leftTree.right, rightTree.left);

    }


    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先
     */
    public TreeNote lowestCommonAncestor(TreeNote root, TreeNote p, TreeNote q) {
        if (root == null) return null;

        Stack<TreeNote> stack1 = new Stack<>();
        this.findPath(root,p,stack1);

        Stack<TreeNote> stack2 = new Stack<>();
        this.findPath(root,q,stack2);

        int lenStack1 = stack1.size();
        int lenStack2 = stack2.size();

        if (lenStack1 >= lenStack2){
            int lenDiffer = lenStack1 - lenStack2;
            while(lenDiffer > 0){
                stack1.pop();
                lenDiffer--;
            }
        }else {
            int lenDiffer = lenStack2 - lenStack1;
            while (lenDiffer > 0) {
                stack2.pop();
                lenDiffer--;
            }
        }
        while(!stack1.isEmpty()){
            if (stack1.peek() == stack2.peek())
                return stack1.pop();
            stack1.pop();
            stack2.pop();
        }
        return null;
    }

    public boolean findPath(TreeNote root, TreeNote note, Stack<TreeNote> treeNoteStack){
        if (root == null || note == null) return false;
        if (root == note) {
            treeNoteStack.push(root);
            return true;
        }
        treeNoteStack.push(root);
        boolean flg1 = findPath(root.left,note,treeNoteStack);
        boolean flg2 = findPath(root.right,note,treeNoteStack);
        if (flg1 == false && flg2 == false){
            treeNoteStack.pop();
            return false;
        }
        return true;
    }


    public TreeNote otherLowestCommonAncestor(TreeNote root, TreeNote p, TreeNote q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNote leftTree = otherLowestCommonAncestor(root.left,p,q);
        TreeNote rightTree = otherLowestCommonAncestor(root.right,p,q);

        if (leftTree == root.left && rightTree == root.right){
            return root;
        } else if (leftTree == root.left) {
            return root.left;
        } else if (rightTree == root.right) {
            return root.right;
        }
        return null;
    }






















    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表
     * @param //pRootOfTree
     * @return
     */
    public TreeNote preRoot;
    public void conventChild(TreeNote root){
        if (root == null) return;
        conventChild(root.left);
        root.left = this.preRoot;
        if (this.preRoot != null) {
            this.preRoot.right = root;
        }
        this.preRoot = root;
        conventChild(root.right);
    }
    public TreeNote convert(TreeNote pRootOfTree) {
        if (pRootOfTree == null) return null;
        conventChild(pRootOfTree);
        TreeNote ret = pRootOfTree;
        if (ret.left != null) {
            ret = ret.left;
        }
        return ret;

    }









    /**
         * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表
         * @param pRootOfTree
         * @return
         */

    public TreeNote otherConvert(TreeNote pRootOfTree) {
        Queue<TreeNote> queueOfTree = this.archived(pRootOfTree);
        TreeNote ret = queueOfTree.peek();
        ret.left = null;
        while(!queueOfTree.isEmpty()){
            TreeNote current = queueOfTree.peek();
            queueOfTree.poll();
            if (!queueOfTree.isEmpty()){
                TreeNote nextCurrent = queueOfTree.peek();
                current.right = nextCurrent;
                nextCurrent.left = current;
            }
            if(queueOfTree.isEmpty())
                current.right = null;
        }
        return ret;
    }

    /**
     * 将一颗二叉搜索树的中序遍历的的节点存储在一个队列中
     * @param root
     * @return
     */
    public Queue<TreeNote> archived(TreeNote root){
        Queue<TreeNote> queue = new LinkedList();
        if (root == null) return queue;

        Queue<TreeNote> queue1 = archived(root.left);
        queue.addAll(queue1);

        Queue<TreeNote> queue2 = archived(root.right);
        queue.addAll(queue2);

        return queue;
    }


    /**
     * 给定两个整数数组 preorder 和 inorder ，
     * 其中 preorder 是二叉树的先序遍历，
     * inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
     * @param preorder
     * @param inorder
     * @return
     */

    public TreeNote buildTree1(int[] preorder, int[] inorder) {

        TreeNote ret = this.createTree(preorder,inorder,0,inorder.length-1);
        return ret;
    }

    private int rootIndex = 0;
    public TreeNote createTree(int[] preorder, int[] inorder, int leftBegin, int rightEnd) {
        TreeNote ret = new TreeNote(preorder[rootIndex]);
        if (leftBegin > rightEnd) return null;
        //找到根节点
        int val = preorder[this.rootIndex];
        //找到在中序数组中对应的根节点的位置的下标，将中序数组的左右子树分离出来
        int subscript = findInorderOfVal(inorder,leftBegin,rightEnd,val);
        if (subscript == -1)
            return null;
        this.rootIndex++;
        ret.left = createTree(preorder,inorder,leftBegin,subscript-1);
        ret.right = createTree(preorder,inorder,subscript+1,rightEnd);
        return ret;
    }

    public int findInorderOfVal(int[] inorder, int leftBegin, int rightEnd, int val) {
        for (int i = 0; i < rightEnd; i++) {
            if (inorder[i] == val)
                return i;
        }
        return -1;
    }







    /**
     * 给定两个整数数组 inorder 和 postorder ，
     * 其中 inorder 是二叉树的中序遍历，
     * postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNote buildTree2(int[] inorder, int[] postorder) {
        this.rootIndex2 = postorder.length-1;
        TreeNote ret = this.createTree2(inorder,0,inorder.length-1,postorder);
        return ret;
    }
    private int rootIndex2 = 0;
    public TreeNote createTree2(int[] inorder, int leftBegin, int rightEnd, int[] postorder) {
        if (leftBegin > rightEnd) return null;
        int val = postorder[rootIndex2];
        TreeNote ret = new TreeNote(val);
        int subscript = toFindInorderOfVal(inorder,leftBegin,rightEnd,val);
        if (subscript == -1) return null;
        rootIndex2--;
        ret.right = createTree2(inorder, subscript+1,rightEnd,postorder);
        ret.left = createTree2(inorder, leftBegin,subscript-1,postorder);
        return ret;
    }

    public int toFindInorderOfVal(int[] inorder, int leftBegin, int rightEnd, int val) {
        for (int i = leftBegin; i <= rightEnd; i++) {
            if (inorder[i] == val)
                return i;
        }
        return -1;
    }


    /**
     * 给你二叉树的根节点 root ，
     * 请你采用前序遍历的方式，将二叉树转化为一个由括号和整数组成的字符串，
     * 返回构造出的字符串。
     *
     * 空节点使用一对空括号对 "()" 表示，
     * 转化后需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
     * @param root
     * @return
     */
    public String tree2str(TreeNote root) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder = treeToStr(root,stringBuilder);
        return stringBuilder.toString();

    }

    public StringBuilder treeToStr(TreeNote treeNote, StringBuilder stringBuilder) {
        if (treeNote == null) return null;
            stringBuilder.append(treeNote.val);
        if (treeNote.left != null) {
            if (treeNote.right != null) {
                stringBuilder.append('(');
                treeToStr(treeNote.left,stringBuilder);
                treeToStr(treeNote.right,stringBuilder);
            }else {
                stringBuilder.append('(');
                treeToStr(treeNote.left,stringBuilder);
            }
        }else {
            if (treeNote.right != null) {
                stringBuilder.append('(');
                stringBuilder.append("()");
                treeToStr(treeNote.right,stringBuilder);
            }else {
                return stringBuilder;
            }
        }
        stringBuilder.append(')');
        return stringBuilder;
    }

    /**
     * 使用非递归来实现三种遍历方式
     *
     */

    public List preorderTraversal(TreeNote root) {
        if (root == null) return null;
        List treeNoteList = new ArrayList<>();
        Stack<TreeNote> treeNoteStack = new Stack<>();
        TreeNote current = root;
        while(current != null || !treeNoteStack.isEmpty()) {
            while(current != null) {
                treeNoteStack.push(current);
                treeNoteList.add(treeNoteStack.peek().val);
                current = current.left;
            }
            current = treeNoteStack.pop().right;
        }
        return treeNoteList;
    }





    /*public List<Integer> inorderTraversal(TreeNote root) {

    }





    public List<Integer> postorderTraversal(TreeNote root) {

    }
}*/





}

















