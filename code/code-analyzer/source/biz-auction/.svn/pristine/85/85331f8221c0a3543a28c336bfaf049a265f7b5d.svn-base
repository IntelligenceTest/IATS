package com.autostreets.biz.auction.web.controller;

import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import com.autostreets.biz.auction.model.AuctionDriveway;
import com.autostreets.biz.auction.model.AuctionPlace;
import com.autostreets.biz.auction.service.AuctionDrivewayService;
import com.autostreets.biz.auction.service.AuctionPlaceService;
import com.autostreets.biz.common.service.DfsService;
import com.autostreets.biz.sys.model.dict.DictArea;
import com.autostreets.cache.CacheService;
import com.autostreets.framework.common.dal.Pagination;
import com.autostreets.framework.common.web.vo.JsonResult;
import com.google.common.base.Splitter;

@Controller
@RequestMapping("/auctionplace")
public class AuctionPlaceController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuctionPlaceController.class);

    @Autowired
    private AuctionPlaceService auctionPlaceService;

    @Autowired
    private DfsService dfsService;

    @Autowired
    private AuctionDrivewayService auctionDrivewayService;

    @Autowired
    private CacheService cacheService;

    @RequestMapping("/index")
    @RequiresPermissions({"auct:ap:index"})
    public String dotoIndex(Model model, Pagination pagination, AuctionPlace auctionPlace) {
        pagination = auctionPlaceService.getAuctionPlaceByPage(pagination, auctionPlace);
        model.addAttribute("pagination", pagination);
        return "auctionplace/index";
    }

    // 新建或编辑页面
    @RequestMapping("addPage")
    public String toAddPage(Model model, AuctionPlace auctionPlace) {
        if (null != auctionPlace.getId()) {
            auctionPlace = auctionPlaceService.selectByPrimaryKey(auctionPlace.getId());
            model.addAttribute("auctionPlace", auctionPlace);
        }
        return "auctionplace/add";
    }

    // 新建或编辑操作
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public String doToSave(Model model, AuctionPlace auctionPlace, Integer[] drivewayId, String[] drivewayName,
            String[] videoUrl, String[] audioUrl) {
        if (null == auctionPlace.getId()) {// 新增
            // 竞拍场地
            auctionPlace.setEnabled(false);
            auctionPlace.setCreatedTime(new Date());
            AuctionPlace auctionPlace1 = auctionPlaceService.insert(auctionPlace);
            // 插入车道属性
            if (drivewayName != null && drivewayName.length > 0) {
                for (int i = 0; i < drivewayName.length; i++) {
                    // 车道属性
                    if (StringUtils.isNotEmpty(drivewayName[i])) {
                        AuctionDriveway auctionDriveway = new AuctionDriveway();
                        auctionDriveway.setPlaceId(auctionPlace1.getId());
                        auctionDriveway.setName(drivewayName[i]);
                        auctionDriveway.setVideoUrl(null == videoUrl[i] ? null : videoUrl[i]);
                        auctionDriveway.setAudioUrl(null == audioUrl[i] ? null : audioUrl[i]);
                        auctionDrivewayService.insert(auctionDriveway);
                    }
                }
            }
            return "新增成功！";
        } else {// 编辑
            auctionPlaceService.updateByPrimaryKey(auctionPlace);
            String cacheKey = "auctionPlace_" + auctionPlace.getId();
            if (cacheService.exists(cacheKey)) {// 若前台同步拍页面获取拍卖场地已加入缓存，则清除掉
                cacheService.delete(cacheKey);
            }
            if (drivewayId != null && drivewayId.length > 0) {// 编辑车道
                for (int j = 0; j < drivewayId.length; j++) {
                    if (drivewayId[j] != null && StringUtils.isNotEmpty(drivewayName[j])) {// 修改已经关联的车道
                        AuctionDriveway auctionDriveway = new AuctionDriveway();
                        auctionDriveway.setId(drivewayId[j]);
                        auctionDriveway.setPlaceId(auctionPlace.getId());
                        auctionDriveway.setName(drivewayName[j]);
                        auctionDriveway.setVideoUrl(null == videoUrl[j] ? null : videoUrl[j]);
                        auctionDriveway.setAudioUrl(null == audioUrl[j] ? null : audioUrl[j]);
                        auctionDrivewayService.updateByPrimaryKey(auctionDriveway);
                    } else if (StringUtils.isNotEmpty(drivewayName[j])) {// 编辑时新添加的车道
                        AuctionDriveway auctionDriveway = new AuctionDriveway();
                        auctionDriveway.setPlaceId(auctionPlace.getId());
                        auctionDriveway.setName(drivewayName[j]);
                        auctionDriveway.setVideoUrl(null == videoUrl[j] ? null : videoUrl[j]);
                        auctionDriveway.setAudioUrl(null == audioUrl[j] ? null : audioUrl[j]);
                        auctionDrivewayService.insert(auctionDriveway);
                    }
                }
            }
            return "编辑成功！";
        }
    }

    // 激活/禁止拍卖中心
    @RequestMapping(value = "/openOrClose")
    @ResponseBody
    public JsonResult OpenOrClose(String ids, String flag) {
        List<String> idList = Splitter.on(",").omitEmptyStrings().trimResults().splitToList(ids);
        for (String i : idList) {
            AuctionPlace ap = auctionPlaceService.selectByPrimaryKey(Integer.parseInt(i));
            if (flag.equals("open")) {
                ap.setEnabled(true);
            } else {
                ap.setEnabled(false);
            }
            auctionPlaceService.updateByPrimaryKey(ap);
        }
        return new JsonResult(true, "已" + (flag.equals("open") ? "激活" : "禁用") + "所选拍卖中心");
    }

    // 根据省获取市
    @Override
    @RequestMapping(value = "/getCitys")
    @ResponseBody
    public List<DictArea> getCitys(String proId) {
        return super.getCitys(proId);
    }

    @RequestMapping("upload")
    @ResponseBody
    public String uploadPic(String name, DefaultMultipartHttpServletRequest request, HttpServletResponse response) {
        CommonsMultipartFile file = (CommonsMultipartFile) request.getFile(name);// 这里的file就是前台页面的name
        if (file.isEmpty())
            return "文件不存在";
        if (file.getSize() > 1024 * 1024 * 5) {
            return "图片大于5M";
        }
        String originalFilename = file.getOriginalFilename();
        String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        if (!(extName.toLowerCase().equals("jpg") || extName.toLowerCase().equals("gif")
                || extName.toLowerCase().equals("png") || extName.toLowerCase().equals(""))) {
            return "格式不正确，仅支持jpg/gif/png格式！";
        }

        try {
            BufferedImage image = ImageIO.read(file.getInputStream());
            int width = image.getWidth();
            int height = image.getHeight();
            if (name.startsWith("picUrl")) {// 520*270
                if (width != 520 || height != 270) {
                    return "图片尺寸不正确(" + 520 + "*" + 270 + ")";
                }
            } else if (name.startsWith("banner")) {// 610*280
                if (width != 610 || height != 280) {
                    return "图片尺寸不正确(" + 610 + "*" + 280 + ")";
                }
            } else {
                return "图片类型不存在";
            }
            String fileId = dfsService.uploadFile(file.getBytes(), extName);
            if (null != fileId && fileId.startsWith("HTTP Status ")) {
                fileId = "";
            }
            return fileId;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return "";
        }
    }

    @RequestMapping("getDriveways")
    @ResponseBody
    public JsonResult changeDrivewayByPlace(Integer placeId) {
        if (placeId == null) {
            return new JsonResult(true, null);
        }
        return new JsonResult(true, auctionDrivewayService.getDrivewayByPlaceId(placeId));
    }

    @RequestMapping("getPlaceLastAuctionNum")
    @ResponseBody
    public JsonResult getPlaceLastAuctionNum(Integer placeId) {
        return new JsonResult(true, auctionPlaceService.getPlaceLastAuctionNum(placeId));
    }
}
