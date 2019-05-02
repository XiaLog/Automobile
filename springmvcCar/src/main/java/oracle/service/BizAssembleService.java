package oracle.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oracle.dao.BizAssembleMapper;
import oracle.dao.BizPartsrepertoryMapper;
import oracle.mybatis.vo.BizAssemble;
import oracle.mybatis.vo.BizPartsrepertory;

@Service
public class BizAssembleService {

	@Autowired
	BizPartsrepertoryMapper mapper;
	
	@Autowired
	BizAssembleMapper bmapper;
	
	@Transactional
	public void insert(String[] partsids,Integer orderid) {
		Integer[] ids=new Integer[partsids.length];
		for(int i=0;i<partsids.length;i++) {
			ids[i]=Integer.valueOf(partsids[i]);
			int count=mapper.getCount(ids[i]);
			BizAssemble b=new BizAssemble();
			b.setPartscount(count);
			b.setPartsid(ids[i]);
			b.setProductid(orderid);
			bmapper.insert(b);
		}
		
	}
	
	@Transactional
	public List<Map<String,Object>> getAssemblelist(Integer orderid) {
		return bmapper.getlist(orderid);
	}
	
	@Transactional
	public void delete(Integer partsid,Integer orderid,Integer assembleid){
		bmapper.deleteById(partsid,orderid,assembleid);
	}
}
