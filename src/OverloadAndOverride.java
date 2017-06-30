/**
 * overload与override的区别
 * Created by AshinLiang on 2017/6/9.
 */
public class OverloadAndOverride {

    public int add(int a,int b){
        int sum = 0;

        sum = a + b;

        return sum;
    }

    public int add(int a,int b,int c){
        int sum = 0;

        sum = a + b + c;

        return sum;
    }

    public String add(int ...args){

        int sum = 0;
        for (int i : args){
            sum += i;
        }

        return String.valueOf(sum);
    }
}
