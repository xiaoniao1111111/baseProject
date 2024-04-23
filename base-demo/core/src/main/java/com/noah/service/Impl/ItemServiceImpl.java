package com.noah.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.noah.domain.TbItem;
import com.noah.mapper.TbItemMapper;
import com.noah.service.IItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Author: WangXinWei
 * @Date: 2019/7/10 9:43
 * @Version 1.0
 */
@Service
@Slf4j
public class ItemServiceImpl implements IItemService {
    @Autowired
    private TbItemMapper tbItemMapper;

    /**
     * 根据userid获取TbItem
     * @param id
     * @return
     */
    @Override
    public List<TbItem> listItemByUserId(Long id) {
        QueryWrapper<TbItem> tbItemQueryWrapper = new QueryWrapper<>();
        tbItemQueryWrapper.eq("user_id",id);
        List<TbItem> tbItems = tbItemMapper.selectList(tbItemQueryWrapper);
        return CollectionUtils.isEmpty(tbItems)?null:tbItems;
    }
}
