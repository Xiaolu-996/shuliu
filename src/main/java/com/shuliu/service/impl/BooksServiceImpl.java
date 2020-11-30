package com.shuliu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shuliu.entity.Books;
import com.shuliu.entity.Collections;
import com.shuliu.mapper.BooksMapper;
import com.shuliu.service.BooksService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shuliu.service.CollectionsService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author looni vvb
 * @since 2020-05-26
 */
@Service
public class BooksServiceImpl extends ServiceImpl<BooksMapper, Books> implements BooksService {
	@Resource
	CollectionsService collectionsService;
	//上传文件路径
	@Value("${file-save-path}")
	String filePath;


	@Override
	public List<Books> selectList() {
		return baseMapper.selectList(null);
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
