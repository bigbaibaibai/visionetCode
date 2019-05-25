package xyz.thishome.onling_ksxt.util;

public class KsxtMsg {

    private String message;
    private Integer code;
    private Object data;

    public KsxtMsg(Integer code, String message, Object data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public KsxtMsg(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public KsxtMsg() {
    }

    public static KsxtMsg success(String message, Object data) {
        return new KsxtMsg(200, message, data);
    }

    public static KsxtMsg success(Object data) {
        return new KsxtMsg(200, "处理成功", data);
    }

    public static KsxtMsg success() {
        return new KsxtMsg(200, "处理成功");
    }

    public static KsxtMsg bulid(String message) {
        return new KsxtMsg(500, message);
    }

    public static KsxtMsg bulid() {
        return new KsxtMsg(500, "处理失败");
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
        return "KsxtMsg{" +
                "message='" + message + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }

}
