package com.example.common.enums;

/**
 * @author xutu
 * @since 2022-06-27
 * 性别：1-男，2-女，0-未知
 */
public enum SexEnum {

    /**
     * 男
     */
    MALE(1, "男"),

    FEMALE(2, "女"),

    UN_KNOW(0, "未知"),

    ;


    private Integer code;

    private String desc;

    SexEnum(int value, String desc) {
        this.code = value;
        this.desc = desc;
    }

    /**
     * 获得枚举
     */
    public static SexEnum getEnumByCode(Integer code) {
        if (null != code) {
            for (SexEnum e : SexEnum.values()) {
                if (code.equals(e.getCode())) {
                    return e;
                }
            }
        }
        return null;
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
}
