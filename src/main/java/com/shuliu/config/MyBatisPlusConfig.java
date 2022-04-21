package com.shuliu.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//扫描mapper文件夹
@MapperScan("com.shuliu.mapper")
@EnableTransactionManagement    //自动管理事务  默认开启
@Configuration      //配置类注解
public class MyBatisPlusConfig {
	//注册乐观锁插件
//	@Bean
//	public OptimisticLockerInterceptor optimisticLockerInterceptor() {
//		return new OptimisticLockerInterceptor();
//	}

	//分页插件(删除默认设置)
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		return new PaginationInterceptor();
	}

	//逻辑删除插件
	@Bean
	public ISqlInjector sqlInjector() {
		return new LogicSqlInjector();
	}


	//性能分析插件
	@Bean
	@Profile({"dev", "test"})// 设置 dev test 环境开启
	public PerformanceInterceptor performanceInterceptor() {
		PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
		//在工作中不允许用户等待
		performanceInterceptor.setMaxTime(100);        //设置sql执行的最大时间,如果超过则不执行
		//开启格式化支持
		performanceInterceptor.setFormat(true);
		return new PerformanceInterceptor();
	}


}
