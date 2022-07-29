package generic;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-07-29
 * Time: 8:11
 */
public class Generic1 {
    Object[] array = new Object[10];

    /**
     * 得到下标为 pos的数据
     * @param pos
     * @return
     */
    public Object getPos(int pos){
        return array[pos];
    }

    /**
     * 给下标为 pos的位置赋值
     * @param pos
     * @param object
     * @return
     */
    public void setPos(int pos, Object object){
        array[pos] = object;
    }



    public static void main(String[] args) {

        Generic1 generic = new Generic1();
        generic.setPos(0,10);
        generic.setPos(1,"wqefwef");
        String ret = (String) generic.getPos(1);


    }

}
