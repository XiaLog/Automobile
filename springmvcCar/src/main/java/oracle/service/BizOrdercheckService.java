package oracle.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oracle.dao.BizOrderMapper;
import oracle.mybatis.vo.BizOrder;

@Service
public class BizOrdercheckService {

	@Autowired
    BizOrderMapper mapper; 
	
	@Transactional
	public List<Map<String,Object>> getNonew(){
		List<Map<String,Object>> list=mapper.selectNonew();
		return list;
	}
	
	@Transactional
	public List<Map<String,Object>> searchcheckList(BizOrder b){
		List<Map<String,Object>> list=mapper.selectCheckCondition(b);
		return list;
	}
	
	@Transactional
	public void checkpass(Integer orderid){
		mapper.updatePass(orderid);
	}
	
	@Transactional
	public void checknopass(Integer orderid){
		mapper.updateNopass(orderid);
	}
	
}
