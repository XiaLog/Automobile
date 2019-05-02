package oracle.handler;

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
import oracle.service.BizPartsrepertoryService;

@Controller
@RequestMapping("/page/partssys/partsrep")
public class PartsrepHandler {
	@Autowired
	BizPartsrepertoryService service;
	
	
	@RequestMapping("/partsreplist")
	public String partsreplist(@RequestParam(required=true,defaultValue="1") Integer page,HttpServletRequest request,Model model) {
		PageHelper.startPage(page, 10);
		List<Map<String,Object>> list=service.getPartsreperlist();
		PageInfo<Map<String,Object>> p=new PageInfo<Map<String,Object>>(list);
	    model.addAttribute("page", p);
	    model.addAttribute("list",list);
		return "/page/partssys/partsrep/partsreplist";
	}
	
	@RequestMapping("/partssearch")
	public String partssearch(@RequestParam(required=true,defaultValue="1") Integer page,HttpServletRequest request,Model model,String partsid,String partsname) {
		PageHelper.startPage(page, 10);
		Integer id=null;  
		if(partsid!=null&&partsid!="")
			id=Integer.valueOf(partsid);
		if(partsname=="")
			partsname=null;
		List<Map<String, Object>> list=service.getlistByNameOrId(id, partsname);
		PageInfo<Map<String, Object>> p=new PageInfo<Map<String, Object>>(list);
	    model.addAttribute("page", p);
	    model.addAttribute("list",list);
		return "/page/partssys/partsrep/partsreplist";
	}
	
	@RequestMapping("/partsrep")
	public String partsrep(Model model) {
		List<Map<String,Object>> list=service.getPartsreperlist();
		model.addAttribute("list",list);
		return "/page/partssys/partsrep/partsrep";
	}
	
	@RequestMapping("/save")
	public String save(String partsid,String partsreqcount,String choose) {
		System.out.println(partsid);
		System.out.println(partsreqcount);
		System.out.println(choose);
		if(partsreqcount!=null&&partsreqcount!=""&&Integer.valueOf(partsid)!=0&&Integer.valueOf(choose)!=0) {
			if(Integer.valueOf(choose)==1) {
				service.changeCount(Integer.valueOf(partsid), -Integer.valueOf(partsreqcount));
			}
			if(Integer.valueOf(choose)==2) {
				service.changeCount(Integer.valueOf(partsid), Integer.valueOf(partsreqcount));
			}
		}    
		return "redirect:/page/partssys/partsrep/partsreplist";
	}
	
}
