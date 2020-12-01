package com.shuliu.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JWTUtils {

	private static final String SING = "LUJIANBIN@TOKEN";


	/**
	 * 生成令牌
	 *
	 * @param map payload载荷声明参数
	 * @return
	 */
	public static String getToken(Map<String, String> map) {
		//获取日历对象
		Calendar calendar = Calendar.getInstance();
		//默认7天过期
		calendar.add(Calendar.DATE, 7);
		//新建一个JWT的Builder对象
		JWTCreator.Builder builder = JWT.create();
		//将map集合中的数据设置进payload
		map.forEach((k, v) -> {
			builder.withClaim(k, v);
		});
		//设置过期时间和签名
		String sign = builder.withExpiresAt(calendar.getTime()).sign(Algorithm.HMAC256(SING));

		return sign;
	}

	/**
	 * 验签并返回DecodedJWT
	 *
	 * @param token 令牌
	 */
	public static DecodedJWT getTokenInfo(String token) {
		return JWT.require(Algorithm.HMAC256(SING)).build().verify(token);
	}


}
