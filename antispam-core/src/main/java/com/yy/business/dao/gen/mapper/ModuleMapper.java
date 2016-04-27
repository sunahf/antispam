package com.yy.business.dao.gen.mapper;

import com.yy.business.dao.gen.model.Module;
import com.yy.business.dao.gen.model.ModuleExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ModuleMapper {
    @SelectProvider(type=ModuleSqlProvider.class, method="countByExample")
    int countByExample(ModuleExample example);

    @DeleteProvider(type=ModuleSqlProvider.class, method="deleteByExample")
    int deleteByExample(ModuleExample example);

    @Delete({
        "delete from module",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into module (id, strategy_id, ",
        "module_name, module_type, ",
        "module_class, module_arg, ",
        "upstream_module_name, level, ",
        "group_type, parallelism, ",
        "status)",
        "values (#{id,jdbcType=INTEGER}, #{strategyId,jdbcType=INTEGER}, ",
        "#{moduleName,jdbcType=VARCHAR}, #{moduleType,jdbcType=INTEGER}, ",
        "#{moduleClass,jdbcType=VARCHAR}, #{moduleArg,jdbcType=VARCHAR}, ",
        "#{upstreamModuleName,jdbcType=VARCHAR}, #{level,jdbcType=INTEGER}, ",
        "#{groupType,jdbcType=INTEGER}, #{parallelism,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER})"
    })
    int insert(Module record);

    @InsertProvider(type=ModuleSqlProvider.class, method="insertSelective")
    int insertSelective(Module record);

    @SelectProvider(type=ModuleSqlProvider.class, method="selectByExample")
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
    }) List<Module> selectByExample(ModuleExample example);

    @Select({
        "select",
        "id, strategy_id, module_name, module_type, module_class, module_arg, upstream_module_name, ",
        "level, group_type, parallelism, status",
        "from module",
        "where id = #{id,jdbcType=INTEGER}"
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
    })
    Module selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ModuleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Module record, @Param("example") ModuleExample example);

    @UpdateProvider(type=ModuleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Module record, @Param("example") ModuleExample example);

    @UpdateProvider(type=ModuleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Module record);

    @Update({
        "update module",
        "set strategy_id = #{strategyId,jdbcType=INTEGER},",
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
    int updateByPrimaryKey(Module record);
}