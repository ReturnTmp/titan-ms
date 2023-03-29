package io.github.returntmp.titanms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.github.returntmp.titanms.annotation.Operation;
import io.github.returntmp.titanms.dao.OpItemDao;
import io.github.returntmp.titanms.domain.OpItem;
import io.github.returntmp.titanms.service.OpItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OpItemServiceImpl implements OpItemService {
    @Autowired
    private OpItemDao opItemDao;

    @Override
    public boolean add(OpItem opItem) {
        return opItemDao.insert(opItem) > 0;
    }

    @Override
    public boolean delete(int id) {
        return opItemDao.deleteById(id) > 0;
    }

    @Override
    public boolean update(OpItem opItem) {
        return opItemDao.updateById(opItem) > 0;
    }
    @Operation(value = "完成操作项目")
    @Override
    public boolean updateById(int id){
        LambdaQueryWrapper<OpItem> lqw = new LambdaQueryWrapper<OpItem>();
        lqw.eq(OpItem::getId,id);
        OpItem opItem = new OpItem();
        opItem.setCompleteTime(new Date());
        return opItemDao.update(opItem,lqw) > 0;
    }
    @Override
    public OpItem getById(int id) {
        return opItemDao.selectById(id);
    }

    @Override
    public List<OpItem> getAll() {
        return opItemDao.selectList(null);
    }
}
