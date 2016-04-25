package com.yy.business.dao.gen.mapper;

import com.yy.business.dao.gen.model.AppConfig;
import com.yy.business.dao.gen.model.AppConfigExample;
import com.yy.business.dao.gen.model.AppConfigExample.Criteria;
import com.yy.business.dao.gen.model.AppConfigExample.Criterion;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class AppConfigSqlProvider {

    public String countByExample(AppConfigExample example) {
        BEGIN();
        SELECT("count (*)");
        FROM("app_config");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(AppConfigExample example) {
        BEGIN();
        DELETE_FROM("app_config");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(AppConfig record) {
        BEGIN();
        INSERT_INTO("app_config");
        
        if (record.getAppid() != null) {
            VALUES("appid", "#{appid,jdbcType=INTEGER}");
        }
        
        if (record.getAppName() != null) {
            VALUES("app_name", "#{appName,jdbcType=VARCHAR}");
        }
        
        if (record.getMaxTaskParallelism() != null) {
            VALUES("max_task_parallelism", "#{maxTaskParallelism,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String selectByExample(AppConfigExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("appid");
        } else {
            SELECT("appid");
        }
        SELECT("app_name");
        SELECT("max_task_parallelism");
        FROM("app_config");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        AppConfig record = (AppConfig) parameter.get("record");
        AppConfigExample example = (AppConfigExample) parameter.get("example");
        
        BEGIN();
        UPDATE("app_config");
        
        if (record.getAppid() != null) {
            SET("appid = #{record.appid,jdbcType=INTEGER}");
        }
        
        if (record.getAppName() != null) {
            SET("app_name = #{record.appName,jdbcType=VARCHAR}");
        }
        
        if (record.getMaxTaskParallelism() != null) {
            SET("max_task_parallelism = #{record.maxTaskParallelism,jdbcType=INTEGER}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("app_config");
        
        SET("appid = #{record.appid,jdbcType=INTEGER}");
        SET("app_name = #{record.appName,jdbcType=VARCHAR}");
        SET("max_task_parallelism = #{record.maxTaskParallelism,jdbcType=INTEGER}");
        
        AppConfigExample example = (AppConfigExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(AppConfig record) {
        BEGIN();
        UPDATE("app_config");
        
        if (record.getAppName() != null) {
            SET("app_name = #{appName,jdbcType=VARCHAR}");
        }
        
        if (record.getMaxTaskParallelism() != null) {
            SET("max_task_parallelism = #{maxTaskParallelism,jdbcType=INTEGER}");
        }
        
        WHERE("appid = #{appid,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(AppConfigExample example, boolean includeExamplePhrase) {
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