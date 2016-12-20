package Entity.Mybatis;

import java.util.List;

/**
 * Created by Clanner on 2016/12/7.
 */
public class ObjListResponse {
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Object> getResponse() {
        return response;
    }

    public void setResponse(List<Object> response) {
        this.response = response;
    }

    private List<Object> response;
}
