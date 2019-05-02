package oracle.dao;


import java.util.Date;
import java.util.List;
import java.util.Map;

import oracle.mybatis.vo.BizPartsrepbill;
import oracle.mybatis.vo.BizPartsrepbillExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface BizPartsrepbillMapper {
    long countByExample(BizPartsrepbillExample example);

    int deleteByExample(BizPartsrepbillExample example);

    int deleteByPrimaryKey(Integer billid);

    int insert(BizPartsrepbill record);

    int insertSelective(BizPartsrepbill record);

    List<BizPartsrepbill> selectByExample(BizPartsrepbillExample example);

    BizPartsrepbill selectByPrimaryKey(Integer billid);

    int updateByExampleSelective(@Param("record") BizPartsrepbill record, @Param("example") BizPartsrepbillExample example);

    int updateByExample(@Param("record") BizPartsrepbill record, @Param("example") BizPartsrepbillExample example);

    int updateByPrimaryKeySelective(BizPartsrepbill record);

    int updateByPrimaryKey(BizPartsrepbill record);
    
    public List<Map<String,Object>> selectList();
    
    public List<Map<String,Object>> searchList(@Param("billtime") Date billtime,@Param("billflag") String billflag,@Param("billtype") String billtype,@Param("partsname") String partsname);
}