package oracle.dao;

import java.util.List;
import java.util.Map;

import oracle.mybatis.vo.BizPartsrepertory;
import oracle.mybatis.vo.BizPartsrepertoryExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface BizPartsrepertoryMapper {
    long countByExample(BizPartsrepertoryExample example);

    int deleteByExample(BizPartsrepertoryExample example);

    int deleteByPrimaryKey(Integer partsrepid);

    int insert(BizPartsrepertory record);

    int insertSelective(BizPartsrepertory record);

    List<BizPartsrepertory> selectByExample(BizPartsrepertoryExample example);

    BizPartsrepertory selectByPrimaryKey(Integer partsrepid);

    int updateByExampleSelective(@Param("record") BizPartsrepertory record, @Param("example") BizPartsrepertoryExample example);

    int updateByExample(@Param("record") BizPartsrepertory record, @Param("example") BizPartsrepertoryExample example);

    int updateByPrimaryKeySelective(BizPartsrepertory record);

    int updateByPrimaryKey(BizPartsrepertory record);
    
    public List<Map<String,Object>> getPartsrep();
    
    public List<Map<String,Object>> getPartsrepBynameOrid(@Param("partsid") Integer partsid,@Param("partsname") String partsname);
    
    public void updateCount(@Param("partsid") Integer partsid,@Param("partsreqcount") Integer partsreqcount);
    
    int getCount(Integer partsid);
}