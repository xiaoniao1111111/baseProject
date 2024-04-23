package com.study.repository;

import com.study.pojo.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @类名称:EsRepository
 * @类描述:
 * @包名:com.study.repository
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-04-18
 * @版本:V1.0.0
 */
public interface EsRepository extends ElasticsearchRepository<Item,Long> {
    List<Item> findByPriceBetween(double v, double v1);
}
