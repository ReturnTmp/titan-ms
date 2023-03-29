package io.github.returntmp.titanms.service;

import io.github.returntmp.titanms.domain.SysLog;

/**
 * isys日志服务
 *
 * @author CGH
 * @date 2023/03/29
 */
public interface ISysLogService {
    public void saveLog(SysLog sysLog);
}
