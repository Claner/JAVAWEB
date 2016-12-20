package Dao;

import Entity.UserEntity;
import Utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;

/**
 * Created by Clanner on 2016/12/18.
 */
public class UserDao {

    /**
     * 添加用户
     * @return
     */
    public boolean addUser(UserEntity userEntity){
        Session session = HibernateUtil.getSession();
        try {
            session.save(userEntity);
            HibernateUtil.commit();
        }catch (ConstraintViolationException e){
            return false;
        }
        return true;
    }

    /**
     * 获取用户
     */
    public UserEntity getUser(){
        return null;
    }
}
