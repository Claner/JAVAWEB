package Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by Clanner on 2016/12/10.
 */
public class MybatisUtil {
    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession() throws IOException {
        //通过配置文件获取数据库连接信息
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        //通过配置信息构建一个sqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        if (sqlSessionFactory != null) {
            return SingleSqlSession.sqlSession;
        } else {
            return null;
        }
    }

    private static final class SingleSqlSession {
        //通过sqlSessionFactory打开一个数据库会话
        private static final SqlSession sqlSession = sqlSessionFactory.openSession();
    }
}
