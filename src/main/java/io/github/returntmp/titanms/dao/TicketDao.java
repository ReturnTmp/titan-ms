package io.github.returntmp.titanms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.returntmp.titanms.domain.Ticket;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TicketDao extends BaseMapper<Ticket> {
}
