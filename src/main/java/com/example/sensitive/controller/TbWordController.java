package com.example.sensitive.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.sensitive.entity.TbWordEntity;
import com.example.sensitive.enumeration.TbWordTypeEnum;
import com.example.sensitive.service.SensitiveWordService;
import com.example.sensitive.service.TbWordService;
import com.github.houbb.sensitive.word.bs.SensitiveWordBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * (TbWord)控制层
 *
 * @author WenBin
 * @date 2022/07/26
 */

@RestController
@RequestMapping("tb_word")
public class TbWordController {

    @Autowired
    private TbWordService tbWordService;

    @Autowired
    private SensitiveWordService sensitiveWordService;

    @Autowired
    private SensitiveWordBs sensitiveWordBs;

    /**
     * 敏感词校验
     *
     * @param words 需要校验的单词
     * @return String
     */
    @GetMapping
    private String checkSensitiveWords(@RequestParam String words) {
        boolean contains = sensitiveWordBs.contains(words);
        if (contains) {
            List<String> wordList = sensitiveWordBs.findAll(words);
            return "包含敏感词:" + wordList;
        }
        return "未包含敏感词";
    }

    /**
     * 新增敏感词库
     *
     * @param tbWordEntity 实体类
     * @return Boolean
     * @throws Exception Exception
     */
    @PostMapping
    private Boolean add(@RequestBody TbWordEntity tbWordEntity) throws Exception {
        if (tbWordEntity == null || tbWordEntity.getWord() == null || tbWordEntity.getType() == null
            || !TbWordTypeEnum.containType(tbWordEntity.getType())) {
            throw new Exception("请求参数异常");
        }
        QueryWrapper<TbWordEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(TbWordEntity::getWord, tbWordEntity.getWord());
        // 简单demo，生成环境不要这样校验，会存在并发问题，使用乐观锁去控制（例如增加版本号字段）
        TbWordEntity wordEntity = tbWordService.getOne(queryWrapper);
        if (wordEntity != null && wordEntity.getType().equals(tbWordEntity.getType())) {
            throw new Exception("该词汇已存在");
        }
        tbWordEntity.setCreateTime(new Date());
        tbWordEntity.setUpdateTime(new Date());
        boolean save = tbWordService.save(tbWordEntity);
        if (save) {
            // 每次更新数据后自动初始化异常敏感词
            sensitiveWordService.refresh();
            return true;
        }
        return false;
    }


    /**
     * 开放接口主动刷新，初始化敏感词工具
     *
     * @return Boolean
     */
    @PostMapping("refresh")
    private Boolean refresh() {
        sensitiveWordService.refresh();
        return true;
    }

}

