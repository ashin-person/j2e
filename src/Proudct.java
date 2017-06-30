/**
 * Created by AshinLiang on 2017/6/24.
 */
public class Proudct {

    private String name;
    public String type;
    private int num;

    public Proudct(String name, String type, int num) {
        this.name = name;
        this.type = type;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Proudct{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", num=" + num +
                '}';
    }
}
