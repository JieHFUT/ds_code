/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-07-29
 * Time: 5:44
 */


/**
 * 空间复杂度是对一个算法在运行过程中临时占用存储空间大小的量度 。空间复杂度不是程序占用了多少bytes的空
 * 间，因为这个也没太大意义，所以空间复杂度算的是变量的个数。空间复杂度计算规则基本跟实践复杂度类似，也
 * 使用大O渐进表示法
 */

public class SpaceComplexity {

//    // 计算bubbleSort的空间复杂度？
//    void bubbleSort(int[] array){
//        for(int end=array.length;end>0;end--){
//            boolean sorted=true;
//            for(int i=1;i<end; i++){
//                if(array[i-1]>array[i]){
//                    Swap(array,i-1,i);
//                    sorted=false;
//                }
//            }
//            if(sorted==true){
//                break;
//            }
//        }
//    }
//==========O(1)==============


//    // 计算fibonacci的空间复杂度？
//    int[] fibonacci(int n) {
//        long[] fibArray = new long[n + 1];
//        fibArray[0] = 0;
//        fibArray[1] = 1;
//        for (int i = 2; i <= n ; i++) {
//            fibArray[i] = fibArray[i - 1] + fibArray [i - 2];
//        }
//        return fibArray;
//    }
//==========O(n)===============


    // 计算阶乘递归Factorial的空间复杂度？
    long factorial(int N) {
        return N < 2 ? N : factorial(N-1)*N;
    }
//==========O(n)===============

    public static void main(String[] args) {

    }

}
