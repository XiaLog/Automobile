package oracle.dao;

import java.util.List;
import oracle.mybatis.vo.SysEmp;
import oracle.mybatis.vo.SysEmpExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface SysEmpMapper {
    long countByExample(SysEmpExample example);

    int deleteByExample(SysEmpExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysEmp record);

    int insertSelective(SysEmp record);

    List<SysEmp> selectByExample(SysEmpExample example);

    SysEmp selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysEmp record, @Param("example") SysEmpExample example);

    int updateByExample(@Param("record") SysEmp record, @Param("example") SysEmpExample example);

    int updateByPrimaryKeySelective(SysEmp record);

    int updateByPrimaryKey(SysEmp record);
}