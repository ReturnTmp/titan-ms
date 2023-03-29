package io.github.returntmp.titanms.service.impl;

import io.github.returntmp.titanms.dao.WarningDao;
import io.github.returntmp.titanms.domain.Warning;
import io.github.returntmp.titanms.service.WarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;

@Service
public class WarningServiceImpl implements WarningService {
    @Autowired
    private WarningDao warningDao;

    @Override
    public boolean add(Warning warning) {
        return warningDao.insert(warning) > 0;
    }

}
