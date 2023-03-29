package io.github.returntmp.titanms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.returntmp.titanms.domain.Warning;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WarningDao extends BaseMapper<Warning> {
}
