package oracle.dao;

import java.util.List;
import java.util.Map;

import oracle.mybatis.vo.BizAssemble;
import oracle.mybatis.vo.BizAssembleExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface BizAssembleMapper {
    long countByExample(BizAssembleExample example);

    int deleteByExample(BizAssembleExample example);

    int deleteByPrimaryKey(Integer assembleid);

    int insert(BizAssemble record);

    int insertSelective(BizAssemble record);

    List<BizAssemble> selectByExample(BizAssembleExample example);

    BizAssemble selectByPrimaryKey(Integer assembleid);

    int updateByExampleSelective(@Param("record") BizAssemble record, @Param("example") BizAssembleExample example);

    int updateByExample(@Param("record") BizAssemble record, @Param("example") BizAssembleExample example);

    int updateByPrimaryKeySelective(BizAssemble record);

    int updateByPrimaryKey(BizAssemble record);
    
    List<Map<String,Object>> getlist(Integer orderid);
    
    void deleteById(@Param("partsid") Integer partsid,@Param("orderid") Integer orderid,@Param("assembleid") Integer assembleid);
    
    List<Integer> getPartsidByOrderid(Integer orderid);
}