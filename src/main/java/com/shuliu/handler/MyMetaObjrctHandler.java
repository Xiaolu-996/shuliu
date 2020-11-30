package com.shuliu.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;
/*
		处理器
		1.mybatisplus时间处理器
 */

@Slf4j
@Component  //一定不要忘记把处理器加入IOC容器中
public class MyMetaObjrctHandler implements MetaObjectHandler {
	//插入时填充策略
	@Override
	public void insertFill(MetaObject metaObject) {
		log.info("Start insert fill......");
		//在执行插入时自动将创建时间加入进去
		this.setFieldValByName("gmtModified", new Date(), metaObject);
		this.setFieldValByName("gmtCreat", new Date(), metaObject);
	}

	//更新时的填充策略
	@Override
	public void updateFill(MetaObject metaObject) {
		log.info("update insert fill......");
		this.setFieldValByName("gmtModified", new Date(), metaObject);
	}
}
