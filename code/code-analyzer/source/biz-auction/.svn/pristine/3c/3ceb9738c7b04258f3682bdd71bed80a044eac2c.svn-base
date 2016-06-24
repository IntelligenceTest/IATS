package com.autostreets.biz.auction.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.autostreets.biz.auction.model.MemberVehicleFavorite;
import com.autostreets.model.MemberFavorite;

/**
 * @author wwy
 * @date 2015年10月29日下午1:51:36
 */
public class MemberVehicleFavoriteDomain implements Serializable {

	private static final long serialVersionUID = 9190353128606221214L;

	private Integer id;
	private String memberSid;
	private String type;
	private Integer refSid;
	private Integer orgSid;
	private Date createTime;
	private Date modifyTime;
	private String memo;
	private Boolean enabled;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the memberSid
	 */
	public String getMemberSid() {
		return memberSid;
	}

	/**
	 * @param memberSid
	 *            the memberSid to set
	 */
	public void setMemberSid(String memberSid) {
		this.memberSid = memberSid;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the refSid
	 */
	public Integer getRefSid() {
		return refSid;
	}

	/**
	 * @param refSid
	 *            the refSid to set
	 */
	public void setRefSid(Integer refSid) {
		this.refSid = refSid;
	}

	/**
	 * @return the orgSid
	 */
	public Integer getOrgSid() {
		return orgSid;
	}

	/**
	 * @param orgSid
	 *            the orgSid to set
	 */
	public void setOrgSid(Integer orgSid) {
		this.orgSid = orgSid;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the modifyTime
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * @param modifyTime
	 *            the modifyTime to set
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	/**
	 * @return the memo
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * @param memo
	 *            the memo to set
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * @return the enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled
	 *            the enabled to set
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public static MemberVehicleFavoriteDomain memberFavorite2MemberVehicleFavoriteDomain(MemberFavorite favorite) {
		if (favorite != null) {
			MemberVehicleFavoriteDomain domain = new MemberVehicleFavoriteDomain();
			BeanUtils.copyProperties(favorite, domain);
			domain.setType(favorite.getType());
			domain.setRefSid(favorite.getRefSid() == null ? null : Integer.valueOf(favorite.getRefSid()));
			domain.setOrgSid(favorite.getOrgSid() == null ? null : Integer.valueOf(favorite.getOrgSid()));
			return domain;
		}
		return null;
	}

	public static MemberVehicleFavoriteDomain memberVehicle2MemberVehicleFavoriteDomain(
			MemberVehicleFavorite favorite) {
		if (favorite != null) {
			MemberVehicleFavoriteDomain domain = new MemberVehicleFavoriteDomain();
			domain.setType(null);
			domain.setRefSid(favorite.getAvId());
			domain.setMemberSid(favorite.getMemberSid());
			domain.setCreateTime(favorite.getCreatedTimestamp());
			return domain;
		}
		return null;
	}
}
