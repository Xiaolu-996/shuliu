package com.shuliu.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@Configuration
public class AbcSpringBootUpFileApplication {
	public static void main(String[] args) {
		SpringApplication.run(AbcSpringBootUpFileApplication.class, args);
	}

	/**
	 * 对上传文件的配置
	 *
	 * @return MultipartConfigElement配置实例
	 * @date 2018年6月29日 上午10:55:02
	 */
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		// 设置单个附件大小上限值(默认为1M)
		//选择字符串作为参数的话，单位可以用MB、KB;
		factory.setMaxFileSize(DataSize.parse("50MB"));
		// 设置所有附件的总大小上限值
		factory.setMaxRequestSize(DataSize.parse("250MB"));
		return factory.createMultipartConfig();
	}
}
