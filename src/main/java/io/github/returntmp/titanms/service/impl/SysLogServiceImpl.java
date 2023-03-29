package io.github.returntmp.titanms.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.returntmp.titanms.mapper.SysLogMapper;
import io.github.returntmp.titanms.domain.SysLog;
import io.github.returntmp.titanms.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper,SysLog> implements SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public void saveLog(SysLog sysLog) {
        sysLog.setLogId(IdUtil.simpleUUID());
        sysLogMapper.insert(sysLog);
    }
}
