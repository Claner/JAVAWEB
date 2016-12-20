package Controller.Mybatis;

import Dao.Mybatis.UserDao;
import Entity.Mybatis.*;
import Utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

/**
 * Created by Clanner on 2016/12/6.
 */
@RequestMapping("/Mybatis/User")
@Controller
public class Mybatis_UserController {

    private UserDao userDao;
    private boolean isSuccess;
    private GeneralResponse response;
    private ObjResponse objResponse;
    private ObjListResponse objListResponse;

    public Mybatis_UserController() {
        userDao = new UserDao();
    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public GeneralResponse register(@RequestParam(value = "username", required = true) String username,
                                    @RequestParam(value = "account", required = true) String account,
                                    @RequestParam(value = "password", required = true) String password,
                                    @RequestParam(value = "sex", required = true) String sex) {
        response = new GeneralResponse();
        if ("".equals(username) || "".equals(password) || "".equals(account) || "".equals(sex)) {
            response.setCode(40000);
            response.setResponse("content can not empty");
            return response;
        }
        if (userDao.getUserID(account) != null) {
            response.setCode(40000);
            response.setResponse("this account has been register");
            return response;
        }
        isSuccess = userDao.register(new User(username, account, password, sex));
        if (isSuccess) {
            response.setCode(20000);
            response.setResponse("add user success");
        } else {
            response.setCode(40000);
            response.setResponse("add user failure");
        }
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ObjResponse login(@RequestParam("account") String account,
                             @RequestParam("password") String password) {
        objResponse = new ObjResponse();
        User user = userDao.login(account, password);
        if (user != null) {
            if (user.getCode() == 20000) {
                objResponse.setCode(user.getCode());
                objResponse.setResponse(user);
            } else {
                objResponse.setCode(user.getCode());
                objResponse.setResponse("login failure username or password not match");
            }
        } else {
            objResponse.setCode(40000);
            objResponse.setResponse("content can not be empty");
        }
        return objResponse;
    }

    @ResponseBody
    @RequestMapping(value = "/uploadAvatar", method = RequestMethod.POST)
    public GeneralResponse uploadAvatar(@RequestParam("uploadFile") MultipartFile file) {
        response = new GeneralResponse();
        System.out.println("testUpload");
        System.out.println("文件的原始名字" + file.getOriginalFilename());
        try {
            System.out.println("文件的输入流" + file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.setCode(20000);
        response.setResponse("upload avatar success");
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    public ObjListResponse getAllUser() {
        objListResponse = new ObjListResponse();
        List<User> userList = userDao.getAllUser();
        List<Object> objectList = new ArrayList<>();
        objListResponse.setCode(20000);
        if (userList != null && userList.size() > 0) {
            for (int i = 0; i < userList.size(); i++) {
                objectList.add(userList.get(i));
            }
            objListResponse.setResponse(objectList);
        } else {
            objListResponse.setCode(40000);
            objListResponse.getResponse();
        }
        return objListResponse;
    }

    @ResponseBody
    @RequestMapping(value = "/modifyPassword", method = RequestMethod.POST)
    public GeneralResponse modifyPassword(@RequestParam("userID") String userID,
                                          @RequestParam("newPassword") String newPassword) {
        response = new GeneralResponse();
        if (userDao.modifyPassword(Integer.parseInt(userID), newPassword)) {
            response.setCode(20000);
            response.setResponse("modify password success");
        } else {
            response.setCode(40000);
            response.setResponse("modify password failure");
        }
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    public ObjResponse getUser(@RequestParam("userID") String userID) {
        objResponse = new ObjResponse();
        User user = userDao.getUser(Integer.parseInt(userID));
        if (user != null) {
            objResponse.setCode(user.getCode());
            objResponse.setResponse(user);
        } else {
            objResponse.setCode(40000);
            objResponse.setResponse("get user info failure");
        }
        return objResponse;
    }

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public GeneralResponse test() {
        response = new GeneralResponse();
        System.out.println("获取sqlSessionFactory");
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sqlSession.getConfiguration());
        response.setCode(20000);
        response.setResponse(sqlSession.toString());
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/forgetPassword", method = RequestMethod.POST)
    public GeneralResponse forgetPassword(@RequestParam("account") String account) {
        response = new GeneralResponse();
        Integer id = userDao.getUserID(account);
        if (id != null) {
            System.out.println(id);
            response.setCode(20000);
            response.setResponse(String.valueOf(id));
        } else {
            response.setCode(40000);
            response.setResponse("get user id failure");
        }
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/addUserInfo", method = RequestMethod.POST)
    public GeneralResponse addUserInfo(@RequestParam("user_id") Integer user_id,
                                       @RequestParam("address") String address,
                                       @RequestParam("personal_sign") String personal_sign) {
        response = new GeneralResponse();
        UserInfo userInfo = new UserInfo(user_id,address,personal_sign);
        boolean isSuccess = userDao.insertUserInfo(userInfo);
        if (isSuccess){
            response.setCode(20000);
            response.setResponse("add user info success");
        }else {
            response.setCode(40000);
            response.setResponse("add user info failure");
        }
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/getUserInfo" ,method = RequestMethod.POST)
    public ObjResponse getUserInfo(@RequestParam("user_id") Integer user_id){
        objResponse = new ObjResponse();
        UserInfo userInfo = userDao.getUserInfo(user_id);
        if (userInfo != null){
            objResponse.setCode(20000);
            objResponse.setResponse(userInfo);
        }else{
            objResponse.setCode(40000);
            objResponse.setResponse("user do not exists");
        }
        return objResponse;
    }

    @ResponseBody
    @RequestMapping(value = "/updateUserInfo",method = RequestMethod.POST)
    public GeneralResponse updateUserInfo(@RequestParam("user_id") Integer user_id,
                                          @RequestParam("address") String address,
                                          @RequestParam("personal_sign") String personal_sign){
        UserInfo userInfo = new UserInfo(user_id,address,personal_sign);
        boolean isSuccess = userDao.updateUserInfo(userInfo);
        response = new GeneralResponse();
        if (isSuccess){
            response.setCode(20000);
            response.setResponse("update user info success");
        }else {
            response.setCode(40000);
            response.setResponse("update user info failure");
        }
        return response;
    }
}
