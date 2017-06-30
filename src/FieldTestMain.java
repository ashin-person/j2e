import java.lang.reflect.Field;

/**
 * Created by AshinLiang on 2017/6/24.
 */
public class FieldTestMain {

    public static void main(String[] args){
        Proudct proudct = new Proudct("ashin","adfsdfasaa",23);
        replaceObjString(proudct);
        System.out.println(proudct);
    }

    /**
     * 反射的应用
     * 将一个类中的String类型的字段的"a"替换为"b"
     * @param object
     */
    public static void replaceObjString(Object object){
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields){
            if (field.getType()==String.class){//判断是否为String类型
                field.setAccessible(true);
                try {
                    String oldValue = (String) field.get(object);
                    String newValue = oldValue.replace("a","b");
                    field.set(object,newValue);//设置为修改之后的值
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
