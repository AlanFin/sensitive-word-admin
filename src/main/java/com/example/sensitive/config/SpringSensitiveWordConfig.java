package com.example.sensitive.config;

import com.example.sensitive.service.impl.MyWordAllowImpl;
import com.example.sensitive.service.impl.MyWordDenyImpl;
import com.github.houbb.sensitive.word.bs.SensitiveWordBs;
import com.github.houbb.sensitive.word.support.allow.WordAllows;
import com.github.houbb.sensitive.word.support.deny.WordDenys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author WenBin
 * @date 2022/07/26
 */
@Configuration
public class SpringSensitiveWordConfig {

    @Autowired
    private MyWordAllowImpl myDdWordAllow;

    @Autowired
    private MyWordDenyImpl myDdWordDeny;

    /**
     * 初始化引导类
     *
     * @return 初始化引导类
     * @since 1.0.0
     */
    @Bean
    public SensitiveWordBs sensitiveWordBs() {
        return SensitiveWordBs.newInstance()
            .wordDeny(WordDenys.chains(WordDenys.system(), myDdWordDeny))
            .wordAllow(WordAllows.chains(WordAllows.system(), myDdWordAllow))
            // 各种其他配置
            .init();
    }

}