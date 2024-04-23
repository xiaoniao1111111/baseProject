package com.leyou.feign;

import org.springframework.stereotype.Component;
import com.leyou.pojo.User;

/**
 * Hystrix回调类(FeignAPI接口的实现类)
 *
 * @Author WangXinWei
 * @Date 2022/3/19 19:45
 * @Version 1.0
 */
@Component
public class HystrixImpl implements FeignAPI {

    @Override
    public User getUser(Long id) {
        User user = new User();
        user.setId(999L);
        user.setName("调用出现异常....");
        return user;
    }

    @Override
    public void deleteUser(Long id) {

    }
}
