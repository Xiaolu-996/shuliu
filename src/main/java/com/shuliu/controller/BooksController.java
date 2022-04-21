package com.shuliu.controller;

import com.shuliu.entity.Books;
import com.shuliu.service.BooksService;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

import java.util.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author looni
 * @since 2020-05-07
 */
@CrossOrigin
@RestController
@RequestMapping("book")
public class BooksController {

	@Resource
	BooksService booksService;

	@ApiOperation("获取所有书籍")
	@GetMapping("/all")
	public List<Books> all() {
		return booksService.findAll();
	}

	@ApiOperation("添加书籍")
	@PostMapping("/add")
	public void add(@RequestBody Books books) {
		booksService.insert(books);
	}


	@ApiOperation("根据BID删除书籍")
	@DeleteMapping("/delete/{bid}")
	public void delete(@PathVariable int bid) {
		booksService.delete(bid);
	}

	@ApiOperation("根据BID查询书籍(查看书籍详情)")
	@GetMapping("/select/{bid}")
	public Books selectById(@PathVariable int bid) {
		return booksService.selectById(bid);
	}


	//搜索功能  根据书名查询
	@ApiOperation("根据书名进行搜索")
	@GetMapping("/search/{bookname}")
	public List<Books> selectBybookname(@PathVariable String bookname) {
		return booksService.selectBybookname(bookname);
	}

	//获取所有收藏书籍
	@ApiOperation("获取所有收藏书籍")
	@GetMapping("/collections")
	public List<Books> selectCollections() {
		return booksService.Collections();
	}


	//更新文章功能
	@ApiOperation("更新文章")
	@PostMapping("/update")
	public void updateBook(@RequestBody Books books) {
		booksService.updateBook(books);
	}


	//文件上传功能
	@ApiOperation("文件上传")
	@PostMapping(value = "/upload")
	public String upload(@RequestParam(value = "file", required = false) MultipartFile file) {
		String a = "https://looni.ink/usr/uploads/" + booksService.upload(file);
		System.out.println(a);
		return a;
	}


}

