package com.briup.party.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.briup.party.dao")
//告诉映射接口在哪个包下
public class MybatisConfig {

}
