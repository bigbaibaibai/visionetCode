package xyz.thishome.common.pojo;

public class PhoneMsg {

    private String message;
    private Integer code;
    private Object data;

    public PhoneMsg(Integer code, String message, Object data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public PhoneMsg(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public PhoneMsg() {
    }

    public static PhoneMsg success(String message, Object data) {
        return new PhoneMsg(200, message, data);
    }

    public static PhoneMsg success(Object data) {
        return new PhoneMsg(200, "处理成功", data);
    }

    public static PhoneMsg success() {
        return new PhoneMsg(200, "处理成功");
    }

    public static PhoneMsg bulid(String message) {
        return new PhoneMsg(500, message);
    }

    public static PhoneMsg bulid(Object data, String message) {
        return new PhoneMsg(500, message, data);
    }

    public static PhoneMsg bulid(Object data, String message, Integer code) {
        return new PhoneMsg(code, message, data);
    }

    public static PhoneMsg bulid() {
        return new PhoneMsg(500, "处理失败");
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
        return "PhoneMsg{" +
                "message='" + message + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }

}
