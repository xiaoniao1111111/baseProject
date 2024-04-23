package mytabisplus;

import com.study.MybatisPlusApplication;
import com.study.domain.TbUser;
import com.study.mapper.TbUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @类名称:MybatisPlus
 * @类描述:
 * @包名:mytabisplus
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-19
 * @版本:V1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisPlusApplication.class)
@Slf4j
public class MybatisPlus {
    @Autowired
    private TbUserMapper userMapper;

    @Test
    public void insertTest() {
        TbUser tbUser = new TbUser();
        tbUser.setUserName("李四");
        tbUser.setAddress("中国");
        int insert = userMapper.insert(tbUser);
        System.out.println(insert);

    }
}
