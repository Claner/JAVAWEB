package Dao;

import Controller.MainController;

import Entity.User;
import Entity.UserInfo;
import MybatisInterface.UserMapper;
import Utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Clanner on 2016/12/6.
 */
public class UserDao {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private SqlSession sqlSession;
    private UserMapper userMapper;

    public UserDao() {
        try {
            sqlSession = MybatisUtil.getSqlSession();
            userMapper = sqlSession.getMapper(UserMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
            sqlSession.close();
        }
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    public boolean register(User user) {
        /**
         * mybatis方式
         */
        if (userMapper == null) {
            userMapper.insertUser(user);
            sqlSession.commit();
            sqlSession.close();
            return true;
        } else {
            return false;
        }

        /**
         * 原生jdbc方式
         */
//        String sql = "INSERT INTO user " + "(username,account,password,sex)" + "VALUES (?,?,?,?)";
//        connection = MainController.getConnection();
//        try {
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, user.getUsername());
//            preparedStatement.setString(2, user.getAccount());
//            preparedStatement.setString(3, user.getPassword());
//            preparedStatement.setString(4, user.getSex());
//            if (preparedStatement.executeUpdate() > 0) return true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
    }

    /**
     * 登陆
     *
     * @param account
     * @param password
     * @return
     */
    public User login(String account, String password) {
        /**
         * mybatis方式
         */
        if (userMapper != null) {
            User user = new User();
            user.setAccount(account);
            user.setPassword(password);
            User resUser = userMapper.login(user);
            resUser.setCode(20000);
            sqlSession.commit();
            sqlSession.close();
            return resUser;
        }
        sqlSession.close();
        return new User(40000);

        /**
         * 原生jdbc方式
         */
//        String sql = "select * from user where account=? and password=?";
//        connection = MainController.getConnection();
//        try {
//            if ("".equals(account) || "".equals(password)) return null;
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, account);
//            preparedStatement.setString(2, password);
//            ResultSet resultSet = preparedStatement.executeQuery(sql);
//            if (resultSet.next()) {
//                User user = new User();
//                user.setCode(20000);
//                user.setUsername(resultSet.getString("username"));
//                user.setId(resultSet.getInt("id"));
//                user.setPassword("");
//                user.setSex(resultSet.getString("sex"));
//                user.setAccount(resultSet.getString("account"));
//                return user;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return new User(40000);
    }

    /**
     * 上传头像
     *
     * @return
     */
    public boolean uploadAvatar() {
        String sql = "";
        return false;
    }

    /**
     * 获取所有用户信息
     *
     * @return
     */
    public List<User> getAllUser() {
        /**
         * mybatis方式
         */
        List<User> userList;
        userList = userMapper.getAllUser();
        return userList;

        /**
         * 原生jdbc方式
         */
//        List<User> userList = new ArrayList<>();
//        String sql = "select * from user";
//        connection = MainController.getConnection();
//        try {
//            preparedStatement = connection.prepareStatement(sql);
//            ResultSet resultSet = preparedStatement.executeQuery(sql);
//            while (resultSet.next()) {
//                User user = new User();
//                user.setUsername(resultSet.getString("username"));
//                user.setPassword("");
//                user.setId(resultSet.getInt("id"));
//                user.setSex(resultSet.getString("sex"));
//                user.setAccount(resultSet.getString("account"));
//                userList.add(user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return userList;
    }

    /**
     * 获取用户id
     * 也可以用来检查账号是否已注册
     *
     * @return
     */
    public Integer getUserID(String account) {
        User user = userMapper.getUserID(account);
        sqlSession.commit();
        sqlSession.close();
        if (user != null) {
            return user.getId();
        } else {
            return null;
        }
    }

    /**
     * 修改密码
     */
    public boolean modifyPassword(int userID, String newPassword) {
        /**
         * mybatis方式
         */
        User user = new User();
        user.setId(userID);
        user.setPassword(newPassword);
        boolean isSuccess = userMapper.modifyPassword(user);
        return isSuccess;

        /**
         * 原生jdbc方式
         */
//        String sql = "update user set password=? where id=?";
//        connection = MainController.getConnection();
//        try {
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, newPassword);
//            preparedStatement.setInt(2, userID);
//            if (preparedStatement.executeUpdate() > 0) return true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
    }

    /**
     * 获取用户信息
     */
    public User getUser(int userID) {
        /**
         * mybatis方式
         */
        User user = userMapper.getUser(userID);
        sqlSession.commit();
        return user;

        /**
         * 原生jdbc方式
         */
//        String sql = "select * from user where id=" + userID;
//        connection = MainController.getConnection();
//        User user = new User();
//        try {
//            preparedStatement = connection.prepareStatement(sql);
//            ResultSet resultSet = preparedStatement.executeQuery(sql);
//            if (resultSet.next()) {
//                user.setCode(20000);
//                user.setId(resultSet.getInt("id"));
//                user.setAccount(resultSet.getString("account"));
//                user.setUsername(resultSet.getString("username"));
//                user.setSex(resultSet.getString("sex"));
//                return user;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
    }

    /**
     * 填写用户信息
     */
    public boolean insertUserInfo(UserInfo userInfo){
        boolean isInsertSuccess = userMapper.insertUserInfo(userInfo);
        sqlSession.commit();
        sqlSession.close();
        return isInsertSuccess;
    }

    /**
     * 获取用户信息
     */
    public UserInfo getUserInfo(int user_id){
        UserInfo userInfo = userMapper.getUserInfo(user_id);
        return userInfo;
    }

    /**
     * 修改用户信息
     */
    public boolean updateUserInfo(UserInfo userInfo){
        boolean isSuccess = userMapper.updateUserInfo(userInfo);
        return isSuccess;
    }
}
