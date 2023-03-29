package io.github.returntmp.titanms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.returntmp.titanms.domain.OpItem;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface OpItemService extends IService<OpItem> {
    public boolean add(OpItem opItem);

    public boolean delete(int id);

    public boolean update(OpItem opItem);

    public boolean updateById(int id);

    public OpItem getById(int id);

    public List<OpItem> getAll();
}
