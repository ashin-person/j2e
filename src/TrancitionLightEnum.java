/**
 * Created by AshinLiang on 2017/6/11.
 */
public enum TrancitionLightEnum {

    GREEN("绿灯","LG"),RED("红灯","LRED"),YELLOW("黄灯","LYELLOW");

    private String descript;
    private String code;

    private TrancitionLightEnum(String descript,String code){
        this.descript = descript;
        this.code = code;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
