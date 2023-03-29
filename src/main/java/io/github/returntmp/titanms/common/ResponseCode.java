package io.github.returntmp.titanms.common;

/**
 * 返回状态码
 *
 * @author ReturnTmp
 * @date 2023/03/29
 */
public class ResponseCode {
    public static final Integer SAVE_OK = 20011;
    public static final Integer DELETE_OK = 20021;
    public static final Integer UPDATE_OK = 20031;
    public static final Integer GET_OK = 20041;

    public static final Integer SAVE_ERR = 20010;
    public static final Integer DELETE_ERR = 20020;
    public static final Integer UPDATE_ERR = 20030;
    public static final Integer GET_ERR = 20040;

    public static final Integer LOGIN_OK = 20051;
    public static final Integer LOGOUT_OK = 20061;

    public static final Integer LOGIN_ERR = 20050;
    public static final Integer LOGOUT_ERR = 20060;

    public static final Integer PARAM_ERR = 40001;
    public static final Integer PARAM_TIMEOUT_ERR = 40002;
    public static final Integer PARAM_UNKNOW_ERR = 49999;

    public static final Integer AUTH_ERR = 40101;
    public static final Integer AUTH_TIMEOUT_ERR = 40102;
    public static final Integer AUTH_UNKNOW_ERR = 49999;

    public static final Integer SYSTEM_ERR = 50001;
    public static final Integer SYSTEM_TIMEOUT_ERR = 50002;
    public static final Integer SYSTEM_UNKNOW_ERR = 59999;

    public static final Integer BUSINESS_ERR = 60002;

}
