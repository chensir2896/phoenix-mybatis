package com.phoenix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class PhoenixApplication {

    public static void main(String[] args) {
        /*
        先进入phoenix 的bin目录下执行./sqlline.py
        先创建表
        create table if not exists person(ID INTEGER NOT NULL PRIMARY KEY,NAME VARCHAR(20),AGE INTEGER, SEX varchar(10));
        执行 !table来确认
         */
        SpringApplication.run(PhoenixApplication.class, args);
    }

}
