package com.study.build_pattern.builder_pattern.case_analysis;

import lombok.Data;

/**
 * @Author: WangXinWei
 * @Date: 2024-01-17-16:44
 * @Version 1.0
 */
@Data
public class Phone {
    /**
     * cpu
     */
    private String cpu;
    /**
     * 屏幕
     */
    private String screen;
    /**
     * memory
     */
    private String memory;
    /**
     * 主板
     */
    private String mainboard;

    private Phone(Builder builder) {
        this.cpu = builder.cpu;
        this.screen = builder.screen;
        this.memory = builder.memory;
        this.mainboard = builder.mainboard;
    }
    public static final class Builder{
        private String cpu;
        private String screen;
        private String memory;
        private String mainboard;
        public Builder cpu(String cpu){
            this.cpu = cpu;
            return this;
        }
        public Builder screen(String screen){
            this.screen = screen;
            return this;
        }
        public Builder memory(String memory){
            this.memory = memory;
            return this;
        }
        public Builder mainboard(String mainboard){
            this.mainboard = mainboard;
            return this;
        }

        /**
         * 使用构建者创建phone
         * @return
         */
        public Phone build(){
            return new Phone(this);

        }
    }
}
