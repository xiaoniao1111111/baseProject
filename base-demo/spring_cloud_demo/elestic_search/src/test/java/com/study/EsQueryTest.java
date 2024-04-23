package com.study;

import com.study.pojo.Item;
import com.study.repository.EsRepository;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.aggregations.metrics.avg.InternalAvg;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @类名称:EsQueryTest
 * @类描述:
 * @包名:com.study
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-04-18
 * @版本:V1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EsApplication.class)
public class EsQueryTest {
    @Autowired
    private ElasticsearchTemplate template;
    @Autowired
    private EsRepository esRepository;

    /**
     * 查询所有并排序
     */
    @Test
    public void findAll() {
        Iterable<Item> iterable = esRepository.findAll(Sort.by("price").descending());
        iterable.forEach(action -> {
            System.out.println(action);
        });
    }

    /**
     * 自定义查询条件查询
     */
    @Test
    public void diyQuery() {
        // 1.原生的查询条件的构建对象
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 查询标题中包含华为手机的数据
        queryBuilder.withQuery(QueryBuilders.matchQuery("title", "华为"));

        // 分页的查询结果
        Page<Item> search = esRepository.search(queryBuilder.build());
        List<Item> content = search.getContent();
        System.out.println(content);
    }

    @Test
    public void indexListAdd() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(1L, "小米手机7", "手机", "小米", 3299.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(2L, "坚果手机R1", "手机", "锤子", 3699.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(3L, "华为META10", "手机", "华为", 4499.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(4L, "小米Mix2S", "手机", "小米", 4299.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(5L, "荣耀V10", "手机", "华为", 2799.00, "http://image.leyou.com/13123.jpg"));
        // 接收对象集合，实现批量新增
        esRepository.saveAll(list);
    }

    /**
     * 查询价格在2000到3500的数据
     */
    @Test
    public void queryByPriceBetween() {
        List<Item> items = esRepository.findByPriceBetween(2000.00, 3500.00);
        System.out.println(items);
    }

    /**
     * 分页
     */
    @Test
    public void queryPage() {
        // 原生的查询条件构建对象
        NativeSearchQueryBuilder searchQueryBuilder = new NativeSearchQueryBuilder();
        // 添加条件
        searchQueryBuilder.withQuery(QueryBuilders.matchQuery("title", "华为"));
        // 分页处理  页数是从0开始,0是第一页,  起始条数是: (当前页-1) * 页数
        searchQueryBuilder.withPageable(PageRequest.of(0, 2));
        // 查询
        Page<Item> search = esRepository.search(searchQueryBuilder.build());
        List<Item> content = search.getContent();
        System.out.println(content);
    }

    /**
     * 排序
     */
    @Test
    public void querySort() {
        NativeSearchQueryBuilder searchQueryBuilder = new NativeSearchQueryBuilder();
        // 添加条件
        searchQueryBuilder.withQuery(QueryBuilders.matchQuery("title", "华为"));
        // 价格降序排序
        searchQueryBuilder.withSort(SortBuilders.fieldSort("price").order(SortOrder.DESC));
        esRepository.search(searchQueryBuilder.build());
    }

    /**
     * 聚合
     */
    @Test
    public void queryAggs() {
        // 原生条件构建对象
        NativeSearchQueryBuilder searchQueryBuilder = new NativeSearchQueryBuilder();
        // 添加聚合条件
        searchQueryBuilder.addAggregation(AggregationBuilders.terms("pin-pai").field("brand"));
        // 聚合完成后,获取聚合后的分页数据
        AggregatedPage<Item> search = (AggregatedPage<Item>) esRepository.search(searchQueryBuilder.build());
        // 根据桶名称获取聚合结果
        StringTerms aggregation = (StringTerms) search.getAggregation("pin-pai");
        // 获取所有的桶信息
        List<StringTerms.Bucket> buckets = aggregation.getBuckets();
        // 遍历桶,获取内容
        for (StringTerms.Bucket bucket : buckets) {
            // 获取key
            String key = (String) bucket.getKey();
            // 获取value
            long docCount = bucket.getDocCount();
            System.out.println("当前key: " + key + "有: " + docCount + " 个");
        }
    }

    /**
     * 嵌套聚合求平均
     */
    @Test
    public void queryAggsInside() {
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        queryBuilder.addAggregation(AggregationBuilders.terms("pin-pai").field("brand")
                // 桶内分组
                .subAggregation(AggregationBuilders.avg("avg-price").field("price")));
        AggregatedPage<Item> search = (AggregatedPage<Item>) esRepository.search(queryBuilder.build());
        StringTerms aggregations = (StringTerms) search.getAggregation("pin-pai");
        List<StringTerms.Bucket> buckets = aggregations.getBuckets();
        for (StringTerms.Bucket bucket : buckets) {
            // 获取key
            String key = (String) bucket.getKey();
            // 获取value
            long docCount = bucket.getDocCount();
            // 获取平均值
            InternalAvg internalAvg = (InternalAvg) bucket.getAggregations().asMap().get("avg-price");
            System.out.println("当前key: " + key + "有: " + docCount + " 个,平均值为: " + internalAvg.getValue());
        }
    }
}
