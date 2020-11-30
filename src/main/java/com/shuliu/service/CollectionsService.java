package com.shuliu.service;

import com.shuliu.entity.Collections;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author looni
 * @since 2020-06-04
 */
public interface CollectionsService extends IService<Collections> {
	//将获取的书籍Id存入收藏表
	void insertBid(int bid);

	//获取所有的cid返回一个集合
	List<Collections> selectCid();
}
