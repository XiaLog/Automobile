package oracle.dao;

import java.util.List;
import java.util.Map;

import oracle.mybatis.vo.SysUser;
import oracle.mybatis.vo.SysUserExample;
import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.stereotype.Repository;
@Repository
public interface SysUserMapper {
    long countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(Integer userid);
    
    //登录
    SysUser selectByNameAndPwd(@Param("loginname") String loginname,@Param("loginpwd") String loginpwd);
    
    //获得登录真实姓名
    String getLoginname(@Param("loginname") String loginname,@Param("loginpwd") String loginpwd);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
    
    List<Map<String,Object>> getnamelist();
    
    List<Map<String,Object>> getlistBycondition(@Param("loginname") String loginname,@Param("name") String name);
}