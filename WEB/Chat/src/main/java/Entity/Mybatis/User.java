package Entity.Mybatis;

/**
 * Created by Clanner on 2016/12/6.
 */
public class User {
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    private int id;
    private String username;
    private String password;
    private String sex;
    private String account;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public User() {
    }

    public User(int code) {
        this.code = code;
    }

    public User(String username, String account, String password, String sex) {
        this.username = username;
        this.account = account;
        this.password = password;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
