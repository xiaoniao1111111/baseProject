package com.study.build_pattern.prototype.case_analysis;

/**
 * @Author: WangXinWei
 * @Date: 2024-01-17-15:21
 * @Version 1.0
 */
public class CitationTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Citation citation = new Citation();
        Citation clone = citation.clone();
        citation.setName("张三");
        clone.setName("李四");
        citation.show();
        clone.show();
    }
}
