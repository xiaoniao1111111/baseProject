package com.leyou.mapper;

import com.leyou.pojo.User;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author WangXinWei
 * @Date 2022/3/15 20:43
 * @Version 1.0
 */
public interface UserMapper extends Mapper<User> {
    User selectByPrimaryKey(Long id);

    void deleteByPrimaryKey(Long id);
}
