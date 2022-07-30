package sqlist;

import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-07-30
 * Time: 12:45
 */


public class MyArrayList {

    public int[] elem;
    public int usedSize;

    private static final int DEFAULT_SIZE = 4;

    public MyArrayList() {
        this.elem = new int[DEFAULT_SIZE];
    }

    // 打印顺序表 -- 根据usedSize判断
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(elem[i] + " ");
        }
        System.out.println();
    }
    //判断数组是不是满的
    public boolean isFull(){
        return this.usedSize == elem.length;
    }
    // 新增元素,默认在数组最后新增
    public void add(int data) {
        //1、判断数组是不是满的，如果是满的，则扩容
        if (this.isFull()){
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }
        this.elem[this.usedSize] = data;
        this.usedSize++;
    }
    private boolean checkPosInAdd(int pos){
        if (pos < 0 || pos > this.usedSize){
            System.out.println("pos位置不合法！");
            return true;
        }
        return false;
    }
    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        /**
         * 1、判断pos位置的合法性
         * 2、判断顺序表是否已满
         * 3、插入数据
         *      3.1、挪动数据
         *      3.2、插入数据
         */
        if (checkPosInAdd(pos)){
            throw new MyArrayListIndexIllegal("添加方法的pos不合法！");
        }
        if (isFull()){
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }
        //挪动数据
        for (int i = this.usedSize-1; i >= pos ; i--) {
            this.elem[i+1] = this.elem[i];
        }
        //插入数据
        this.elem[pos] = data;
        this.usedSize++;
    }


    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind);
            return true;
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int indexOf(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind){
                return i;
            }
        }
        return -1;
    }
    private boolean checkPosInGet(int pos){
        if (pos < 0 || pos > this.usedSize){
            System.out.println("pos位置不合法！");
            return false;
        }
        return true;
    }
    private boolean isEmptyInGet(){
        return this.usedSize == 0;
    }
    // 获取 pos 位置的元素
    public int get(int pos) {
        if (!checkPosInGet(pos)){
            throw new MyArrayListIndexIllegal("获取pos下标时，位置不合法！");
        }
        if (isEmptyInGet()){
            throw new MyArrayIsEmptyExption("空数组异常！");
        }
        return this.elem[pos];
    }

    private boolean checkPosInSet(int pos){
        if (pos < 0 || pos > this.usedSize){
            System.out.println("pos位置不合法！");
            return true;
        }
        return false;
    }
    private boolean isEmptyInSet(){
        return this.usedSize == 0;
    }
    // 给 pos 位置的元素设为 value
    public void set(int pos, int value) {
        if (checkPosInSet(pos)){
            throw new MyArrayListIndexIllegal("获取pos下标时，位置不合法！");
        }
        if (isEmptyInSet()){
            throw new MyArrayIsEmptyExption("空数组异常！");
        }
        this.elem[pos] = value;
    }
    //删除第一次出现的关键字key
    public void remove(int toRemove) {

    }
    // 获取顺序表长度
    public int size() {
        return 0;
    }
    // 清空顺序表
    public void clear() {

    }





    public static void main(String[] args) {



    }

}
