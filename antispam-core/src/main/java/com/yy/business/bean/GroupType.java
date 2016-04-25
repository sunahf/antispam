package com.yy.business.bean;

/**
 * Created by Administrator on 2016/4/12.
 */
public enum  GroupType {

    SHUFFLE(1);

    int type;

    private GroupType(int type) {
        this.type=type;
    }

    public int getType() {
        return type;
    }

    public static GroupType findByType(int type) {
        switch (type) {
        case 1:
            return SHUFFLE;
        default:
            return null;
        }
    }
}
