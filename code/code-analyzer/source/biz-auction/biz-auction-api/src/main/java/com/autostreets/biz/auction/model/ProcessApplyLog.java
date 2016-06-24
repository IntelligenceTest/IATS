package com.autostreets.biz.auction.model;

import com.autostreets.biz.auction.model.base.BaseProcessApplyLog;
import com.autostreets.framework.common.dal.Pagination;

public class ProcessApplyLog extends BaseProcessApplyLog {
	
	/**
     */
    private static final long serialVersionUID = 5443665104844547996L;
    private Pagination pagination;

	/**
	 * @return the pagination
	 */
	public Pagination getPagination() {
		return pagination;
	}

	/**
	 * @param pagination
	 *            the pagination to set
	 */
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
}
