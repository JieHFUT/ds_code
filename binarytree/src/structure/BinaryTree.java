package structure;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-06
 * Time: 2:45
 */


// 孩子表示法
class Node1 {
    int val; // 数据域
    Node1 left; // 左孩子的引用，常常代表左孩子为根的整棵左子树
    Node1 right; // 右孩子的引用，常常代表右孩子为根的整棵右子树
}
// 孩子双亲表示法
class Node2 {
    int val; // 数据域
    Node2 left; // 左孩子的引用，常常代表左孩子为根的整棵左子树
    Node2 right; // 右孩子的引用，常常代表右孩子为根的整棵右子树
    Node2 parent; // 当前节点的根节点
}

public class BinaryTree {

}

























