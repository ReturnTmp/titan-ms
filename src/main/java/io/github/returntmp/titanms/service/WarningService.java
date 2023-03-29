package io.github.returntmp.titanms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.returntmp.titanms.domain.Warning;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface WarningService extends IService<Warning> {
    public boolean add(Warning warning);
}
