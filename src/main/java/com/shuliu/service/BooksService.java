package com.shuliu.service;

import com.shuliu.entity.Books;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 * z
 *
 * @author looni
 * @since 2020-05-26
 */
public interface BooksService extends IService<Books> {
	//查询所有书籍
	List<Books> findAll();

	//添加书籍
	void insert(Books books);

	//刪除书籍
	void delete(int bid);

	//根据ID查询数据
	Books selectById(int bid);

	//搜索功能(根据书名查询）
	List<Books> selectBybookname(String bookname);

	//查询收藏书籍
	List<Books> Collections();

	//更新书籍(先根据ID查询将书籍信息预存到界面)
	void updateBook(Books books);

	//上传文件
	String upload(MultipartFile file);


}
