package com.autostreets.biz.auction.service;

import com.autostreets.biz.auction.model.DealerMember;
import com.autostreets.biz.auction.model.DealerMemberExample;
import com.autostreets.framework.common.dal.GenericService;
import com.autostreets.framework.common.dal.Pagination;

public interface DealerMemberService extends GenericService<DealerMember, DealerMemberExample, Integer> {

	/**
	 * 
	 * 功能描述: <br>
	 * 〈商家会员分页查询〉
	 *
	 * @param pagination
	 * @param dealerMember
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	public Pagination getDealerMemberByPage(Pagination pagination, DealerMember dealerMember);
	
	public boolean checkIdCardNum(DealerMember dealerMember);
	
}
