package com.yy.business.dao.gen.model;

public class Strategy {
    private Integer id;

    private Integer appId;

    private String strategyName;

    private Integer maxTaskParallelism;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getStrategyName() {
        return strategyName;
    }

    public void setStrategyName(String strategyName) {
        this.strategyName = strategyName;
    }

    public Integer getMaxTaskParallelism() {
        return maxTaskParallelism;
    }

    public void setMaxTaskParallelism(Integer maxTaskParallelism) {
        this.maxTaskParallelism = maxTaskParallelism;
    }
}