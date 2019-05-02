package oracle.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import oracle.dao.BizPartsrepertoryMapper;
import oracle.mybatis.vo.BizParts;
import oracle.mybatis.vo.BizPartsExample;

@Controller
public class BizPartsrepertoryService {

	@Autowired
	BizPartsrepertoryMapper mapper;
	
	@Transactional
	public List<Map<String,Object>> getPartsreperlist(){
		return mapper.getPartsrep();
	}
	
	@Transactional
	public List<Map<String,Object>> getlistByNameOrId(Integer partsid,String partsname){
		return mapper.getPartsrepBynameOrid(partsid, partsname);
	}
	
	@Transactional
	public void changeCount(Integer partsid,Integer partsreqcount){
		mapper.updateCount(partsid, partsreqcount);
	}
}
