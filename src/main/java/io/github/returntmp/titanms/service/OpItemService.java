package io.github.returntmp.titanms.service;

import io.github.returntmp.titanms.domain.OpItem;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface OpItemService {
    //增
    public boolean add(OpItem opItem);

    //删
    public boolean delete(int id);

    //改
    public boolean update(OpItem opItem);

    public boolean updateById(int id);

    //查
    public OpItem getById(int id);

    public List<OpItem> getAll();
}
