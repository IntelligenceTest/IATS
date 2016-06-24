package com.autostreets.biz.auction.model;

import com.autostreets.biz.auction.model.base.BaseDealerGroup;
import com.autostreets.framework.common.dal.Pagination;

public class DealerGroup extends BaseDealerGroup {
	
    /**
     */
    private static final long serialVersionUID = 4064740200251449671L;
    private Pagination pagination;

    private String groupNoOrName;

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

    /**
     * @return the groupNoOrName
     */
    public String getGroupNoOrName() {
        return groupNoOrName;
    }

    /**
     * @param groupNoOrName
     *            the groupNoOrName to set
     */
    public void setGroupNoOrName(String groupNoOrName) {
        this.groupNoOrName = groupNoOrName;
    }

}
