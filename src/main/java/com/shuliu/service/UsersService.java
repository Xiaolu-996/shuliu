package com.shuliu.service;

import com.shuliu.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.ListResourceBundle;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author looni
 * @since 2020-11-30
 */
public interface UsersService extends IService<Users> {

	/*添加数据*/
	void insert(Users users);

	/*删除数据*/
	void delete(int id);

	/*更新数据*/
	void update(Users users);

	/*查询所有数据*/
	List<Users> findAll();

	/*查询一个数据*/
	Users selectByid(int id);

	/*登录 判断用户名密码是否正确*/
	Users login(Users user);
}
