package oracle.handler;

import java.util.Date;
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

import oracle.mybatis.vo.BizParts;
import oracle.service.BizPartsrepbillService;

@Controller
@RequestMapping("/page/partssys/partsrepbill")
public class PartsrepbillHandler {
    
	@Autowired
	BizPartsrepbillService service;
	
	@RequestMapping("/partsrepbilllist")
	public String partsrepbilllist(@RequestParam(required=true,defaultValue="1") Integer page,HttpServletRequest request,Model model) {
		PageHelper.startPage(page, 10);
		List<Map<String,Object>> list=service.getList();
		PageInfo<Map<String,Object>> p=new PageInfo<Map<String,Object>>(list);
	    model.addAttribute("page", p);
	    model.addAttribute("list",list);
		return "/page/partssys/partsrepbill/partsrepbilllist";
	}
	
	@RequestMapping("/searchlist")
	public String searchlist(@RequestParam(required=true,defaultValue="1") Integer page,HttpServletRequest request,Model model,String billtime,String partsname,String billflag,String billtype) {
		PageHelper.startPage(page, 10);
		if(partsname==null||partsname.equals(""))
			partsname=null;
//		if(billtime==null||billtime.equals(""))
//			billtime=null;
		if(billflag.equals("0"))
			billflag=null;
		if(billtype.equals("0"))
			billtype=null;
		Date d=null;
		if(billtime!=null&&!billtime.equals(""))
			d=new Date(Long.valueOf(billtime));
		List<Map<String,Object>> list=service.getSearch(d, billflag, billtype, partsname);
		PageInfo<Map<String,Object>> p=new PageInfo<Map<String,Object>>(list);
	    model.addAttribute("page", p);
	    model.addAttribute("list",list);
		return "/page/partssys/partsrepbill/partsrepbilllist";
	}
}
