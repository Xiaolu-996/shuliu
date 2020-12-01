package com.shuliu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author looni
 * @since 2020-11-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Users对象", description = "")
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	private String name;

	private Integer age;

	private Integer password;

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GTM+8")  /*规定日期格式*/
	/*次数应该用Date属性的，开始写时没注意时间给日期用了string类型*/
	private String bir;

}
