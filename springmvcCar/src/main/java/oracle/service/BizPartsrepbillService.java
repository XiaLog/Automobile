package oracle.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oracle.dao.BizPartsrepbillMapper;

@Service
public class BizPartsrepbillService {

	@Autowired
	BizPartsrepbillMapper mapper;
	
	@Transactional
	public List<Map<String,Object>> getList(){
		return mapper.selectList();
	}
	
	@Transactional
	public List<Map<String,Object>> getSearch(Date billtime,String billflag,String billtype,String partsname){
		return mapper.searchList(billtime, billflag, billtype, partsname);
	}
}
