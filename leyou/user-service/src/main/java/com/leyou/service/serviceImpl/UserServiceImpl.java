package com.leyou.service.serviceImpl;

import com.leyou.mapper.UserMapper;
import com.leyou.pojo.User;
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
    private UserMapper userMapper;

    public User queryById(Long id) {
        // 测试熔断的时候做个睡眠
          /*  try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        return this.userMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public void deleteById(Long id) {
        this.userMapper.deleteByPrimaryKey(id);
    }

}
