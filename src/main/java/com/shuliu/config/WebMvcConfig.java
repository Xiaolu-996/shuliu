package com.shuliu.config;

import com.shuliu.interceptors.JWTInterceptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.beans.factory.annotation.Value;

@ConfigurationProperties(prefix = "interceptorconfig")
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	/**
	 * 图片保存路径，自动从yml文件中获取数据
	 * 示例： E:/images/
	 */
	@Value("${file-save-path}")
	private String fileSavePath;

	/**
	 * 配置资源映射
	 * 意思是：如果访问的资源路径是以“/imagess/”开头的，
	 * 就给我映射到本机的“E:/images/”这个文件夹内，去找你要的资源
	 * 注意：E:/images/ 后面的 “/”一定要带上
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**")
				.addResourceLocations("file:" + fileSavePath);
	}

/*
	//配置jwt
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new JWTInterceptor())
				.addPathPatterns("/**")         //统一拦截所有请求
				.excludePathPatterns("excludePathPatterns");
	}*/
}
