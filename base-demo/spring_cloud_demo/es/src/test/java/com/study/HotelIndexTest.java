/*
package com.study;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.PortableInterceptor.RequestInfoOperations;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;


*/
/**
 * @类名称:HotelIndexTest
 * @类描述:
 * @包名:com.study
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-16
 * @版本:V1.0.0
 *//*

public class HotelIndexTest {

    @Autowired
    private ElasticsearchTemplate template;
    private RestHighLevelClient client;

    @Test
    void esTest1() throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(
                HttpHost.create("http://192.168.56.1:9200")
        ));

        // 1.创建request对象
        CreateIndexRequest request = new CreateIndexRequest("hotel");

        // 2.请求参数,Mapping_template 静态常量,内容是创建索引库的DSL语句
        request.source(MAPPING_TE, XContentType.JSON);

        // 3.发起请求
        client.indices().create(request,RequestOptions);

        this.client.close();
    }

}
*/
