/**
 * java可变参数的案例
 * Created by AshinLiang on 2017/6/9.
 */
public class VariableParamsTest {


    public static void main(String[] args){
        VariableParamsTest test = new VariableParamsTest();
        System.out.println("相加得到的结果为:"+test.add(1,2,3,4,5,6));
        System.out.println("相加得到的结果为:"+test.add(12,54,1));
    }

    /**
     * 1.可变参数只能出现在参数列表的最后面
     * 2.调用可变参数的时候，编辑器会为可变参数隐式地
     * 创建一个数组，我们在代码中，需要通过数组的形式去访问这个
     * 可变参数
     */

    public int add(int ... args){
        int sum = 0;

        for (int i : args){
            sum += i;
        }

        return sum;
    }
}
