package Controller;

import Dao.UserDao;
import Entity.GeneralResponse;
import Entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Clanner on 2016/12/18.
 */
@RequestMapping("/User")
@Controller
public class UserController {

    @ResponseBody
    @RequestMapping(value = "/register")
    public GeneralResponse register(){
        GeneralResponse generalResponse = new GeneralResponse();
        UserDao userDao = new UserDao();
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1);
        userEntity.setUsername("hze");
        userEntity.setAccount("15089837950");
        userEntity.setPassword("123456");
        userEntity.setAvatar("null");
        userEntity.setSex("f");
        if (userDao.addUser(userEntity)){
            generalResponse.setCode(20000);
            generalResponse.setResponse("success");
        }else {
            generalResponse.setCode(40000);
            generalResponse.setResponse("failure");
        }
        return generalResponse;
    }
}
