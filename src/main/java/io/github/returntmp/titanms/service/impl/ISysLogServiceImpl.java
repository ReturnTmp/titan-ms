package io.github.returntmp.titanms.service.impl;

import cn.hutool.core.util.IdUtil;
import io.github.returntmp.titanms.dao.SysLogDao;
import io.github.returntmp.titanms.domain.SysLog;
import io.github.returntmp.titanms.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ISysLogServiceImpl implements ISysLogService {

    @Autowired
    private SysLogDao sysLogDao;

    @Override
    public void saveLog(SysLog sysLog) {
        sysLog.setLogId(IdUtil.simpleUUID());
        sysLogDao.insert(sysLog);
    }
}
