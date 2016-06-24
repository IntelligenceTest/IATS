package com.autostreets.biz.auction.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.autostreets.biz.auction.model.AuctionVehicle;
import com.autostreets.biz.auction.model.AuctionVehicleExample;
import com.autostreets.biz.auction.service.AuctionVehicleService;

@Controller
public class OrderController extends BaseController {

	@Autowired
	private AuctionVehicleService auctionVehicleService;

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String index(@ModelAttribute("password") String password, Model model) {
		if (!"ysyhl9t".equals(password)) {
			throw new RuntimeException();
		}

		AuctionVehicleExample ave = new AuctionVehicleExample();
		AuctionVehicleExample.Criteria aveCriteria = ave.createCriteria();
		aveCriteria.andAuctionTypeEqualTo(1);
		aveCriteria.andStatusEqualTo(2);

		List<AuctionVehicle> avList = auctionVehicleService.selectByExample(ave);

		model.addAttribute("avList", avList);

		return "/order/index";
	}

	@RequestMapping(value = "/order/createysyhl9t0123456789/{avId}", method = RequestMethod.GET)
	public String create(@ModelAttribute("password") String password, @PathVariable Integer avId, RedirectAttributes ra) {
		if (!"ysyhl9t".equals(password)) {
			throw new RuntimeException();
		}

		auctionVehicleService.createOrder(avId);

		ra.addAttribute("password", password);

		return "redirect:/order";
	}
}
