package Entity.Mybatis;

/**
 * Created by Clanner on 2016/12/7.
 */
public class ObjResponse {
    private int code = 20000;
    private Object response;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }
}
