package com.yy.business.dao.custom;

import com.yy.business.dao.gen.mapper.ModuleMapper;
import com.yy.business.dao.gen.model.Module;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface CustomModuleMapper extends ModuleMapper {

    @Select({
        "select * from module where strategy_id = #{strategyId,jdbcType=INTEGER} and status=1 order by level"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="strategy_id", property="strategyId", jdbcType=JdbcType.INTEGER),
        @Result(column="module_name", property="moduleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="module_type", property="moduleType", jdbcType=JdbcType.INTEGER),
        @Result(column="module_class", property="moduleClass", jdbcType=JdbcType.VARCHAR),
        @Result(column="module_arg", property="moduleArg", jdbcType=JdbcType.VARCHAR),
        @Result(column="upstream_module_name", property="upstreamModuleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="group_type", property="groupType", jdbcType=JdbcType.INTEGER),
        @Result(column="parallelism", property="parallelism", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    }) List<Module> selectAll(Integer strategyId);

}