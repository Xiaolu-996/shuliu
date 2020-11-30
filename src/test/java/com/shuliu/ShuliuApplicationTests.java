package com.shuliu;

import com.shuliu.entity.Books;
//import com.shuliu.entity.Collection;
import com.shuliu.mapper.BooksMapper;
import com.shuliu.service.BooksService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShuliuApplicationTests {

	@Autowired
	private BooksMapper booksMapper;
	private BooksService booksService;

	//查询全部书籍
	@Test
	void selectList() {
		booksMapper.selectList(null);
	}


	//增加书籍
	@Test
	void insert() {
		Books books = new Books();
		books.setCategory("种类");
		books.setDescription("描述");
		books.setImage("图片链接");
		books.setCurrentPrice(50);
		books.setName("我服了");
		int result = booksMapper.insert(books);
		System.out.println(result);
		System.out.println(books);
	}

	//测试删除
	@Test
	void delete() {
		booksMapper.deleteById(4);
	}


}
