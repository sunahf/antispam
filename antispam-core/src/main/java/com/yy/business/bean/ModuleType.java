package com.yy.business.bean;

/**
 * Created by Administrator on 2016/4/12.
 */
public enum  ModuleType {

    SPOUT(1),BOLT(2);

    int type;

    private ModuleType(int type) {
        this.type=type;
    }

    public int getType() {
        return type;
    }

    public static ModuleType findByType(int type) {
        switch (type) {
        case 1:
            return SPOUT;
        case 2:
            return BOLT;
        default:
            return null;
        }
    }
}
