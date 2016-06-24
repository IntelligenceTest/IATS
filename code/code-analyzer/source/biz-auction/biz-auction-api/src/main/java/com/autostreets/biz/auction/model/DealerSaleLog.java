package com.autostreets.biz.auction.model;

import com.autostreets.biz.auction.model.base.BaseDealerSaleLog;
import com.autostreets.framework.common.dal.Pagination;

public class DealerSaleLog extends BaseDealerSaleLog {
	
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
