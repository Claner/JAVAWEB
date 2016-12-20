package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Clanner on 2016/12/18.
 */

@RequestMapping("/Main")
@Controller
public class MainController {

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public void test(){
        System.out.println("test");
    }
}
