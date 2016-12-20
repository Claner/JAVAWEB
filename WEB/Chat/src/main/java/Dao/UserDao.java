package Dao;

import Entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by Clanner on 2016/12/18.
 */
public class UserDao {

    private Configuration configuration = null;
    private ServiceRegistry serviceRegistry = null;
    private SessionFactory sessionFactory = null;
    private Session session = null;
    private Transaction transaction = null;

    /**
     * 添加用户
     * @return
     */
    public boolean addUser(UserEntity userEntity){
        configuration = new Configuration().configure();
        System.out.println(configuration);
        return false;
    }
}
