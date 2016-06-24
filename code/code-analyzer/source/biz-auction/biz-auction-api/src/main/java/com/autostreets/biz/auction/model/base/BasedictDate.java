package com.autostreets.biz.auction.model.base;

import java.io.Serializable;
import java.util.Date;

public class BasedictDate implements Serializable {
    /**
     */
    private static final long serialVersionUID = -1521864813321526062L;
    private Date dt;

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }
}