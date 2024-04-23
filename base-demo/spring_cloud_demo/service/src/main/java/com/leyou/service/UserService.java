package com.leyou.service;

import com.leyou.pojo.TbUser;

/**
 * @Author WangXinWei
 * @Date 2022/3/15 20:41
 * @Version 1.0
 */
public interface UserService {
    TbUser queryById(Long id);

    void deleteById(Long id);

}
