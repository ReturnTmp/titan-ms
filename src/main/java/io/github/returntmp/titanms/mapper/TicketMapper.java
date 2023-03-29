package io.github.returntmp.titanms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.returntmp.titanms.domain.Ticket;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TicketMapper extends BaseMapper<Ticket> {
}
