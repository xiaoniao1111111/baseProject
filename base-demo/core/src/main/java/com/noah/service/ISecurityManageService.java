package com.noah.service;

import java.util.List;
import java.util.Map;

/**
 * @Author: WangXinWei
 * @Date: 2020/1/6 17:58
 * @Version 1.0
 */
public interface ISecurityManageService {
    Map<Integer,Integer> getTypeStatusMap(List singletonList);
}
