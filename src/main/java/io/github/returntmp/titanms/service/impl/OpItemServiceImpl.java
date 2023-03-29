package io.github.returntmp.titanms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.returntmp.titanms.annotation.Operation;
import io.github.returntmp.titanms.mapper.OpItemMapper;
import io.github.returntmp.titanms.domain.OpItem;
import io.github.returntmp.titanms.service.OpItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OpItemServiceImpl extends ServiceImpl<OpItemMapper,OpItem> implements OpItemService {
    @Autowired
    private OpItemMapper opItemMapper;

    @Override
    public boolean add(OpItem opItem) {
        return opItemMapper.insert(opItem) > 0;
    }

    @Override
    public boolean delete(int id) {
        return opItemMapper.deleteById(id) > 0;
    }

    @Override
    public boolean update(OpItem opItem) {
        return opItemMapper.updateById(opItem) > 0;
    }
    @Operation(value = "完成操作项目")
    @Override
    public boolean updateById(int id){
        LambdaQueryWrapper<OpItem> lqw = new LambdaQueryWrapper<OpItem>();
        lqw.eq(OpItem::getId,id);
        OpItem opItem = new OpItem();
        opItem.setCompleteTime(new Date());
        return opItemMapper.update(opItem,lqw) > 0;
    }
    @Override
    public OpItem getById(int id) {
        return opItemMapper.selectById(id);
    }

    @Override
    public List<OpItem> getAll() {
        return opItemMapper.selectList(null);
    }
}
