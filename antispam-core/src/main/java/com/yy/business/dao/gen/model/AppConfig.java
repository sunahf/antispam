package com.yy.business.dao.gen.model;

public class AppConfig {
    private Integer appid;

    private String appName;

    private Integer maxTaskParallelism;

    public Integer getAppid() {
        return appid;
    }

    public void setAppid(Integer appid) {
        this.appid = appid;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Integer getMaxTaskParallelism() {
        return maxTaskParallelism;
    }

    public void setMaxTaskParallelism(Integer maxTaskParallelism) {
        this.maxTaskParallelism = maxTaskParallelism;
    }
}