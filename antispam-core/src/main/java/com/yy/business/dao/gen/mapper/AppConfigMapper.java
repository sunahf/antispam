package com.yy.business.dao.gen.mapper;

import com.yy.business.dao.gen.model.AppConfig;
import com.yy.business.dao.gen.model.AppConfigExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface AppConfigMapper {
    @SelectProvider(type=AppConfigSqlProvider.class, method="countByExample")
    int countByExample(AppConfigExample example);

    @DeleteProvider(type=AppConfigSqlProvider.class, method="deleteByExample")
    int deleteByExample(AppConfigExample example);

    @Delete({
        "delete from app_config",
        "where appid = #{appid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer appid);

    @Insert({
        "insert into app_config (appid, app_name, ",
        "max_task_parallelism)",
        "values (#{appid,jdbcType=INTEGER}, #{appName,jdbcType=VARCHAR}, ",
        "#{maxTaskParallelism,jdbcType=INTEGER})"
    })
    int insert(AppConfig record);

    @InsertProvider(type=AppConfigSqlProvider.class, method="insertSelective")
    int insertSelective(AppConfig record);

    @SelectProvider(type=AppConfigSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="appid", property="appid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="app_name", property="appName", jdbcType=JdbcType.VARCHAR),
        @Result(column="max_task_parallelism", property="maxTaskParallelism", jdbcType=JdbcType.INTEGER)
    }) List<AppConfig> selectByExample(AppConfigExample example);

    @Select({
        "select",
        "appid, app_name, max_task_parallelism",
        "from app_config",
        "where appid = #{appid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="appid", property="appid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="app_name", property="appName", jdbcType=JdbcType.VARCHAR),
        @Result(column="max_task_parallelism", property="maxTaskParallelism", jdbcType=JdbcType.INTEGER)
    }) AppConfig selectByPrimaryKey(Integer appid);

    @UpdateProvider(type=AppConfigSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AppConfig record, @Param("example") AppConfigExample example);

    @UpdateProvider(type=AppConfigSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AppConfig record, @Param("example") AppConfigExample example);

    @UpdateProvider(type=AppConfigSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AppConfig record);

    @Update({
        "update app_config",
        "set app_name = #{appName,jdbcType=VARCHAR},",
          "max_task_parallelism = #{maxTaskParallelism,jdbcType=INTEGER}",
        "where appid = #{appid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AppConfig record);
}