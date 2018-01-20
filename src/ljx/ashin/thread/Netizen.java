package ljx.ashin.thread;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 网民
 * Created by AshinLiang on 2017/8/12.
 */
public class Netizen implements Delayed {

    private int personId;//身份证
    private long money;//网费
    private String name;//姓名
    private long endTime;//结束时间
    //定义时间工具类
    private TimeUnit timeUnit = TimeUnit.SECONDS;

    public Netizen(int personId, long money, String name, long endTime) {
        this.personId = personId;
        this.money = money;
        this.name = name;
        this.endTime = endTime;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return this.endTime-System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed delayed) {
        Netizen netizen = (Netizen)delayed;
//        this.personId>netizen.getPersonId()?1:0;
        return (this.getDelay(this.timeUnit) - netizen.getDelay(this.timeUnit)) > 0 ? 1:0;

    }

    @Override
    public String toString() {
        return "Netizen{" +
                "personId=" + personId +
                ", money=" + money +
                ", name='" + name + '\'' +
                ", endTime=" + endTime +
                ", timeUnit=" + timeUnit +
                '}';
    }
}
