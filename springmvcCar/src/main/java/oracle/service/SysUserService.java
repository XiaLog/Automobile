package oracle.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oracle.dao.SysEmpMapper;
import oracle.dao.SysUserMapper;
import oracle.mybatis.vo.SysEmp;
import oracle.mybatis.vo.SysUser;
import oracle.mybatis.vo.SysUserExample;

@Service
public class SysUserService {
    
	@Autowired
	SysUserMapper mapper;
	@Autowired
	SysEmpMapper emapper;
	
	@Transactional
	public SysUser getSysUserById(Integer userid){
		return mapper.selectByPrimaryKey(userid);
	}
	
	@Transactional(readOnly=true)
	public SysUser login(String loginname,String loginpwd){
		return mapper.selectByNameAndPwd(loginname, loginpwd);
	}
	
	@Transactional(readOnly=true)
	public String getName(String loginname,String loginpwd){
		return mapper.getLoginname(loginname, loginpwd);
	}
	
	@Transactional
	public List<SysUser> getAll(){
		SysUserExample example=new SysUserExample();
		return mapper.selectByExample(example);
	}
	
	@Transactional
	public List<Map<String,Object>> getlist(){
		return mapper.getnamelist();
	}
	
	@Transactional
	public List<Map<String,Object>> geConditionlist(String loginname,String name){
		return mapper.getlistBycondition(loginname, name);
	}
	
	@Transactional
	public void addUser(SysUser user,SysEmp emp){
		mapper.insert(user);
		emapper.insert(emp);
	}
	
	@Transactional
	public void deleteUser(Integer userid){
		mapper.deleteByPrimaryKey(userid);
		emapper.deleteByPrimaryKey(userid);
	}
	
	@Transactional
	public void updateUser(SysUser user,SysEmp emp){
		mapper.updateByPrimaryKey(user);
		emapper.updateByPrimaryKey(emp);
	}
	
	@Transactional
	public SysEmp getEmp(int id){
		return emapper.selectByPrimaryKey(id);
	}
}
