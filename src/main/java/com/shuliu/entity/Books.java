package com.shuliu.entity;

import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

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
 * @since 2020-05-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Books对象", description = "")
public class Books implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty("商品ID")
	@TableId(value = "bid", type = IdType.AUTO)
	private Integer bid;

	@ApiModelProperty("商品名称")
	private String name;

	@ApiModelProperty("当前价格")
	private Integer currentPrice;

	@ApiModelProperty("商品描述")
	private String description;

	@ApiModelProperty("商品图片")
	private String image;

	@ApiModelProperty("商品种类")
	private String category;

	@ApiModelProperty(value = "创建时间")
	@TableField(fill = FieldFill.INSERT)
	private Date gmtCreat;

	@ApiModelProperty(value = "修改时间")
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date gmtModified;

	@ApiModelProperty(value = "逻辑删除")
	@TableLogic
	private Integer deleted;


}
