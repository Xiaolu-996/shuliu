package com.shuliu.mapper;

import com.shuliu.entity.Collections;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author looni
 * @since 2020-06-04
 */
@Component
public interface CollectionsMapper extends BaseMapper<Collections> {
	@Insert("insert into collections(cid) values (#{bid})")
	void insertBid(int bid);
}
