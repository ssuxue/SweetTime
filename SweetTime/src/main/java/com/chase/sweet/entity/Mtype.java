package com.chase.sweet.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author chase
 * @since 2020-07-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value = "m_type")
public class Mtype implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer id;

    private String name;


}
