package com.study.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @类名称:Item
 * @类描述:
 * @包名:com.study.pojo
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-04-17
 * @版本:V1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// indexName: 索引库名称    type: 索引库的类型    shards: 分片数量  replicas: 副本数量
@Document(indexName = "item",type = "docs", shards = 1, replicas = 0)
public class Item {
    @Id
    Long id;

    // type: 属性类型(text-文本)  analyzer: 分词器(最小细分)
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String title; //标题

    @Field(type = FieldType.Keyword)
    private String category;// 分类

    @Field(type = FieldType.Keyword)
    private String brand; // 品牌

    @Field(type = FieldType.Double)
    private Double price; // 价格

    @Field(index = false, type = FieldType.Keyword)
    private String images; // 图片地址
}
