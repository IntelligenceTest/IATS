package com.autostreets.biz.auction.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autostreets.biz.auction.mapper.DealerMemberMapper;
import com.autostreets.biz.auction.model.DealerMember;
import com.autostreets.biz.auction.model.DealerMemberExample;
import com.autostreets.biz.auction.service.DealerMemberService;
import com.autostreets.framework.common.dal.GenericMapper;
import com.autostreets.framework.common.dal.GenericServiceImpl;
import com.autostreets.framework.common.dal.Pagination;

@Service("dealerMemberService")
public class DealerMemberServiceImpl extends GenericServiceImpl<DealerMember, DealerMemberExample, Integer>implements DealerMemberService {

    @Autowired
    private DealerMemberMapper dealerMemberMapper;


    @Override
    protected GenericMapper<DealerMember, DealerMemberExample, Integer> getGenericMapper() {
        return dealerMemberMapper;
    }


	@Override
	public Pagination getDealerMemberByPage(Pagination pagination,
			DealerMember dealerMember) {
		dealerMember.setPagination(pagination);
		List<DealerMember> list = dealerMemberMapper.selectDealerMemberByPage(dealerMember);
		int count = dealerMemberMapper.countDealerMember(dealerMember);
		pagination.setDataList(list);
		pagination.setCount(count);
		return pagination;
	}


	@Override
	public boolean checkIdCardNum(DealerMember dealerMember) {
		if(StringUtils.isEmpty(dealerMember.getIdCardNum())){
			return true;
		}
		DealerMemberExample example = new DealerMemberExample();
		DealerMemberExample.Criteria criteria = example.createCriteria();
		criteria.andIdCardNumEqualTo(dealerMember.getIdCardNum());
		criteria.andDelFlagEqualTo(false);
		List<DealerMember> list = dealerMemberMapper.selectByExample(example);
		if(null != list && list.size() > 0){
			DealerMember dm = list.get(0);
			if(null != dealerMember.getId() && dealerMember.getId().equals(dm.getId())){
				return true;
			}else{
				return false;
			}
		}
		return true;
	}

}
