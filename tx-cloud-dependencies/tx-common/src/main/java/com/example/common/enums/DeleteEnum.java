package com.example.common.enums;

/**
 * 删除状态枚举: 0 正常 1 删除
 *
 * @author xutu
 * @since 2022-06-27
 */
public enum DeleteEnum {
    /**
     * 正常 0
     */
    NORMAL(0, "正常"),
    /**
     * 已删除 1
     */
    DELETED(1, "已删除"),
    ;
    private Integer code;

    private String desc;

    DeleteEnum(Integer code, String desc) {
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
    public static DeleteEnum getEnumByCode(Integer code) {
        if (null != code) {
            for (DeleteEnum e : DeleteEnum.values()) {
                if (code.equals(e.getCode())) {
                    return e;
                }
            }
        }
        return null;
    }


}
