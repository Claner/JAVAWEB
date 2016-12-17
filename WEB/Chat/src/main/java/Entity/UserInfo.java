package Entity;

/**
 * Created by Clanner on 2016/12/11.
 */
public class UserInfo {
    private int id;
    private int user_id;
    private String address;
    private String personal_sign;

    public UserInfo() {

    }

    public UserInfo(int user_id, String address, String personal_sign) {
        this.user_id = user_id;
        this.address = address;
        this.personal_sign = personal_sign;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPersonal_info() {
        return personal_sign;
    }

    public void setPersonal_info(String personal_sign) {
        this.personal_sign = personal_sign;
    }
}
