package com.autostreets.web.controller.usedvehicle;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import com.sun.xml.internal.ws.util.StringUtils;

/**
 * 自用车管理
 * 
 * @author wei.liao
 * @Date 2016年1月15日
 */
@Controller
@RequestMapping("/personalVehicle")
public class PersonalVehicleController extends BaseController {

	private final static Logger LOGGER = LoggerFactory.getLogger(PersonalVehicleController.class);

	@Autowired
	private DealerUsedVehicleService dealerUsedVehicleService;

	@Autowired
	private ApprovalService approvalService;

	/**
	 * 申请退役
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/appliedRetire", method = RequestMethod.POST)
	@RequiresPermissions("dealer:personalVehicle:applied")
	public @ResponseBody JsonResult appliedRetire(String retireInfos, String vinCodes, String dataIds) {

		if (StringUtils.isNotEmpty(retireInfos) && StringUtils.isNotEmpty(vinCodes)
				&& StringUtils.isNotEmpty(dataIds)) {
			String errorMsg = dealerUsedVehicleService.retireApply(retireInfos, vinCodes, dataIds, getUser().getId(),
					getCurrUserName(), getCurrUserOrg().getOrgName(), getCurrUserGroup());
			if (StringUtils.isNotEmpty(errorMsg)) {
				return new JsonResult(false, errorMsg);
			}
		} else {
			return new JsonResult(false, "参数校验不通过");
		}
		return new JsonResult(true);
	}

	/**
	 * 功能描述: <br>
	 * 
	 * <pre>
	 * 审批结果
	 * </pre>
	 *
	 * @param retireInfos
	 * @param vinCodes
	 * @param dataIds
	 * @return
	 * @author jingzhou.zhao
	 * @datetime 2016年1月18日 下午2:58:57
	 * @version 1.0.0
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	@RequestMapping(value = "/applyView", method = RequestMethod.GET)
	public String applyView(Integer id, Model model) {

		try {
			DealerUsedVehicle usedVehicle = dealerUsedVehicleService.selectByPrimaryKey(id);
			if (usedVehicle != null && usedVehicle.getProcessInstanceId() != null) {
				ApprovalResult approvalResult = approvalService.getApprovalById(usedVehicle.getProcessInstanceId());
				// 流程图
				List<ApprovalCommentDTO> comments = approvalResult.getCommentList();
				if (CollectionUtils.isNotEmpty(comments)) {
					Collections.reverse(comments);
					model.addAttribute("processNodes", comments);
				}
				model.addAttribute("processInstanceId", usedVehicle.getProcessInstanceId());
				model.addAttribute("approvalResult", approvalResult);
				return "personalVehicle/applyView";
			}
		} catch (WorkflowException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return "error/403";
	}

	// /**
	// * 申请退役保存
	// * @param dealerUsedVehicle
	// * @return
	// */
	// @RequestMapping(value = "/appliedRetireSave", method =
	// RequestMethod.POST)
	// @ResponseBody
	// public JsonResult appliedRetireSave(DealerUsedVehicle dealerUsedVehicle)
	// {
	// JsonResult jr = null;
	//
	// try {
	// Integer crtUserId = UserUtils.getUser().getId();
	// dealerUsedVehicleService.appliedRetireSave(dealerUsedVehicle, crtUserId);
	// jr = new JsonResult(true);
	// } catch (Exception e) {
	// LOGGER.error("申请退役车辆失败", e);
	// jr = new JsonResult(false, "申请退役车辆失败");
	// }
	//
	// return jr;
	// }

	/**
	 * 退役审核
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/retired", method = RequestMethod.GET)
	@RequiresPermissions("dealer:personalVehicle:retired")
	public String retired(Integer id, Model model) {

		DealerUsedVehicle duv = dealerUsedVehicleService.selectByPrimaryKey(id);

		model.addAttribute("dealerUsedVehicle", duv);
		model.addAttribute("salesChannelList", dealerUsedVehicleService.selectSalesChannelList());

		return "personalVehicle/retired";
	}

	/**
	 * 退役审核保存
	 * 
	 * @param dealerUsedVehicle
	 * @return
	 */
	@RequestMapping(value = "/retiredSave", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult retiredSave(DealerUsedVehicle dealerUsedVehicle) {

		JsonResult jr = null;

		try {
			Integer crtUserId = UserUtils.getUser().getId();
			dealerUsedVehicleService.retiredSave(dealerUsedVehicle, crtUserId);
			jr = new JsonResult(true);
		} catch (Exception e) {
			LOGGER.error("退役车辆失败", e);
			jr = new JsonResult(false, "退役车辆失败");
		}

		return jr;
	}

	/**
	 * 评估
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/eqs", method = RequestMethod.POST)
	@RequiresPermissions("dealer:personalVehicle:eqs")
	@ResponseBody
	public JsonResult eqs(Integer id) {

		JsonResult jr = null;

		try {
			User user = UserUtils.getUser();
			Organization org = user.getOrgList().get(0);
			String code = dealerUsedVehicleService.eqsSave(id, user.getId(), user.getName(), org.getId(),
					org.getOrgNameAbbr());
			if (Strings.isNullOrEmpty(code)) {
				jr = new JsonResult(false, "该车辆不可再编辑eqs信息，请检查审核状态");
			} else {
				jr = new JsonResult(true);
				jr.setData(code);
			}
		} catch (IOException e) {
			LOGGER.error("向eqs系统保存自用车信息失败", e);
			jr = new JsonResult(false, "向eqs系统保存自用车信息失败");
		}

		return jr;
	}

	/**
	 * 车辆跟踪
	 * 
	 * @param dealerUsedVehicle
	 * @return
	 */
	@RequestMapping(value = "/track", method = RequestMethod.GET)
	@RequiresPermissions("dealer:personalVehicle:track")
	@ResponseBody
	public JsonResult track(Integer id) {

		JsonResult jr = null;

		try {
			List<DealerVehicleLog> list = dealerUsedVehicleService.track(id);
			jr = new JsonResult(true, list);
		} catch (Exception e) {
			LOGGER.error("获取车辆跟踪信息失败", e);
			jr = new JsonResult(false, "获取车辆跟踪信息失败");
		}

		return jr;
	}

	/**
	 * 评估报告
	 * 
	 * @param dealerUsedVehicle
	 * @return
	 */
	@RequestMapping(value = "/eqsDetail", method = RequestMethod.GET)
	@ResponseBody
	public JsonResult eqsDetail(Integer id) {

		JsonResult jr = null;

		try {
			String code = dealerUsedVehicleService.eqsDetail(id);
			jr = new JsonResult(true);
			jr.setData(code);
		} catch (Exception e) {
			LOGGER.error("获取评估报告失败", e);
			jr = new JsonResult(false, "获取评估报告失败");
		}

		return jr;
	}
}