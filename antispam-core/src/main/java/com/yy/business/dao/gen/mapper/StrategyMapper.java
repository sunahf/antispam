package com.yy.business.dao.gen.mapper;

import com.yy.business.dao.gen.model.Strategy;
import com.yy.business.dao.gen.model.StrategyExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface StrategyMapper {
    @SelectProvider(type=StrategySqlProvider.class, method="countByExample")
    int countByExample(StrategyExample example);

    @DeleteProvider(type=StrategySqlProvider.class, method="deleteByExample")
    int deleteByExample(StrategyExample example);

    @Delete({
        "delete from strategy",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into strategy (id, app_id, ",
        "strategy_name, max_task_parallelism)",
        "values (#{id,jdbcType=INTEGER}, #{appId,jdbcType=INTEGER}, ",
        "#{strategyName,jdbcType=VARCHAR}, #{maxTaskParallelism,jdbcType=INTEGER})"
    })
    int insert(Strategy record);

    @InsertProvider(type=StrategySqlProvider.class, method="insertSelective")
    int insertSelective(Strategy record);

    @SelectProvider(type=StrategySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.INTEGER),
        @Result(column="strategy_name", property="strategyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="max_task_parallelism", property="maxTaskParallelism", jdbcType=JdbcType.INTEGER)
    }) List<Strategy> selectByExample(StrategyExample example);

    @Select({
        "select",
        "id, app_id, strategy_name, max_task_parallelism",
        "from strategy",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.INTEGER),
        @Result(column="strategy_name", property="strategyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="max_task_parallelism", property="maxTaskParallelism", jdbcType=JdbcType.INTEGER)
    })
    Strategy selectByPrimaryKey(Integer id);

    @UpdateProvider(type=StrategySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Strategy record, @Param("example") StrategyExample example);

    @UpdateProvider(type=StrategySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Strategy record, @Param("example") StrategyExample example);

    @UpdateProvider(type=StrategySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Strategy record);

    @Update({
        "update strategy",
        "set app_id = #{appId,jdbcType=INTEGER},",
          "strategy_name = #{strategyName,jdbcType=VARCHAR},",
          "max_task_parallelism = #{maxTaskParallelism,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Strategy record);
}