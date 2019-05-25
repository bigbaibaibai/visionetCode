package xyz.thishome.hotel.util;

public class HotelMsg {

    private String message;
    private Integer code;
    private Object data;

    public HotelMsg(Integer code, String message, Object data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public HotelMsg(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public HotelMsg() {
    }

    public static HotelMsg success(String message, Object data) {
        return new HotelMsg(200, message, data);
    }

    public static HotelMsg success(Object data) {
        return new HotelMsg(200, "处理成功", data);
    }

    public static HotelMsg success() {
        return new HotelMsg(200, "处理成功");
    }

    public static HotelMsg bulid(String message) {
        return new HotelMsg(500, message);
    }

    public static HotelMsg bulid() {
        return new HotelMsg(500, "处理失败");
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HotelMsg{" +
                "message='" + message + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
