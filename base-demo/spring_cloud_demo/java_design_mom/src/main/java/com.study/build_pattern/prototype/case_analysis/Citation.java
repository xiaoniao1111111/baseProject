package com.study.build_pattern.prototype.case_analysis;

import lombok.Data;

/**
 * @Author: WangXinWei
 * @Date: 2024-01-17-15:18
 * @Version 1.0
 */
@Data
public class Citation implements Cloneable{
    /**
     * 学生姓名
     */
    private String name;

    @Override
    protected Citation clone() throws CloneNotSupportedException {
        return (Citation)super.clone();
    }

    public void show(){
        System.out.println(name+"同学,在2023学年中表现优秀.特发此状!");
    }

}
