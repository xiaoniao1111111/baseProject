import com.alibaba.fastjson.JSONObject;
import com.noah.domain.TbUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 练习
 * @Author WangXinWei
 * @Date 2022/3/1 11:40
 * @Version 1.0
 */
public class sqlTest {
    public static void main(String[] args) throws IOException {
        InputStream resource = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resource);
        SqlSession sqlSession = factory.openSession();
        Object o = sqlSession.selectList("TbUserMapper.queryUserById", 1l);
        System.out.println(JSONObject.toJSONString(o));
    }
}
