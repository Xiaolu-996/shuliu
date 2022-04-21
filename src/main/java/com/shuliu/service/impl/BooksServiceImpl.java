package com.shuliu.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.shuliu.entity.Books;
import com.shuliu.entity.Collections;
import com.shuliu.mapper.BooksMapper;
import com.shuliu.service.BooksService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shuliu.service.CollectionsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author looni vvb
 * @since 2020-05-26
 */
@Slf4j //日志输出
@Service
public class BooksServiceImpl extends ServiceImpl<BooksMapper, Books> implements BooksService {
	@Resource
	CollectionsService collectionsService;

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	//上传文件路径
	@Value("${file-save-path}")
	String filePath;

	@Override
	public List<Books> findAll() {
		//增加缓存
		//先去缓存查找，如果缓存有 直接返回 如果缓存没有 从数据库查询 放入缓存
		String userListJsonStr = redisTemplate.opsForValue().get("BookService.findAll");

		//userListJsonStr若不为空，则直接走缓存
		if (StringUtils.isNotEmpty(userListJsonStr)) {
			List<Books> books = JSON.parseArray(userListJsonStr, Books.class);
			//	System.out.println(books);
			log.info("走了缓存~~~~~~~~");
			return books;
		} else {
			List<Books> books = baseMapper.selectList(null);
			//放入缓存
			redisTemplate.opsForValue().set("BookService.findAll", JSON.toJSONString(books), 2, TimeUnit.HOURS);
			log.info("放入缓存~~~~~~~~");
			return books;
		}
	}

	@Override
	public void insert(Books books) {
		baseMapper.insert(books);
	}

	@Override
	public void delete(int bid) {
		baseMapper.deleteById(bid);
	}

	@Override
	public Books selectById(int bid) {
		return baseMapper.selectById(bid);
	}

	@Override
	public List<Books> selectBybookname(String bookname) {
		QueryWrapper<Books> wrapper = new QueryWrapper<>();
		wrapper
				.like("name", bookname);
		return baseMapper.selectList(wrapper);
	}


	@Override
	public List<Books> Collections() {
		List<Collections> cidCollection = collectionsService.selectCid();

		List<Books> cbooks = new ArrayList<Books>();
		for (int i = 0; i < cidCollection.size(); i++) {
			Books books = (Books) baseMapper.selectById(cidCollection.get(i).getCid());
			cbooks.add(books);
		}
		return cbooks;
	}

	@Override
	public void updateBook(Books books) {
		baseMapper.updateById(books);
	}


	@Override
	public String upload(MultipartFile file) {
		if (file.isEmpty()) {
			return "文件为空";
		}
		//当前时间戳
		String OriginalFilename = file.getOriginalFilename();
		//修改文件名
		String fileName = System.currentTimeMillis() + "." + OriginalFilename.substring(OriginalFilename.lastIndexOf(".") + 1);
		System.out.println(fileName);
		//文件路径
		File dest = new File(filePath + fileName);
		if (!dest.getParentFile().exists())
			dest.getParentFile().mkdirs();
		try {
			//利用transferTo语句进行拷贝
			file.transferTo(dest);
		} catch (Exception e) {
			e.printStackTrace();
			return "上传失败";
		}
		return fileName;
	}


}
