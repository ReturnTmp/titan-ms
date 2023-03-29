package io.github.returntmp.titanms.controller;

import io.github.returntmp.titanms.common.ResponseCode;
import io.github.returntmp.titanms.domain.Ticket;
import io.github.returntmp.titanms.service.OpItemService;
import io.github.returntmp.titanms.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private OpItemService opItemService;
    @PostMapping
    public Result save(@RequestBody Ticket ticket) {
        boolean flag = ticketService.add(ticket);
        String msg = flag ? "":"添加失败，请重试";
        return new Result(flag ? ResponseCode.SAVE_OK: ResponseCode.SAVE_ERR,flag,msg);
    }

    @PutMapping
    public Result update(@RequestBody Ticket ticket) {
        boolean flag = ticketService.update(ticket);
        String msg = flag ? "":"更新失败，请重试";
        return new Result(flag ? ResponseCode.UPDATE_OK: ResponseCode.UPDATE_ERR,flag,msg);
    }

    @PutMapping("/{id}")
    public Result completeOpItem(@PathVariable int id, @RequestBody Ticket ticket){
        //完成某个操作票中的某个操作
        //id:操作票中某个操作项目的序号（1、2...）
        boolean flag = opItemService.updateById(ticket.getOpItem().get(id));
        String msg = flag ? "":"更新失败，请重试";
        return new Result(flag ? ResponseCode.UPDATE_OK: ResponseCode.UPDATE_ERR,flag,msg);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        boolean flag = ticketService.delete(id);
        String msg = flag ? "":"删除失败，请重试";
        return new Result(flag ? ResponseCode.DELETE_OK: ResponseCode.DELETE_ERR,flag,msg);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Long id) {
        Ticket ticket = ticketService.getById(id);
        Integer code = ticket != null ? ResponseCode.GET_OK : ResponseCode.GET_ERR;
        String msg = ticket != null ? "" : "数据查询失败，请重试！";
        return new Result(code,ticket,msg);
    }

    @GetMapping
    public Result getAll() {
        List<Ticket> ticketList = ticketService.getAll();
        Integer code = ticketList != null ? ResponseCode.GET_OK : ResponseCode.GET_ERR;
        String msg = ticketList != null ? "" : "数据查询失败，请重试！";
        return new Result(code,ticketList,msg);
    }
}
