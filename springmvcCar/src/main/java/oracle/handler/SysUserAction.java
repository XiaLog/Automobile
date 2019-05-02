package oracle.handler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import oracle.mybatis.vo.SysUser;
import oracle.service.SysUserService;

@Controller
@SessionAttributes(value="realname")
public class SysUserAction {

	@Autowired
	SysUserService service;
	
	@RequestMapping("/")
	public String defaultAction() {
		System.out.println("Ĭ��ҳ");
		return "login";
	}
	
	@RequestMapping("/{path}")
	public String defaultPath(@PathVariable("path") String path) {
		System.out.println("·��ʹ��");
		return path;
	}
	
	@RequestMapping("/login")
	 public String login(String loginname,String loginpwd,Map<String,Object> map) {
		 SysUser user=service.login(loginname, loginpwd);
		 if(user!=null) {
			 String name=service.getName(loginname, loginpwd);
			 map.put("realname", name);
			 System.out.println("��¼�ɹ�");
			 return "index";
		 }
			
		 return "redirect:/";
	 }
	
	@RequestMapping("/frame/{path}")
	public String header(@PathVariable("path") String path) {
		return "/frame/"+path;
	}


}
