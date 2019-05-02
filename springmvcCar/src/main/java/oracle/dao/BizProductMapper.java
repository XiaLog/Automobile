package oracle.dao;

import java.util.List;
import oracle.mybatis.vo.BizProduct;
import oracle.mybatis.vo.BizProductExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface BizProductMapper {
    long countByExample(BizProductExample example);

    int deleteByExample(BizProductExample example);

    int deleteByPrimaryKey(Integer productid);

    int insert(BizProduct record);

    int insertSelective(BizProduct record);

    List<BizProduct> selectByExample(BizProductExample example);

    BizProduct selectByPrimaryKey(Integer productid);

    int updateByExampleSelective(@Param("record") BizProduct record, @Param("example") BizProductExample example);

    int updateByExample(@Param("record") BizProduct record, @Param("example") BizProductExample example);

    int updateByPrimaryKeySelective(BizProduct record);

    int updateByPrimaryKey(BizProduct record);
}