package com.example.common.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @author xutu
 * @since 2022-06-27
 *
 * 是否状态枚举: 0 否 1 是
 *
 * @author zhaoYoung
 * @since 2019-03-15
 */
public enum YesNoEnum {
    /**
     * 否 0
     */
    NO(0, "否"),
    /**
     * 是 1
     */
    YES(1, "是"),
    ;
    private Integer code;

    private String desc;

    YesNoEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    /***
     * 根据status寻找对应的Enum
     * @param code
     * @return
     */
    public static YesNoEnum getEnumByCode(Integer code) {
        if (null != code) {
            for (YesNoEnum e : YesNoEnum.values()) {
                if (code.equals(e.getCode())) {
                    return e;
                }
            }
        }
        return null;
    }

    /***
     * 根据desc寻找对应的Enum
     * @param desc
     * @return
     */
    public static YesNoEnum getEnumByDesc(String desc) {
        if (StringUtils.isNotBlank(desc)) {
            for (YesNoEnum e : YesNoEnum.values()) {
                if (desc.equals(e.getDesc())) {
                    return e;
                }
            }
        }
        return null;
    }


}
