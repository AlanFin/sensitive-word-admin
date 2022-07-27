package com.example.sensitive.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sensitive.entity.TbWordEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * (TbWord)数据库访问层
 *
 * @author WenBin
 * @date 2022/07/26
 */
@Mapper
public interface TbWordDao extends BaseMapper<TbWordEntity> {

}

