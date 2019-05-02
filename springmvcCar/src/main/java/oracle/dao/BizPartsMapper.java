package oracle.dao;

import java.util.List;
import oracle.mybatis.vo.BizParts;
import oracle.mybatis.vo.BizPartsExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface BizPartsMapper {
    long countByExample(BizPartsExample example);

    int deleteByExample(BizPartsExample example);

    int deleteByPrimaryKey(Integer partsid);

    int insert(BizParts record);

    int insertSelective(BizParts record);

    List<BizParts> selectByExample(BizPartsExample example);

    BizParts selectByPrimaryKey(Integer partsid);

    int updateByExampleSelective(@Param("record") BizParts record, @Param("example") BizPartsExample example);

    int updateByExample(@Param("record") BizParts record, @Param("example") BizPartsExample example);

    int updateByPrimaryKeySelective(BizParts record);

    int updateByPrimaryKey(BizParts record);
}