package io.github.returntmp.titanms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.returntmp.titanms.domain.SysLog;
import io.github.returntmp.titanms.mapper.SysLogMapper;
import io.github.returntmp.titanms.mapper.WarningMapper;
import io.github.returntmp.titanms.domain.Warning;
import io.github.returntmp.titanms.service.WarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarningServiceImpl extends ServiceImpl<WarningMapper, Warning> implements WarningService {
    @Autowired
    private WarningMapper warningMapper;

    @Override
    public boolean add(Warning warning) {
        return warningMapper.insert(warning) > 0;
    }

}
