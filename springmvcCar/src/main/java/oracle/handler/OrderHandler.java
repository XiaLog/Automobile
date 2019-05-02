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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import oracle.mybatis.vo.BizOrder;
import oracle.service.BizOrderService;
import oracle.service.BizPartsrepertoryService;
@Controller
//@SessionAttributes(value="list")
@RequestMapping("/page/ordersys/order")
public class OrderHandler {

	@Autowired
	BizOrderService service;
	
	@RequestMapping("/orderlist")
	public String ovderlist(@RequestParam(required=true,defaultValue="1") Integer page,HttpServletRequest request,Model model) {
		 PageHelper.startPage(page, 10);
		List<Map<String,Object>> list=service.getUseful();
		//map.put("list", list);
		PageInfo<Map<String,Object>> p=new PageInfo<Map<String,Object>>(list);
	      model.addAttribute("page", p);
	      model.addAttribute("list",list); 
		return "/page/ordersys/order/orderlist";
	}
	
	
	@RequestMapping("/orderadd")
	public String ovderadd() {
		return "/page/ordersys/order/orderadd";
	}

	
	@RequestMapping("/orderedit")
	public String ovderedit() {
		return "/page/ordersys/order/orderedit";
	}
	
	@RequestMapping("/orderdelete")
	public String ovderdelete(String orderid) {
		service.deleteByid(Integer.valueOf(orderid));
		return "redirect:/page/ordersys/order/orderlist";
	}
	
	@RequestMapping("/ordersearch")
	public String ovdersearch(@RequestParam(required=true,defaultValue="1") Integer page,HttpServletRequest request,Model model,String orderflag,String ordercode,String orderdate) {
		PageHelper.startPage(page, 10);
		BizOrder b=new BizOrder();
		if(orderdate!=null&&orderdate!="") {
			b.setOrderdate(new Date(Long.valueOf(orderdate)));
		}
		if(ordercode!=null&&ordercode!="") {
			b.setOrdercode(ordercode);
		}
		if(orderflag!=null&&!orderflag.equals("-1")) {
			b.setOrderflag(orderflag);
		}
		List<Map<String,Object>> list=service.searchList(b);
		PageInfo<Map<String,Object>> p=new PageInfo<Map<String,Object>>(list);
		model.addAttribute("page", p);
        model.addAttribute("list",list);
		return "/page/ordersys/order/orderlist";
	}
	
}
