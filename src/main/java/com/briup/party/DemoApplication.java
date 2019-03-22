package com.briup.party;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
// 单个数据大小
		factory.setMaxFileSize("10MB"); // KB,MB
/// 总上传数据大小
		factory.setMaxRequestSize("10MB");
		factory.setFileSizeThreshold(0);
		return factory.createMultipartConfig();
	}
}
