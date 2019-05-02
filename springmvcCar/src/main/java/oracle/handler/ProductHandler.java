package oracle.handler;


import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import oracle.mybatis.vo.BizOrder;
import oracle.service.BizAssembleService;
import oracle.service.BizOrderService;
import oracle.service.BizOrderdetailService;
import oracle.service.BizPartsrepertoryService;

@Controller

public class ProductHandler {

	@Autowired
	BizOrderService service;
	
	@Autowired
	BizOrderdetailService dservice;
	
	@Autowired
	BizPartsrepertoryService pservice;
	
	@Autowired
	BizAssembleService bservice;
	
	@RequestMapping("/page/ordersys/order/system-order-view")
	public String view(String orderid,Map<String,Object> map) {
		Map<String,Object> m=service.getOrder(Integer.valueOf(orderid));
		List<Map<String,Object>> list=dservice.getdetaillist(Integer.valueOf(orderid));
		map.put("m", m);
		map.put("list", list);
		return "/page/product/system-order-view";
	}
	
	@RequestMapping("/page/ordersys/order/system-order-create-edit")
	public String edit(String orderid,Map<String,Object> map) {
		Map<String,Object> m=service.getOrder(Integer.valueOf(orderid));
		List<Map<String,Object>> list=bservice.getAssemblelist(Integer.valueOf(orderid));
		map.put("list", list);
		map.put("m", m);
		return "/page/product/system-order-create-edit";
	}
	
	@RequestMapping("/page/ordersys/order/getmater")
	public String getmater(@RequestParam(required=true,defaultValue="1") Integer page,HttpServletRequest request,Model model,String orderid) {
		PageHelper.startPage(page, 10);
		List<Map<String,Object>> list=pservice.getPartsreperlist();
		PageInfo<Map<String,Object>> p=new PageInfo<Map<String,Object>>(list);
	    model.addAttribute("page", p);
	    model.addAttribute("list",list);
	    model.addAttribute("orderid",orderid);
		return "/page/ordersys/order/getmater";
	}
	
	@RequestMapping("/page/ordersys/order/newgetmater")
	public String newgetmater(@RequestParam(required=true,defaultValue="1") Integer page,HttpServletRequest request,Model model,String ordercode,String orderdate,String orderflag) {
		PageHelper.startPage(page, 10);
		BizOrder b=new BizOrder();
		if(!ordercode.equals(""))
			b.setOrdercode(ordercode);
		if(!orderdate.equals(""))
			b.setOrderdate(new Date(Long.valueOf(orderdate)));
		if(!orderflag.equals(""))
			b.setOrderflag(orderflag);
		Integer orderid=service.insertOrder(b);
		List<Map<String,Object>> list=pservice.getPartsreperlist();
		PageInfo<Map<String,Object>> p=new PageInfo<Map<String,Object>>(list);
	    model.addAttribute("page", p);
	    model.addAttribute("list",list);
	    model.addAttribute("orderid",orderid);
		return "/page/ordersys/order/newgetmater";
	}
	
	@RequestMapping("/page/ordersys/order/searchmater")
	public String searchMater(@RequestParam(required=true,defaultValue="1") Integer page,HttpServletRequest request,Model model,String partsname,String orderid) {
		PageHelper.startPage(page, 10);
		if(partsname.equals(""))
			partsname=null;
		List<Map<String,Object>> list=pservice.getlistByNameOrId(null, partsname);
		PageInfo<Map<String,Object>> p=new PageInfo<Map<String,Object>>(list);
	    model.addAttribute("page", p);
	    model.addAttribute("list",list);
	    model.addAttribute("orderid",orderid);
		return "/page/ordersys/order/getmater";
	}
	
	@RequestMapping("/page/ordersys/order/assemblelist")
	public String assemblelist(String partsid,Map<String,Object> map,String orderid) {
		String partsids[]=partsid.split(",");
		bservice.insert(partsids,Integer.valueOf(orderid));
		List<Map<String,Object>> list=bservice.getAssemblelist(Integer.valueOf(orderid));
		map.put("list", list);
		Map<String,Object> m=service.getOrder(Integer.valueOf(orderid));
		map.put("m", m);
		return "/page/product/system-order-create-edit";
	}
	
	@RequestMapping("/page/ordersys/order/deletebyid")
	public String deleteByid(String partsid,String orderid,String assembleid,Map<String,Object> map) {
		bservice.delete(Integer.valueOf(partsid),Integer.valueOf(orderid),Integer.valueOf(assembleid));
		Map<String,Object> m=service.getOrder(Integer.valueOf(orderid));
		List<Map<String,Object>> list=bservice.getAssemblelist(Integer.valueOf(orderid));
		map.put("list", list);
		map.put("m", m);
		return "/page/product/system-order-create-edit";
	}
	
	@RequestMapping("/page/product/productlist")
	public String productlist() {
		return "/page/product/system-order-view";
	}
	
	@RequestMapping("/page/ordersys/order/system-order-list")
	public String list() {
		return "/page/product/system-order-list";
	}
	
	@RequestMapping("/page/ordersys/order/changecount")
	public String changecount(String orderid,String[] materId,String[] count) {
		for(int i=0;i<count.length;i++) {
			if(count[i].equals("")) {
				pservice.changeCount(Integer.valueOf(materId[i]), 0);
				dservice.updateCountById(Integer.valueOf(orderid),Integer.valueOf(materId[i]), 0);
			}	
			else {
				pservice.changeCount(Integer.valueOf(materId[i]),-Integer.valueOf(count[i]));
				dservice.updateCountById(Integer.valueOf(orderid),Integer.valueOf(materId[i]),Integer.valueOf(count[i]));
			}
		}
		return "redirect:/page/ordersys/order/orderlist";
	}
	
}

