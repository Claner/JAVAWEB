package Controller;

import org.apache.log4j.chainsaw.Main;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Clanner on 2016/12/6.
 */
@RequestMapping("/Main")
@Controller
public class MainController {

    private final String URL = "jdbc:mysql://127.0.0.1:3306/chat";
    private final String USER = "root";
    private final String PASSWORD = "";
    private static Connection connection;

    public MainController(){
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
