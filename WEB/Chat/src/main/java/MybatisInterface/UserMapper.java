package MybatisInterface;

import Entity.User;
import Entity.UserInfo;

import java.util.List;

/**
 * Created by Clanner on 2016/12/10.
 */
public interface UserMapper {
    void insertUser(User user);

    User login(User user);

    List<User> getAllUser();

    User getUser(int id);

    boolean modifyPassword(User user);

    User getUserID(String account);

    boolean insertUserInfo(UserInfo userInfo);

    UserInfo getUserInfo(int user_id);

    boolean updateUserInfo(UserInfo userInfo);
}
