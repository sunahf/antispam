package com.yy.business.dao.gen.mapper;

import com.yy.business.dao.gen.model.AppModule;
import com.yy.business.dao.gen.model.AppModuleExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface AppModuleMapper {
    @SelectProvider(type=AppModuleSqlProvider.class, method="countByExample")
    int countByExample(AppModuleExample example);

    @DeleteProvider(type=AppModuleSqlProvider.class, method="deleteByExample")
    int deleteByExample(AppModuleExample example);

    @Delete({
        "delete from app_module",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into app_module (id, app_id, ",
        "module_name, module_type, ",
        "module_class, module_arg, ",
        "upstream_module_name, level, ",
        "group_type, parallelism, ",
        "status)",
        "values (#{id,jdbcType=INTEGER}, #{appId,jdbcType=INTEGER}, ",
        "#{moduleName,jdbcType=VARCHAR}, #{moduleType,jdbcType=INTEGER}, ",
        "#{moduleClass,jdbcType=VARCHAR}, #{moduleArg,jdbcType=VARCHAR}, ",
        "#{upstreamModuleName,jdbcType=VARCHAR}, #{level,jdbcType=INTEGER}, ",
        "#{groupType,jdbcType=INTEGER}, #{parallelism,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER})"
    })
    int insert(AppModule record);

    @InsertProvider(type=AppModuleSqlProvider.class, method="insertSelective")
    int insertSelective(AppModule record);

    @SelectProvider(type=AppModuleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.INTEGER),
        @Result(column="module_name", property="moduleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="module_type", property="moduleType", jdbcType=JdbcType.INTEGER),
        @Result(column="module_class", property="moduleClass", jdbcType=JdbcType.VARCHAR),
        @Result(column="module_arg", property="moduleArg", jdbcType=JdbcType.VARCHAR),
        @Result(column="upstream_module_name", property="upstreamModuleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="group_type", property="groupType", jdbcType=JdbcType.INTEGER),
        @Result(column="parallelism", property="parallelism", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    }) List<AppModule> selectByExample(AppModuleExample example);

    @Select({
        "select",
        "id, app_id, module_name, module_type, module_class, module_arg, upstream_module_name, ",
        "level, group_type, parallelism, status",
        "from app_module",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.INTEGER),
        @Result(column="module_name", property="moduleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="module_type", property="moduleType", jdbcType=JdbcType.INTEGER),
        @Result(column="module_class", property="moduleClass", jdbcType=JdbcType.VARCHAR),
        @Result(column="module_arg", property="moduleArg", jdbcType=JdbcType.VARCHAR),
        @Result(column="upstream_module_name", property="upstreamModuleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="group_type", property="groupType", jdbcType=JdbcType.INTEGER),
        @Result(column="parallelism", property="parallelism", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    }) AppModule selectByPrimaryKey(Integer id);

    @UpdateProvider(type=AppModuleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AppModule record, @Param("example") AppModuleExample example);

    @UpdateProvider(type=AppModuleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AppModule record, @Param("example") AppModuleExample example);

    @UpdateProvider(type=AppModuleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AppModule record);

    @Update({
        "update app_module",
        "set app_id = #{appId,jdbcType=INTEGER},",
          "module_name = #{moduleName,jdbcType=VARCHAR},",
          "module_type = #{moduleType,jdbcType=INTEGER},",
          "module_class = #{moduleClass,jdbcType=VARCHAR},",
          "module_arg = #{moduleArg,jdbcType=VARCHAR},",
          "upstream_module_name = #{upstreamModuleName,jdbcType=VARCHAR},",
          "level = #{level,jdbcType=INTEGER},",
          "group_type = #{groupType,jdbcType=INTEGER},",
          "parallelism = #{parallelism,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AppModule record);
}