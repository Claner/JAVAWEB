package Entity;

import java.util.List;

/**
 * Created by Clanner on 2016/12/18.
 */
public class ObjListResponse {
    private int code;
    private List<Object> response;

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
}
