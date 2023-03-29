package io.github.returntmp.titanms.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.returntmp.titanms.annotation.Operation;
import io.github.returntmp.titanms.domain.SysLog;
import io.github.returntmp.titanms.mapper.TicketMapper;
import io.github.returntmp.titanms.domain.OpItem;
import io.github.returntmp.titanms.domain.Ticket;
import io.github.returntmp.titanms.service.OpItemService;
import io.github.returntmp.titanms.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImpl extends ServiceImpl<TicketMapper, Ticket> implements TicketService {

    @Autowired
    private TicketMapper ticketMapper;
    @Autowired
    private OpItemService opItemService;

    @Operation(value = "添加操作票")
    @Override
    public boolean add(Ticket ticket) {

        List<OpItem> list = ticket.getOpItemList();
        List<Integer> listInteger = new ArrayList<>();
        ticket.setOpItem(listInteger);
        for (int i = 0; i < list.size(); i++) {
            opItemService.add(list.get(i));
            ticket.getOpItem().add(list.get(i).getId());
        }
        ticket.setOpItemSealed(JSONUtils.toJSONString(ticket.getOpItem()));
        return ticketMapper.insert(ticket) > 0;
    }

    @Operation(value = "删除操作票")
    @Override
    public boolean delete(Long id) {
        Ticket ticket = ticketMapper.selectById(id);
        String sealed = ticket.getOpItemSealed();
        List<Integer> list = (List<Integer>) JSONUtils.parse(sealed);
        ticket.setOpItem(list);
        for (int i = 0; i < list.size(); i++) {
            opItemService.delete(list.get(i));
        }
        return ticketMapper.deleteById(id) > 0;
    }

    @Operation(value = "更新操作票")
    @Override
    public boolean update(Ticket ticket) {
        List<OpItem> list = ticket.getOpItemList();
        for (int i = 0; i < list.size(); i++) {
            opItemService.update(list.get(i));
        }
        return ticketMapper.updateById(ticket) > 0;
    }

    @Operation(value = "查询单个操作票")
    @Override
    public Ticket getById(Long id) {
        Ticket ticket = ticketMapper.selectById(id);
        String sealed = ticket.getOpItemSealed();
        List<Integer> list = (List<Integer>) JSONUtils.parse(sealed);
        ticket.setOpItem(list);
        List<OpItem> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            list1.add(opItemService.getById(list.get(i)));
        }
        ticket.setOpItemList(list1);
        return ticket;
    }

    @Operation(value = "查询所有操作票")
    @Override
    public List<Ticket> getAll() {
        List<Ticket> list = ticketMapper.selectList(null);
        for (int i = 0; i < list.size(); i++) {
            String sealed = list.get(i).getOpItemSealed();
            List<Integer> list1 = (List<Integer>) JSONUtils.parse(sealed);
            list.get(i).setOpItem(list1);
            List<OpItem> list2 = new ArrayList<>();
            for (int j = 0; j < list1.size(); j++) {
                list2.add(opItemService.getById(list1.get(j)));
            }
            list.get(i).setOpItemList(list2);
        }
        return list;
    }
}
