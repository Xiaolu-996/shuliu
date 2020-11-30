package com.shuliu.service.impl;

import com.shuliu.entity.Collections;
import com.shuliu.mapper.CollectionsMapper;
import com.shuliu.service.CollectionsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author looni
 * @since 2020-06-04
 */
@Service
public class CollectionsServiceImpl extends ServiceImpl<CollectionsMapper, Collections> implements CollectionsService {
	@Autowired
	CollectionsMapper collectionsMapper;

	@Override
	public void insertBid(int bid) {
		collectionsMapper.insertBid(bid);
	}

	@Override
	public List<Collections> selectCid() {
		return collectionsMapper.selectList(null);
	}


}
