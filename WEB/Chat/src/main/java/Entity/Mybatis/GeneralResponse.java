package Entity.Mybatis;

/**
 * Created by Clanner on 2016/12/6.
 */
public class GeneralResponse {
    private int code;
    private String Response;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getResponse() {
        return Response;
    }

    public void setResponse(String response) {
        Response = response;
    }
}
