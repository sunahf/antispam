package com.yy.business.dao.gen.model;

public class Module {
    private Integer id;

    private Integer strategyId;

    private String moduleName;

    private Integer moduleType;

    private String moduleClass;

    private String moduleArg;

    private String upstreamModuleName;

    private Integer level;

    private Integer groupType;

    private Integer parallelism;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Integer strategyId) {
        this.strategyId = strategyId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Integer getModuleType() {
        return moduleType;
    }

    public void setModuleType(Integer moduleType) {
        this.moduleType = moduleType;
    }

    public String getModuleClass() {
        return moduleClass;
    }

    public void setModuleClass(String moduleClass) {
        this.moduleClass = moduleClass;
    }

    public String getModuleArg() {
        return moduleArg;
    }

    public void setModuleArg(String moduleArg) {
        this.moduleArg = moduleArg;
    }

    public String getUpstreamModuleName() {
        return upstreamModuleName;
    }

    public void setUpstreamModuleName(String upstreamModuleName) {
        this.upstreamModuleName = upstreamModuleName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getGroupType() {
        return groupType;
    }

    public void setGroupType(Integer groupType) {
        this.groupType = groupType;
    }

    public Integer getParallelism() {
        return parallelism;
    }

    public void setParallelism(Integer parallelism) {
        this.parallelism = parallelism;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}