package com.shuliu.service.impl;

import com.shuliu.entity.Users;
import com.shuliu.mapper.UsersMapper;
import com.shuliu.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author looni
 * @since 2020-11-30
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

	@Resource
	private UsersMapper usersMapper;

	@Override
	public void insert(Users users) {
		baseMapper.insert(users);
	}

	@Override
	public void delete(int id) {
		baseMapper.deleteById(id);
	}

	@Override
	public void update(Users users) {
		baseMapper.updateById(users);
	}

	@Override
	public List<Users> findAll() {
		return baseMapper.selectList(null);
	}

	@Override
	public Users selectByid(int id) {
		return baseMapper.selectById(id);
	}

	@Override
	public Users login(Users user) {
		//接受用户查询数据库
		Users userDB = usersMapper.login(user);
		//查询到这个用户就返回，没有则抛出错误
		if (userDB != null) {
			return userDB;
		} else {
			throw new RuntimeException("登录失败！");
		}
	}
}
