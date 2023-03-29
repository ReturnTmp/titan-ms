package io.github.returntmp.titanms.controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用返回类
 *
 * @author ReturnTmp
 * @date 2023/03/29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    /**
     * 状态码
     */
    private int status;
    /**
     * 消息
     */
    private String msg;
    /**
     * 响应码
     */
    private int responseCode;
    /**
     * 数据
     */
    private T data;
}
