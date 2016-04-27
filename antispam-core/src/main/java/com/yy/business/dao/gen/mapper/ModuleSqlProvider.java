package com.yy.business.dao.gen.mapper;

import com.yy.business.dao.gen.model.Module;
import com.yy.business.dao.gen.model.ModuleExample;
import com.yy.business.dao.gen.model.ModuleExample.Criteria;
import com.yy.business.dao.gen.model.ModuleExample.Criterion;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class ModuleSqlProvider {

    public String countByExample(ModuleExample example) {
        BEGIN();
        SELECT("count (*)");
        FROM("module");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(ModuleExample example) {
        BEGIN();
        DELETE_FROM("module");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(Module record) {
        BEGIN();
        INSERT_INTO("module");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getStrategyId() != null) {
            VALUES("strategy_id", "#{strategyId,jdbcType=INTEGER}");
        }
        
        if (record.getModuleName() != null) {
            VALUES("module_name", "#{moduleName,jdbcType=VARCHAR}");
        }
        
        if (record.getModuleType() != null) {
            VALUES("module_type", "#{moduleType,jdbcType=INTEGER}");
        }
        
        if (record.getModuleClass() != null) {
            VALUES("module_class", "#{moduleClass,jdbcType=VARCHAR}");
        }
        
        if (record.getModuleArg() != null) {
            VALUES("module_arg", "#{moduleArg,jdbcType=VARCHAR}");
        }
        
        if (record.getUpstreamModuleName() != null) {
            VALUES("upstream_module_name", "#{upstreamModuleName,jdbcType=VARCHAR}");
        }
        
        if (record.getLevel() != null) {
            VALUES("level", "#{level,jdbcType=INTEGER}");
        }
        
        if (record.getGroupType() != null) {
            VALUES("group_type", "#{groupType,jdbcType=INTEGER}");
        }
        
        if (record.getParallelism() != null) {
            VALUES("parallelism", "#{parallelism,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String selectByExample(ModuleExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("strategy_id");
        SELECT("module_name");
        SELECT("module_type");
        SELECT("module_class");
        SELECT("module_arg");
        SELECT("upstream_module_name");
        SELECT("level");
        SELECT("group_type");
        SELECT("parallelism");
        SELECT("status");
        FROM("module");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Module record = (Module) parameter.get("record");
        ModuleExample example = (ModuleExample) parameter.get("example");
        
        BEGIN();
        UPDATE("module");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getStrategyId() != null) {
            SET("strategy_id = #{record.strategyId,jdbcType=INTEGER}");
        }
        
        if (record.getModuleName() != null) {
            SET("module_name = #{record.moduleName,jdbcType=VARCHAR}");
        }
        
        if (record.getModuleType() != null) {
            SET("module_type = #{record.moduleType,jdbcType=INTEGER}");
        }
        
        if (record.getModuleClass() != null) {
            SET("module_class = #{record.moduleClass,jdbcType=VARCHAR}");
        }
        
        if (record.getModuleArg() != null) {
            SET("module_arg = #{record.moduleArg,jdbcType=VARCHAR}");
        }
        
        if (record.getUpstreamModuleName() != null) {
            SET("upstream_module_name = #{record.upstreamModuleName,jdbcType=VARCHAR}");
        }
        
        if (record.getLevel() != null) {
            SET("level = #{record.level,jdbcType=INTEGER}");
        }
        
        if (record.getGroupType() != null) {
            SET("group_type = #{record.groupType,jdbcType=INTEGER}");
        }
        
        if (record.getParallelism() != null) {
            SET("parallelism = #{record.parallelism,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("module");
        
        SET("id = #{record.id,jdbcType=INTEGER}");
        SET("strategy_id = #{record.strategyId,jdbcType=INTEGER}");
        SET("module_name = #{record.moduleName,jdbcType=VARCHAR}");
        SET("module_type = #{record.moduleType,jdbcType=INTEGER}");
        SET("module_class = #{record.moduleClass,jdbcType=VARCHAR}");
        SET("module_arg = #{record.moduleArg,jdbcType=VARCHAR}");
        SET("upstream_module_name = #{record.upstreamModuleName,jdbcType=VARCHAR}");
        SET("level = #{record.level,jdbcType=INTEGER}");
        SET("group_type = #{record.groupType,jdbcType=INTEGER}");
        SET("parallelism = #{record.parallelism,jdbcType=INTEGER}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        
        ModuleExample example = (ModuleExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(Module record) {
        BEGIN();
        UPDATE("module");
        
        if (record.getStrategyId() != null) {
            SET("strategy_id = #{strategyId,jdbcType=INTEGER}");
        }
        
        if (record.getModuleName() != null) {
            SET("module_name = #{moduleName,jdbcType=VARCHAR}");
        }
        
        if (record.getModuleType() != null) {
            SET("module_type = #{moduleType,jdbcType=INTEGER}");
        }
        
        if (record.getModuleClass() != null) {
            SET("module_class = #{moduleClass,jdbcType=VARCHAR}");
        }
        
        if (record.getModuleArg() != null) {
            SET("module_arg = #{moduleArg,jdbcType=VARCHAR}");
        }
        
        if (record.getUpstreamModuleName() != null) {
            SET("upstream_module_name = #{upstreamModuleName,jdbcType=VARCHAR}");
        }
        
        if (record.getLevel() != null) {
            SET("level = #{level,jdbcType=INTEGER}");
        }
        
        if (record.getGroupType() != null) {
            SET("group_type = #{groupType,jdbcType=INTEGER}");
        }
        
        if (record.getParallelism() != null) {
            SET("parallelism = #{parallelism,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(ModuleExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,
                                    criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j,
                                    criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}