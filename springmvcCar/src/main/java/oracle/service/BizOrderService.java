package oracle.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oracle.dao.BizOrderMapper;
import oracle.dao.BizOrderdetailMapper;
import oracle.mybatis.vo.BizOrder;
import oracle.mybatis.vo.BizOrderExample;

@Service
public class BizOrderService {
	@Autowired
    BizOrderMapper mapper; 
	@Autowired
	BizOrderdetailMapper dmapper;
	
	@Transactional
	public List<BizOrder> getAll() {
		BizOrderExample example=new BizOrderExample();
		List<BizOrder> list=mapper.selectByExample(example);
		return list;
	}
	
	@Transactional
	public List<Map<String,Object>> getUseful(){
		List<Map<String,Object>> list=mapper.selectUseful();
		return list;
	}
	
	@Transactional
	public void deleteByid(Integer orderid){
		dmapper.deleteById(orderid);
		mapper.deleteByPrimaryKey(orderid);
	}
	
	@Transactional
	public List<Map<String,Object>> searchList(BizOrder b){
		List<Map<String,Object>> list=mapper.selectByCondition(b);
		return list;
	}
	
	@Transactional
	public Map<String,Object> getOrder(Integer orderid){
		return mapper.getBizOrder(orderid);
	}
	
	@Transactional
	public int insertOrder(BizOrder b){
		 mapper.insert(b);
		 return mapper.getorderid(b);
	}
	
	
}
