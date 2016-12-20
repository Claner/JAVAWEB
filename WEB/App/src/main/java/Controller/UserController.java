package Controller;

import Dao.UserDao;
import Entity.GeneralResponse;
import Entity.UserEntity;
import Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Clanner on 2016/12/18.
 */
@Controller
@RequestMapping("/User")
public class UserController {

    @ResponseBody
    @RequestMapping(value = "/test")
    public GeneralResponse test() {
        UserService userService = new UserService();
        return userService.test();
    }

    /**
     * 注册
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public GeneralResponse register(@RequestParam("account") String account,
                                    @RequestParam("username") String username,
                                    @RequestParam("password") String password,
                                    @RequestParam("sex") String sex) {
        GeneralResponse response = new GeneralResponse();
        if ("".equals(account)||"".equals(username)||"".equals(password)||"".equals(sex)){
            response.setCode(40000);
            response.setResponse("content can not be empty");
            return response;
        }
        UserDao userDao = new UserDao();
        UserEntity userEntity = new UserEntity();
        userEntity.setSex(sex);
        userEntity.setPassword(password);
        userEntity.setAvatar("null");
        userEntity.setUsername(username);
        userEntity.setAccount(account);
        if (userDao.addUser(userEntity)) {
            response.setCode(20000);
            response.setResponse("success");
        } else {
            response.setCode(40000);
            response.setResponse("this account had exist");
        }
        return response;
    }
}
