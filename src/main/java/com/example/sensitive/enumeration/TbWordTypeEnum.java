package com.example.sensitive.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * (TbWord)敏感词类型枚举类
 *
 * @author WenBin
 * @date 2022/07/26
 */
@Getter
@AllArgsConstructor
public enum TbWordTypeEnum {

    /**
     * 敏感词
     */
    SENSITIVE_WORD(1,"敏感词"),

    /**
     * 非敏感词
     */
    NOT_SENSITIVE_WORD(2,"非敏感词");

    private final Integer type;

    private final String describe;

    public static boolean containType(int type) {
        TbWordTypeEnum[] values = TbWordTypeEnum.values();
        return Arrays.stream(values).anyMatch(value -> value.getType().equals(type));
    }

}
