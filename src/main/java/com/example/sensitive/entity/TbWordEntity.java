package com.example.sensitive.entity;

import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * (TbWord)实体类
 *
 * @author WenBin
 * @date 2022/07/26
 */
@Getter
@Setter
@ToString
@TableName(value = "tb_word")
public class TbWordEntity implements Serializable {

    private static final long serialVersionUID = 876984352022163743L;
    
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    
    /**
     * 单词
     */
    private String word;
    
    /**
     * 类型 1-禁止 2-放行
     */
    private Integer type;

    
    /**
     * 创建时间
     */
    private Date createTime;
    
    /**
     * 更新时间
     */
    private Date updateTime;
    
}

    
