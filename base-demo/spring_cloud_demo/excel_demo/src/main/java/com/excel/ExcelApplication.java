package com.excel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ComponentScan({
        "com.excel.**.controller",
        "com.excel.**.service"
})
@MapperScan("com.excel.**.mapper")
public class ExcelApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExcelApplication.class,args);
    }
}
