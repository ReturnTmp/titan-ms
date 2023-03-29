package io.github.returntmp.titanms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.returntmp.titanms.domain.Ticket;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface TicketService  extends IService<Ticket> {
    public boolean add(Ticket ticket);

    public boolean delete(Long id);

    public boolean update(Ticket ticket);

    public Ticket getById(Long id);

    public List<Ticket> getAll();

}
