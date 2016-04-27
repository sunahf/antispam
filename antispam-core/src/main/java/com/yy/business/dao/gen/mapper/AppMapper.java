package com.yy.business.dao.gen.mapper;

import com.yy.business.dao.gen.model.App;
import com.yy.business.dao.gen.model.AppExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface AppMapper {
    @SelectProvider(type=AppSqlProvider.class, method="countByExample")
    int countByExample(AppExample example);

    @DeleteProvider(type=AppSqlProvider.class, method="deleteByExample")
    int deleteByExample(AppExample example);

    @Delete({
        "delete from app",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into app (id, name)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR})"
    })
    int insert(App record);

    @InsertProvider(type=AppSqlProvider.class, method="insertSelective")
    int insertSelective(App record);

    @SelectProvider(type=AppSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    }) List<App> selectByExample(AppExample example);

    @Select({
        "select",
        "id, name",
        "from app",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    App selectByPrimaryKey(Integer id);

    @UpdateProvider(type=AppSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") App record, @Param("example") AppExample example);

    @UpdateProvider(type=AppSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") App record, @Param("example") AppExample example);

    @UpdateProvider(type=AppSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(App record);

    @Update({
        "update app",
        "set name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(App record);
}