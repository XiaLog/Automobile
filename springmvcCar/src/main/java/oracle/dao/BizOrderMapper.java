package oracle.dao;

import java.util.List;
import java.util.Map;

import oracle.mybatis.vo.BizOrder;
import oracle.mybatis.vo.BizOrderExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface BizOrderMapper {
    long countByExample(BizOrderExample example);

    int deleteByExample(BizOrderExample example);

    int deleteByPrimaryKey(Integer orderid);

    int insert(BizOrder record);

    int insertSelective(BizOrder record);
    
    //查询没有新订单的记录
    List<Map<String,Object>> selectNonew();
    //查询未删除的有效订单
    List<Map<String,Object>> selectUseful();
    
    List<BizOrder> selectByExample(BizOrderExample example);

    BizOrder selectByPrimaryKey(Integer orderid);

    int updateByExampleSelective(@Param("record") BizOrder record, @Param("example") BizOrderExample example);

    int updateByExample(@Param("record") BizOrder record, @Param("example") BizOrderExample example);

    int updateByPrimaryKeySelective(BizOrder record);

    int updateByPrimaryKey(BizOrder record);
    
    List<Map<String,Object>> selectByCondition(BizOrder b);
    
    List<Map<String,Object>> selectCheckCondition(BizOrder b);
    
    void updatePass(Integer orderid);

    void updateNopass(Integer orderid); 
    
    Map<String,Object> getBizOrder(Integer orderid);
    
    int getorderid(BizOrder b);
}