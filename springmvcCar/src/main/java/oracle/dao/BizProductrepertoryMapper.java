package oracle.dao;

import java.util.List;
import oracle.mybatis.vo.BizProductrepertory;
import oracle.mybatis.vo.BizProductrepertoryExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface BizProductrepertoryMapper {
    long countByExample(BizProductrepertoryExample example);

    int deleteByExample(BizProductrepertoryExample example);

    int deleteByPrimaryKey(Integer prorepid);

    int insert(BizProductrepertory record);

    int insertSelective(BizProductrepertory record);

    List<BizProductrepertory> selectByExample(BizProductrepertoryExample example);

    BizProductrepertory selectByPrimaryKey(Integer prorepid);

    int updateByExampleSelective(@Param("record") BizProductrepertory record, @Param("example") BizProductrepertoryExample example);

    int updateByExample(@Param("record") BizProductrepertory record, @Param("example") BizProductrepertoryExample example);

    int updateByPrimaryKeySelective(BizProductrepertory record);

    int updateByPrimaryKey(BizProductrepertory record);
}