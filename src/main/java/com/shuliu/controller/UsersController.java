package com.shuliu.controller;


import com.shuliu.entity.Books;
import com.shuliu.entity.Users;
import com.shuliu.service.UsersService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author looni
 * @since 2020-11-30
 */
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UsersController {
	@Resource
	UsersService usersService;

	/**
	 * 查询所有用户
	 */
	@ApiOperation("获取所有用户")
	@GetMapping("/findAll")
	public Map<String, Object> findAll(Integer page, Integer rows) {
		Map<String, Object> map = new HashMap<>();
		List<Users> results = usersService.findAll();
		map.put("total", 10);
		map.put("totalPage", 1);
		map.put("page", page);
		map.put("results", results);
		return map;
	}


	/**
	 * 添加用户
	 */
	@ApiOperation("添加用户接口")
	@PostMapping("/add")
	public Map<String, Object> add(@RequestBody Users users) {
		HashMap<String, Object> map = new HashMap<>();
		try {
			usersService.save(users);
			map.put("success", true);
			map.put("msg", "添加用户成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("msg", "添加用户失败");
		}
		return map;
	}

	/*
	 * 删除用户
	 * */
	@ApiOperation("删除用户")
	@GetMapping("/delete")
	public Map<String, Object> delete(int id) {
		HashMap<String, Object> map = new HashMap<>();
		try {
			usersService.delete(id);
			map.put("success", true);
			map.put("msg", "删除用户成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("msg", "删除用户失败");
		}
		return map;
	}


	/**
	 * 查询一个用户
	 */
	@ApiOperation("查询一个用户")
	@GetMapping("/findOne")
	public Users findOne(int id) {
		return usersService.selectByid(id);
	}


	/*
	 * 修改一个用户*/
	@ApiOperation("修改用户信息")
	@PostMapping("/update")
	public Map<String, Object> update(@RequestBody Users users) {
		HashMap<String, Object> map = new HashMap<>();
		try {
			usersService.update(users);
			map.put("success", true);
			map.put("msg", "更新用户信息成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("msg", "更新用户信息失败");
		}
		return map;
	}
}

