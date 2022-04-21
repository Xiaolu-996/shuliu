package com.shuliu.mapper;

import com.shuliu.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.catalina.User;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author looni
 * @since 2020-11-30
 */
public interface UsersMapper extends BaseMapper<Users> {
	Users login(Users user);
}
