package com.example.sensitive.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.sensitive.dao.TbWordDao;
import com.example.sensitive.entity.TbWordEntity;
import com.example.sensitive.enumeration.TbWordTypeEnum;
import com.github.houbb.sensitive.word.api.IWordDeny;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author WenBin
 * @date 2022/07/26
 */
@Service
public class MyWordDenyImpl implements IWordDeny {

    @Autowired
    private TbWordDao tbWordDao;

    @Override
    public List<String> deny() {
        QueryWrapper<TbWordEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(TbWordEntity::getType, TbWordTypeEnum.SENSITIVE_WORD.getType());
        List<TbWordEntity> tbWordEntities = tbWordDao.selectList(queryWrapper);
        return tbWordEntities.stream().map(TbWordEntity::getWord).collect(Collectors.toList());
    }

}