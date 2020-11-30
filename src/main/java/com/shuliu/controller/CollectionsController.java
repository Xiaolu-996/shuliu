package com.shuliu.controller;


import com.shuliu.entity.Collections;
import com.shuliu.service.CollectionsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author looni
 * @since 2020-06-04
 */
@RestController
@RequestMapping("/collections")
public class CollectionsController {
	@Autowired
	CollectionsService collectionService;

	@ApiOperation("收藏书籍bid")
	@PostMapping("/collect/{bid}")
	public void collectBid(@PathVariable int bid) {
		collectionService.insertBid(bid);
	}

	@ApiOperation("获取所有收藏书籍的cid")
	@PostMapping("/getcids")
	public Collection<Collections> selectCid() {
		return collectionService.selectCid();
	}


}

