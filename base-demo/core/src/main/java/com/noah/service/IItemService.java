package com.noah.service;

import com.noah.domain.TbItem;

import java.util.List;

/**
 * @Author: WangXinWei
 * @Date: 2019/7/10 9:43
 * @Version 1.0
 */
public interface IItemService {
    /**
     * 根据userid获取TbItem
     * @param id
     * @return
     */
    List<TbItem> listItemByUserId(Long id);
}
