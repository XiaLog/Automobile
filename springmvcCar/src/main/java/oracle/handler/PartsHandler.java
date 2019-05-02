package oracle.handler;

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

import oracle.mybatis.vo.BizParts;
import oracle.service.BizPartsService;
import oracle.service.BizPartsrepertoryService;

@Controller

@RequestMapping("/page/partssys/parts")
public class PartsHandler {

	@Autowired
	BizPartsService service;
	

	@RequestMapping("/partslist")
	public String partslist(@RequestParam(required=true,defaultValue="1") Integer page,HttpServletRequest request,Model model) {
		PageHelper.startPage(page, 10);
		List<BizParts> list=service.getAll();
		PageInfo<BizParts> p=new PageInfo<BizParts>(list);
	    model.addAttribute("page", p);
	    model.addAttribute("list",list);
		return "/page/partssys/parts/partslist";
	}
	
	@RequestMapping("/partsedit")
    public String partsedit(String partsid,Model model) {
	   BizParts b=service.getBizParts(Integer.valueOf(partsid));
	   model.addAttribute("b",b);
	   return "/page/partssys/parts/partsedit";
    }
	
	@RequestMapping("/partsupdate")
	public String partsupdate(BizParts b){
		System.out.println(b.toString());
		service.updateParts(b);
		return "redirect:/page/partssys/parts/partslist";
	}
	
	@RequestMapping("/partsdelete")
    public String partsdelete(String partsid) {
		service.deleteParts(Integer.valueOf(partsid));
	   return "redirect:/page/partssys/parts/partslist";
    }
	
	@RequestMapping("/partsadd")
    public String partsadd() {
	   return "/page/partssys/parts/partsadd";
    }
	
	@RequestMapping("/addparts")
    public String addparts(BizParts b) {
		service.insertParts(b);
	   return "redirect:/page/partssys/parts/partslist";
    }
	
	@RequestMapping("/partssearch")
	public String partssearch(@RequestParam(required=true,defaultValue="1") Integer page,HttpServletRequest request,Model model,String partsname) {
		PageHelper.startPage(page, 10);
		List<BizParts> list=service.getlistByName(partsname);
		PageInfo<BizParts> p=new PageInfo<BizParts>(list);
	    model.addAttribute("page", p);
	    model.addAttribute("list",list);
		return "/page/partssys/parts/partslist";
	}
	
	
}
