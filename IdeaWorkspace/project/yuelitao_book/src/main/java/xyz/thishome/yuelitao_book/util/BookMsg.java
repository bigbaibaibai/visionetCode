package xyz.thishome.yuelitao_book.util;

public class BookMsg {

    private String message;
    private Integer code;
    private Object data;

    public BookMsg(Integer code, String message, Object data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public BookMsg(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public BookMsg() {
    }

    public static BookMsg success(String message, Object data) {
        return new BookMsg(200, message, data);
    }

    public static BookMsg success(Object data) {
        return new BookMsg(200, "处理成功", data);
    }

    public static BookMsg success() {
        return new BookMsg(200, "处理成功");
    }

    public static BookMsg bulid(String message) {
        return new BookMsg(500, message);
    }

    public static BookMsg bulid(Object data, String message) {
        return new BookMsg(500, message, data);
    }

    public static BookMsg bulid(Object data, String message, Integer code) {
        return new BookMsg(code, message, data);
    }

    public static BookMsg bulid() {
        return new BookMsg(500, "处理失败");
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
        return "BookMsg{" +
                "message='" + message + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }

}
