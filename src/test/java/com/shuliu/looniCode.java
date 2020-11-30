package com.shuliu;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

// 代码自动生成器
public class looniCode {
	public static void main(String[] args) {
// 需要构建一个 代码自动生成器 对象
		AutoGenerator mpg = new AutoGenerator();
// 配置策略

// 1、全局配置
		GlobalConfig gc = new GlobalConfig();
		String projectPath = System.getProperty("user.dir");

		gc.setOutputDir(projectPath + "/src/main/java");
		gc.setAuthor("looni");
		gc.setOpen(false);                  // 是否打开windows资源管理器
		gc.setFileOverride(false);          // 是否覆盖
		gc.setServiceName("%sService");     // 去Service的I前缀
		gc.setIdType(IdType.AUTO);          // 主键策略
		gc.setDateType(DateType.ONLY_DATE); // 日期格式
		gc.setSwagger2(true);               //  是否配置swagger文档

		mpg.setGlobalConfig(gc);

//2、设置数据源
		DataSourceConfig dsc = new DataSourceConfig();

		dsc.setUrl("jdbc:mysql://localhost:3306/shuliu?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8");
		dsc.setDriverName("com.mysql.cj.jdbc.Driver");
		dsc.setUsername("root");
		dsc.setPassword("981028");
		dsc.setDbType(DbType.MYSQL);         //MySql驱动

		mpg.setDataSource(dsc);

//3、包的配置
		PackageConfig pc = new PackageConfig();

		pc.setParent("com.shuliu");
		pc.setEntity("entity");
		pc.setMapper("mapper");
		pc.setService("service");
		pc.setController("controller");

		mpg.setPackageInfo(pc);

//4、策略配置
		StrategyConfig strategy = new StrategyConfig();

		strategy.setInclude("books", "collections", "users");                    // 设置要映射的表名,可设置多个表
		strategy.setNaming(NamingStrategy.underline_to_camel);              //下划线转驼峰命名
		strategy.setColumnNaming(NamingStrategy.underline_to_camel);        //下划线转驼峰命名
		strategy.setEntityLombokModel(true);                // 自动lombok；
		strategy.setLogicDeleteFieldName("deleted");        // 逻辑删除

		//自动填充配置
		TableFill gmtCreate = new TableFill("gmt_creat", FieldFill.INSERT);
		TableFill gmtModified = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);
		ArrayList<TableFill> tableFills = new ArrayList<>();
		tableFills.add(gmtCreate);
		tableFills.add(gmtModified);
		strategy.setTableFillList(tableFills);


		// 乐观锁
		//strategy.setVersionFieldName("version");


		strategy.setRestControllerStyle(true);              //开启restful驼峰命名
		strategy.setControllerMappingHyphenStyle(true);     //localhost:8080/hello_id_2(开启下划线命名)
		mpg.setStrategy(strategy);
		mpg.execute(); //执行
	}
}