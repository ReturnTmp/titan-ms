package io.github.returntmp.titanms;

import io.github.returntmp.titanms.mapper.OpItemMapper;
import io.github.returntmp.titanms.mapper.TicketMapper;
import io.github.returntmp.titanms.domain.Ticket;
import io.github.returntmp.titanms.service.OpItemService;
import io.github.returntmp.titanms.service.TicketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TitanMSApplicationTests {
    @Autowired
    private TicketMapper ticketMapper;
    @Autowired
    private OpItemMapper opItemMapper;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private OpItemService opItemService;
    @Test
    void contextLoads() {
//        LambdaQueryWrapper<Ticket> lqw = new LambdaQueryWrapper<Ticket>();
//        lqw.select(Ticket::getChecker);
//        List<Ticket> list= ticketDao.selectList(lqw);
//        System.out.println(list);

//        Ticket ticket = new Ticket();
//        ticket.setBeginTime(new Date());
//        ticket.setCharge("111");
//        ticket.setChecker("111");
//        ticket.setPost(true);
//        ticketService.add(ticket);

//        OpItem opItem = new OpItem();
//        opItem.setOp(OpTermi.cut);
//        opItem.setCompleteTime(new Date());
//        opItem.setObName("333");
//        opItem.setObType(ObEquip.circuit);
//        opItem.setOpDescription("切断X线路");
//        opItem.setSecureDescription("查确已切断");
//        opItemDao.insert(opItem);

//测试
//        OpItem opItem1 = new OpItem();
//        opItem1.setOp(OpTermi.check);
//        opItem1.setCompleteTime(new Date(2023,03,21 ,05,53,35));
//        opItem1.setObName("222");
//        opItem1.setObType(ObEquip.handle);
//        opItem1.setOpDescription("检查有没有处于X位置");
//        opItem1.setSecureDescription("查确已在就地位置");
//
//        OpItem opItem2 = new OpItem();
//        opItem2.setOp(OpTermi.cut);
//        opItem2.setCompleteTime(new Date());
//        opItem2.setObName("666");
//        opItem2.setObType(ObEquip.circuit);
//        opItem2.setOpDescription("切断X线路");
//        opItem2.setSecureDescription("查确已切断");
//
//        List<OpItem> list = new ArrayList<>();
//        list.add(opItem1);
//        list.add(opItem2);
//
//        Ticket ticket = new Ticket();
////        ticket.setId(1638433883304460289L);
//        ticket.setBeginTime(new Date());
//        ticket.setCharge("222");
//        ticket.setChecker("222");
//        ticket.setPost(false);
//        ticket.setOpItemList(list);
//        ticketService.add(ticket);

//        Long id = 1638427596248281090L;
//        Ticket ticket = ticketDao.selectById(id);
//        String sealed = ticket.getOpItemSealed();
//        List<Long> list = (List<Long>) JSONUtils.parse(sealed);
//        System.out.println(list);
//        for (int i = 0;i<list.size();i++){
//            System.out.println(list.get(i));
//        }
        List<Ticket> list = ticketService.getAll();
        for(int i = 0;i<list.size();i++){
            System.out.println(list.get(i).getId());
        }
    }

}
