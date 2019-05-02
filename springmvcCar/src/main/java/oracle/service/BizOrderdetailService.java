package oracle.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oracle.dao.BizOrderdetailMapper;

@Service
public class BizOrderdetailService {

	@Autowired
	BizOrderdetailMapper mapper;
	
	@Transactional
	public List<Map<String,Object>> getdetaillist(Integer orderid){
		List<Map<String,Object>> list=mapper.getdetails(orderid);
		return list;
	}
	
	@Transactional
	public void updateCountById(Integer orderid,Integer partsid,Integer count){
		mapper.updateCount(partsid, orderid, count);
	}
}
