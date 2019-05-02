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
import oracle.service.BizOrdercheckService;

@Controller
@RequestMapping("/page/ordersys/order")
public class OrdercheckHandler {

	@Autowired
	BizOrdercheckService service;
	
	@RequestMapping("/orderchecklist")
	public String ovderchecklist(@RequestParam(required=true,defaultValue="1") Integer page,HttpServletRequest request,Model model) {
		 PageHelper.startPage(page, 10);
		List<Map<String,Object>> list=service.getNonew();
		PageInfo<Map<String,Object>> p=new PageInfo<Map<String,Object>>(list);
	     model.addAttribute("page", p);
	     model.addAttribute("list",list);
		return "/page/ordersys/order/orderchecklist";
	}
	
	
	@RequestMapping("/orderchecksearch")
	public String ovderchecksearch(@RequestParam(required=true,defaultValue="1") Integer page,HttpServletRequest request,Model model,String orderflag,String ordercode,String orderdate) {
		PageHelper.startPage(page, 10);
		BizOrder b=new BizOrder();
		if(orderdate!=null&&orderdate!="") {
			b.setOrderdate(new Date(Long.valueOf(orderdate)));
		}
		if(ordercode!=null&&ordercode!="") {
			b.setOrdercode(ordercode);
		}
		if(!orderflag.equals("-1")) {
			b.setOrderflag(orderflag);
		}
		List<Map<String,Object>> list=service.searchcheckList(b);
		PageInfo<Map<String,Object>> p=new PageInfo<Map<String,Object>>(list);
		model.addAttribute("page", p);
        model.addAttribute("list",list);
		return "/page/ordersys/order/orderchecklist";
	}
	
	@RequestMapping("/orderyeschange")
	public String ovderyeschange(String orderid) {
		service.checkpass(Integer.valueOf(orderid));
		return "redirect:/page/ordersys/order/orderchecklist";
	}
	@RequestMapping("/ordernochange")
	public String ovdernochange(String orderid) {
		service.checknopass(Integer.valueOf(orderid));
		return "redirect:/page/ordersys/order/orderchecklist";
	}
}
