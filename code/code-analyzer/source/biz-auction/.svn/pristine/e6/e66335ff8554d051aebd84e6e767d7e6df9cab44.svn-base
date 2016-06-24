package com.autostreets.biz.auction.service;

import java.util.List;

import com.autostreets.biz.auction.model.ProcessApplyLog;
import com.autostreets.biz.auction.model.ProcessApplyLogExample;
import com.autostreets.framework.common.dal.GenericService;

public interface ProcessApplyLogService extends GenericService<ProcessApplyLog, ProcessApplyLogExample, Integer> {

    /**
     * 
     * 功能描述: <br>
     * 
     * <pre>
     * 添加流程申请日志
     * </pre>
     *
     * @param processId
     *            流程模板id
     * @param processInstanceId
     *            流程实例id
     * @param processType
     *            类型：1 车辆收购 2 车辆退役 3 定价中心 4 拍品调价 5 展厅调价
     * @param keyValue
     *            主键：车辆收购 、车辆退役 、定价中心：车辆ID（vehicle_id），拍品调价：av_id，展厅调价：fp_id
     * @return
     * @author jingzhou.zhao
     * @datetime 2016年1月20日 上午11:35:22
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public ProcessApplyLog addLog(Integer processId, String processInstanceId, Integer processType, Integer keyValue);

    /**
     * 功能描述: <br>
     * 
     * <pre>
     * 批量添加
     * </pre>
     *
     * @param processApplyLogs
     * @return
     * @author jingzhou.zhao
     * @datetime 2016年1月20日 下午1:24:45
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public int addBatchLog(List<ProcessApplyLog> processApplyLogs);

}
