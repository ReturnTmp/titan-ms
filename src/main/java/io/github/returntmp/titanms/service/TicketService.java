package io.github.returntmp.titanms.service;

import io.github.returntmp.titanms.domain.Ticket;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface TicketService {
    //增
    public boolean add(Ticket ticket);

    //删
    public boolean delete(Long id);

    //改
    public boolean update(Ticket ticket);

    //查
    public Ticket getById(Long id);

    public List<Ticket> getAll();

}
