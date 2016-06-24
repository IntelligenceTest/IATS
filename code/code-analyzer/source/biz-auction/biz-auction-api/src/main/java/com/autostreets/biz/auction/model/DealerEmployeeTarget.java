package com.autostreets.biz.auction.model;

import com.autostreets.biz.auction.model.base.BaseDealerEmployeeTarget;
import com.autostreets.framework.common.dal.Pagination;

public class DealerEmployeeTarget extends BaseDealerEmployeeTarget {
	
    /**
     */
    private static final long serialVersionUID = 6524924209968295438L;

    private Pagination pagination;

    private String employeeNoOrName;

    private String groupName;

    private Integer groupType;

    private DealerEmployee dealerEmployee;

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

    public String getEmployeeNoOrName() {
        return employeeNoOrName;
    }

    public void setEmployeeNoOrName(String employeeNoOrName) {
        this.employeeNoOrName = employeeNoOrName;
    }

    public DealerEmployee getDealerEmployee() {
        return dealerEmployee;
    }

    public void setDealerEmployee(DealerEmployee dealerEmployee) {
        this.dealerEmployee = dealerEmployee;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getGroupType() {
        return groupType;
    }

    public void setGroupType(Integer groupType) {
        this.groupType = groupType;
    }

}
