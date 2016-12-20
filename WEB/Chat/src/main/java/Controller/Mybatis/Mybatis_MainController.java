package Controller.Mybatis;

import org.apache.log4j.chainsaw.Main;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Clanner on 2016/12/6.
 * 类名不可重复
 */
@RequestMapping("/Mybatis//Main")
@Controller
public class Mybatis_MainController {

    private final String URL = "jdbc:mysql://127.0.0.1:3306/chat";
    private final String USER = "root";
    private final String PASSWORD = "";
    private static Connection connection;

    public Mybatis_MainController(){
        System.out.println("初始化Connection");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return connection;
    }
}
