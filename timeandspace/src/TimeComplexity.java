import com.sun.org.apache.bcel.internal.generic.SWAP;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-07-29
 * Time: 4:49
 */




public class TimeComplexity {
    //算法中的基本操作的执行次数，为算法的时间复杂度
    void func1(int N) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                count++;
            }
        }

        for (int k = 0; k < 2 * N; k++) {
            count++;
        }
        int M = 10;
        while ((M--) > 0) {
            count++;
        }
    }
    //n*n+2*n+10 ------- 执行次数

    // 计算bubbleSort的时间复杂度？
//    void bubbleSort(int[] array) {
//        for (int end = array.length; end > 0; end--) {
//            boolean sorted = true;
//            for (int i = 1; i < end; i++) {
//                if (array[i - 1] > array[i]) {
//                    Swap(array, i - 1, i);
//                    sorted = false;
//                }
//            }
//            if (sorted == true) {
//                break;
//            }
//        }
//    }
//    O(n^2)    O(n)

    // 计算binarySearch的时间复杂度？
    int binarySearch(int[] array, int value) {
        int begin = 0;
        int end = array.length - 1;
        while (begin <= end) {
            int mid = begin + ((end-begin) / 2);
            if (array[mid] < value)
                begin = mid + 1;
            else if (array[mid] > value)
                end = mid - 1;
            else
                return mid;
        }
        return -1;
    }
//    O(log2 N)    O(1)

    // 计算阶乘递归factorial的时间复杂度？
    long factorial(int N) {
        return N < 2 ? N : factorial(N-1) * N;
    }
//   O(n)  -----  递归的时间复杂度就是递归的次数*每次递归执行的次数

    // 计算斐波那契递归fibonacci的时间复杂度？
    int fibonacci(int N) {
        return N < 2 ? N : fibonacci(N-1)+fibonacci(N-2);
    }
//   O(2^n)
    /**
     * 1、用常数1取代运行时间中的所有加法常数。
     * 2、在修改后的运行次数函数中，只保留最高阶项。
     * 3、如果最高阶项存在且不是1，则去除与这个项目相乘的常数。得到的结果就是大O阶
     *
     *
     * 最坏情况：任意输入规模的最大运行次数(上界)
     * 平均情况：任意输入规模的期望运行次数
     * 最好情况：任意输入规模的最小运行次数(下界)
     * @param args
     */

    public static void main(String[] args) {


    }
}
