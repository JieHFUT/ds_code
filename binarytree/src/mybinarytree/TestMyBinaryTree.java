package mybinarytree;

import structure.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-06
 * Time: 17:40
 */
public class TestMyBinaryTree {



    public static void main(String[] args) {

        MyBinaryTree<Character> myBinaryTree = new MyBinaryTree();
        MyBinaryTree.TreeNote root = myBinaryTree.createBinaryTree();


        myBinaryTree.preOrder(root);
        System.out.println();

        myBinaryTree.inOrder(root);
        System.out.println();

        myBinaryTree.postOrder(root);
        System.out.println();

        List<Character> characterList = myBinaryTree.otherPreOrder(root);
        System.out.println(characterList);


        System.out.println("----------一些方法---------------");
        int numOfNode = myBinaryTree.size(root);
        System.out.println("该树的节点个数为：" + numOfNode);

        int numOfLeaf = myBinaryTree.getLeafNodeCount(root);
        System.out.println("该树的叶子节点个数为：" + numOfLeaf);

        int numKLevel = myBinaryTree.getKLevelNodeCount(root,3);
        System.out.println("该树的第三层节点个数为：" + numKLevel);

        int heightOfTree = myBinaryTree.getHeight(root);
        System.out.println("该树的高度为：" + heightOfTree);


        System.out.println("层序遍历：");
        myBinaryTree.levelOrder(root);
        System.out.println();

        List<List<Character>> lists = myBinaryTree.otherLevelOrder(root);
        System.out.println(lists);


    }





}













