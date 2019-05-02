package oracle.dao;

import java.util.List;
import java.util.Map;

import oracle.mybatis.vo.BizOrderdetail;
import oracle.mybatis.vo.BizOrderdetailExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface BizOrderdetailMapper {
    long countByExample(BizOrderdetailExample example);

    int deleteByExample(BizOrderdetailExample example);

    int deleteByPrimaryKey(Integer orderdetailid);

    int insert(BizOrderdetail record);

    int insertSelective(BizOrderdetail record);

    List<BizOrderdetail> selectByExample(BizOrderdetailExample example);

    BizOrderdetail selectByPrimaryKey(Integer orderdetailid);

    int updateByExampleSelective(@Param("record") BizOrderdetail record, @Param("example") BizOrderdetailExample example);

    int updateByExample(@Param("record") BizOrderdetail record, @Param("example") BizOrderdetailExample example);

    int updateByPrimaryKeySelective(BizOrderdetail record);

    int updateByPrimaryKey(BizOrderdetail record);
    
    void deleteById(Integer orderid);
    
    List<Map<String,Object>> getdetails(Integer orderid);
    
    void updateCount(@Param("partsid") Integer partsid,@Param("orderid") Integer orderid,@Param("orderpartscount") Integer orderpartscount);
}