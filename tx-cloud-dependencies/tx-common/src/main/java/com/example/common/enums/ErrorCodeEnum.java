package com.example.common.enums;

/**
 * 通用错误码定义
 *
 * @author xutu
 * @since 2022-06-27
 */
public enum ErrorCodeEnum implements ExceptionEnum {

    /**
     * 请求成功
     */
    SUCCESS("200", "success"),
    /**
     * 请求错误
     */
    REQUEST_ERROR("400", "request error"),
    /**
     * 请求认证错误
     */
    REQUEST_AUTH_ERROR("401", "request auth error"),
    /**
     * 拒绝请求
     */
    REQUEST_FORBIDDEN("403", "request forbidden"),
    /**
     * 服务未找到
     */
    REQUEST_SERVICE_NOT_FOUND("404", "service not found"),
    /**
     * 路径不存在
     */
    NO_HANDLER_FOUND("404", "no handler found"),
    /**
     * 请求方式错误
     */
    REQUEST_METHOD_NOT_SUPPORTED("405", "request method not supported"),
    /**
     * 请求参数错误
     */
    REQUEST_PARAM_ERROR("460", "request parameter error"),

    /**
     * 其他错误(未捕获)
     */
    OTHER_ERROR("470", "other error"),
    /**
     * 服务端错误
     */
    SERVER_ERROR("500", "server error"),
    /**
     * 服务不可用
     */
    SERVER_NOT_AVAILABLE("503", "server not available"),





    /**
     * 鉴权
     */
    TOKEN_NOT_EXISTS("600","你的账号在另一地点登录，已被迫下线。"),

    TOKEN_VERIFY("601","凭证认证失败"),

    ACCOUNT_NO_PERMISSION("602","账号无此操作权限"),

    ACCOUNT_NOT_EXISTS("603","账号或密码错误"),

    PASSWORD_ERROR("604","密码错误"),

    ACCOUNT_ENABLE_LOCKING("605","账号被锁定或未启用"),

    LOGOUT_ERROR("606","退出登录失败，请重试"),

    OLD_PASSWORD_ERROR("607","旧密码错误"),

    ACCOUNT_NO_RECEPTION_PERMISSION("608","该账号无后台管理权限"),

    LOGIN_ERROR("609","登录失败"),

    VERIFY_CAPTCHA_ERROR("610","图形验证码错误"),

    VERIFY_CAPTCHA_INVALID("611","图形验证码已失效"),

    ACCOUNT_IS_DELETE("612","账号异常，请重新登录！"),

    ACCOUNT_NOT_BINDING_ORG("613","账号未绑定机构"),

    TOKEN_EXPIRE_TIME("614","账号身份已过期，请重新登录。"),

    USER_PERMISSION_IS_CHANGE("615","您的账号权限已变更，需重新登录。"),

    ACCOUNT_NOT_IN_VISIT_LIMIT("616","访问不在授权范围内。"),

    ACCOUNT_DOES_NOT_HAVE_THIS_APPLICATION("617","账号无此应用权限"),

    ACCOUNT_NOT_REVIEW("617","登录失败，账号未审核"),

    ACCOUNT_EXISTS("618","账号已存在"),

    IDCARD_EXISTS("619","身份证号已存在"),

    PHONE_EXISTS("620","手机号已存在"),

    STAFF_USER_ACCOUNT_NOT_BINDING_MINI_PROGRAM("621","该账号未绑定微信小程序，请退出小程序重进进行授权"),

    ROLE_NOT_EXIST("622","该账户绑定角色不存在，请联系管理员"),

    ROLE_ENABLE_LOCKING("623","该账户绑定角色被锁定或未启用"),

    MINI_PROGRAM_NOT_BINDING_STAFF_USER_ACCOUNT("624","该微信小程序账号未绑定平台账号，请退出小程序重进进行绑定"),

    ORG_LOGIN_ERROR("625","您的账户未绑定项目，请联系管理员后再试"),

    APP_SEND_SMS_ERROR("626","号码未授权，请联系管理员"),

    APP_LOGIN_SMS_IN_ERROR_1("627","未获取验证码或验证码已失效，请重新获取验证码"),

    APP_LOGIN_SMS_IN_ERROR_2("628","验证码错误，请仔细核实验证码"),

    DATA_NOT_FOUND("650","数据不存在"),


    DATA_EXISTS("651","数据已存在"),

    /**
     * 操作失败
     */
    OPERATION_FAIL("700","操作失败，请重试"),

    SEND_SMS_FAIL("701","发送短信失败，请稍后再试"),

    SEND_SMS_COUNT_MAX("702","今日短信发送次数已满，请24小时后再次发送"),

    SMS_CODE_EXPIRE_TIME("703","短信验证码已过期"),

    SMS_CODE_ERROR("704","短信验证码错误"),


    GET_MINI_PROGRAM_OPEN_ID_FAIL("705","微信小程序登录授权失败，请重新进入小程序"),

    SIGN_IN_ERROR("706","您当天已签到，不可重复签到"),

    ORDER_SEND_OUT_ERROR("707","只可操作待发货状态的订单"),

    QUERY_EXPRESS_DETAIL_ERROR("708","该订单还未发货，请发货后在来查询快递信息"),

    INSERT_COURSEWARE_CATALOGUE_ERROR("709","不可在已绑定课件节点下新增"),

    DELETE_COURSEWARE_CATALOGUE_ERROR_CHILDREN("710","不可删除已有子节点的目录"),

    DELETE_COURSEWARE_CATALOGUE_ERROR_BINDING("711","不可删除已绑定课件的目录"),

    DELETE_VIDEO_QUESTION_ERROR("712","不可删除被课件绑定的视频题目"),

    DELETE_QUESTION_ERROR("713","不可删除被试卷绑定的题目"),

    DELETE_EXAM_PAPER_ERROR("714","不可删除被项目绑定的试卷"),

    START_EXAM_ERROR_STATUS("715","当前已有正在考试的试卷，不可重新开始"),

    START_EXAM_ERROR_COUNT("716","已达到最大考试数，不可考该试卷"),

    START_EXAM_ERROR_PASS("717","该试卷您已通过，不可重复再考"),

    GET_EXAM_QUESTION_ERROR("718","该试卷已完成，不可在考"),

    /**
     * 文本校验
     */
    PHONE_FORMAT_ERROR("800","手机号格式错误"),

    ID_CARD_FORMAT_ERROR("801","身份证号格式错误"),

    PASSWORD_FORMAT_ERROR("802","密码格式错误"),

    REAL_NAME_FORMAT_ERROR("803","姓名格式错误"),

    ACCOUNT_FORMAT_ERROR("804","账号格式错误"),


    /**
     * 自定义错误
     */
    CUSTOM_ERROR("999", "自定义错误"),

    ;

    ErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 异常编码
     */
    private String code;
    /**
     * 异常消息
     */
    private String message;

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}
