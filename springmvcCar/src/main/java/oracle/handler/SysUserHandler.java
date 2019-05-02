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

import oracle.mybatis.vo.SysEmp;
import oracle.mybatis.vo.SysUser;
import oracle.service.SysUserService;
@Controller
@RequestMapping("/page/system/user")
public class SysUserHandler {
	
	@Autowired
	SysUserService service;
	
	@RequestMapping("/userlist")
	public String userlist(@RequestParam(required=true,defaultValue="1") Integer page,HttpServletRequest request,Model model) {
		PageHelper.startPage(page, 10);
		List<Map<String,Object>> list=service.getlist();
		PageInfo<Map<String,Object>> p=new PageInfo<Map<String,Object>>(list);
	      model.addAttribute("page", p);
	      model.addAttribute("userList",list); 
		return "/page/system/user/userlist";
	}
	
	@RequestMapping("/useradd")
	public String useradd() {
		return "/page/system/user/useradd";
	}
	
	@RequestMapping("/saveuser")
	public String saveuser(String name,String loginname,String loginpwd) {
		SysUser user=new SysUser();
		SysEmp emp=new SysEmp();
		if(!name.equals(""))
			emp.setName(name);
		if(!loginname.equals(""))
			user.setLoginname(loginname);
		if(!loginpwd.equals(""))
			user.setLoginpwd(loginpwd);
		service.addUser(user, emp);
		return "redirect:/page/system/user/userlist";
	}
	
	@RequestMapping("/useredit")
	public String useredit(String userid,Map<String,Object> map) {
		SysUser user=service.getSysUserById(Integer.valueOf(userid));
		SysEmp emp=service.getEmp(Integer.valueOf(userid));
		map.put("emp", emp);
		map.put("user", user);
		return "/page/system/user/useredit";
	}
	
	@RequestMapping("/changeuser")
	public String changeuser(String userid,String loginname,String name,String loginpwd) {
		SysUser user=new SysUser();
		SysEmp emp=new SysEmp();
		user.setUserid(Integer.valueOf(userid));
		user.setLoginname(loginname);
		user.setLoginpwd(loginpwd);
		emp.setId(Integer.valueOf(userid));
		emp.setName(name);
		return "redirect:/page/system/user/userlist";
	}
	
	@RequestMapping("/userdelete")
	public String userdelete(String userid) {
		service.deleteUser(Integer.valueOf(userid));
		return "redirect:/page/system/user/userlist";
	}
	
	@RequestMapping("/usersearch")
	public String usersearch(@RequestParam(required=true,defaultValue="1") Integer page,HttpServletRequest request,Model model,String name,String loginname) {
		PageHelper.startPage(page,10);
		if(name.equals(""))
			name=null;
		if(loginname.equals(""))
			loginname=null;
		List<Map<String,Object>> list=service.geConditionlist(loginname, name);
		PageInfo<Map<String,Object>> p=new PageInfo<Map<String,Object>>(list);
	      model.addAttribute("page", p);
	      model.addAttribute("userList",list); 
		return "/page/system/user/userlist";
	}
	
}
