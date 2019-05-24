package demo;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class MyMessage implements Delayed {
    private int id;
    private Object body;//消息体
    private long excuteTime;//执行时间


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }


    public long getExcuteTime() {
        return excuteTime;
    }

    public MyMessage(int id, Object body, long delayTime) {
        this.id = id;
        this.body = body;
        this.excuteTime = TimeUnit.NANOSECONDS.convert(delayTime, TimeUnit.MILLISECONDS) + System.nanoTime();
    }

    public void setExcuteTime(long excuteTime) {
        this.excuteTime = excuteTime;
    }

    public int compareTo(Delayed delayed) {
        if (delayed instanceof MyMessage) {
            MyMessage msg = (MyMessage) delayed;
            return Integer.valueOf(this.id) > Integer.valueOf(msg.id) ? 1 : (Integer.valueOf(this.id) < Integer.valueOf(msg.id) ? -1 : 0);
        } else {
            return -1;
        }
    }

    //获取延迟剩余时间，传入单位枚举类
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.excuteTime - System.nanoTime(), TimeUnit.NANOSECONDS);
    }
}
