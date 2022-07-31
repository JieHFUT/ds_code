package yanghuitriangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-07-31
 * Time: 22:58
 */


public class YangHuiTriangle {


    public List<List<Integer>> generate(int numRows){

        List<List<Integer>> ret = new ArrayList<>();

        List<Integer> rowOne = new ArrayList<>();
        rowOne.add(1);
        ret.add(rowOne);

        for (int i = 1; i < numRows; i++) {
            List<Integer> currentRow = new ArrayList<>();
            List<Integer> preRow = ret.get(i-1);
            currentRow.add(1);
            for (int j = 1; j < i; j++) {
                currentRow.add(preRow.get(j) + preRow.get(j-1));
            }
            currentRow.add(1);
            ret.add(currentRow);
        }
        return ret;
    }




    public static void main(String[] args) {

        YangHuiTriangle yangHuiTriangle = new YangHuiTriangle();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int n = scanner.nextInt();
            List<List<Integer>> lists = yangHuiTriangle.generate(n);
        }

    }





}
