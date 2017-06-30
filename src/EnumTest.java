/**
 * Created by AshinLiang on 2017/6/10.
 */
public class EnumTest {

    public static void main(String[] args){
        WeekDay wd = WeekDay.TUE;
        System.out.println(wd);
        System.out.println(WeekDay.MON.name());
        System.out.println("===========================");
        for (WeekDay d: WeekDay.values()){//枚举的values()是遍历整个枚举值
            System.out.println(d);//
        }


    }

    public static enum  WeekDay{
        MON,TUE,THIR;
    }
}
