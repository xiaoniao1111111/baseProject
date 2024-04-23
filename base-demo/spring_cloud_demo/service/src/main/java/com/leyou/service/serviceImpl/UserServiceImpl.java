package com.leyou.service.serviceImpl;

import com.leyou.mapper.TbUserMapper;
import com.leyou.pojo.TbUser;
import com.leyou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author WangXinWei
 * @Date 2022/3/15 20:41
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TbUserMapper userMapper;

    @Override
    public TbUser queryById(Long id) {
        // 测试熔断的时候做个睡眠
          /*  try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        TbUser tbUser1 = new TbUser();
        tbUser1.setId(id);
        return this.userMapper.selectOne(tbUser1);
    }

    @Transactional()
    @Override
    public void deleteById(Long id) {
        this.userMapper.deleteByPrimaryKey(id);
    }
}
