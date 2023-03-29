package io.github.returntmp.titanms.service;

import io.github.returntmp.titanms.domain.Warning;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface WarningService {
    public boolean add(Warning warning);
}
