package com.shuliu.mapper;

import com.shuliu.entity.Books;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author looni
 * @since 2020-05-26
 */
@Component
public interface BooksMapper extends BaseMapper<Books> {
}
