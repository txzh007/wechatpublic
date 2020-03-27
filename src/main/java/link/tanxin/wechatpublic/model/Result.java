package link.tanxin.wechatpublic.model;

public class Result<T> {

    private final static int SUCCESS = 200;

    private final static int NOT_SUPPORTED = 405;

    private final static int NOT_FOUND = 404;

    private final static int UN_AUTH = 401;

    private final static int PARAM_ERROR = 409;

    private final static int NOT_READABLE = 410;

    public final static int REQUEST_REPEAT = 440;

    public final static int NO_PERMISSION = 403;

    private final static int SIGNATURE_ERROR = 998;

    private final static int SYS_ERROR = 999;

    private int code;

    private String msg;

    private T data;

    private Object status;

    public Result() {
        this.code = SUCCESS;
        this.msg = "success";
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public Result setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public static Result asNotSupported(String msg) {
        return new Result(Result.NOT_SUPPORTED, msg);
    }

    public static Result asSuccess() {
        return new Result();
    }

    public static <T> Result asSuccess(T data) {
        return new Result<T>().setData(data);
    }

    public static Result asSysErr() {
        return new Result(Result.SYS_ERROR, "error");
    }

    public static Result asNotFound() {
        return new Result(Result.NOT_FOUND, "file not found");
    }

    public static Result asUnAuth() {
        return new Result(Result.UN_AUTH, "un auth");
    }

    public static <T> Result asParamErr(T data) {
        return new Result<T>(Result.PARAM_ERROR, "param error").setData(data);
    }

    public static Result asSignatureErr() {
        return new Result(Result.SIGNATURE_ERROR, "signature error.");
    }

    public static Result asNotReadable() {
        return new Result(Result.NOT_READABLE, "message not readable.");
    }
}
