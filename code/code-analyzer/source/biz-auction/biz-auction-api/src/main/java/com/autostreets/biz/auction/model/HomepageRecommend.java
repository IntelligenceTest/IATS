package com.autostreets.biz.auction.model;

import com.autostreets.biz.auction.model.base.BaseHomepageRecommend;
import com.autostreets.framework.common.dal.Pagination;

public class HomepageRecommend extends BaseHomepageRecommend {

	/**
	 * 
	 */
	private static final long serialVersionUID = -319544494468084491L;
	private Pagination pagination;
	private Vehicle vehicle;
	private FixedPrice fixedPrice;

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
	 * @return the vehicle
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}

	/**
	 * @param vehicle
	 *            the vehicle to set
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	/**
	 * @return the fixedPrice
	 */
	public FixedPrice getFixedPrice() {
		return fixedPrice;
	}

	/**
	 * @param fixedPrice
	 *            the fixedPrice to set
	 */
	public void setFixedPrice(FixedPrice fixedPrice) {
		this.fixedPrice = fixedPrice;
	}
}
