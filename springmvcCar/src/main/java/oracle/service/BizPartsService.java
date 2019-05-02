package oracle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oracle.dao.BizPartsMapper;
import oracle.mybatis.vo.BizParts;
import oracle.mybatis.vo.BizPartsExample;

@Service
public class BizPartsService {

	@Autowired
	BizPartsMapper mapper;
	
	@Transactional
	public List<BizParts> getAll(){
		BizPartsExample example=new BizPartsExample();
		List<BizParts> list=mapper.selectByExample(example);
		return list;
	}
	
	@Transactional
	public BizParts getBizParts(int partsid) {
		BizParts b=mapper.selectByPrimaryKey(partsid);
		return b;
	}
	
	@Transactional
	public void updateParts(BizParts b) {
		mapper.updateByPrimaryKey(b);
	}
	
	@Transactional
	public void deleteParts(int partsid) {
		mapper.deleteByPrimaryKey(partsid);
	}
	
	@Transactional
	public void insertParts(BizParts b) {
		mapper.insert(b);
	}
	
	@Transactional
	public List<BizParts> getlistByName(String partsname){
		BizPartsExample example=new BizPartsExample();
		example.or().andPartsnameLike("%"+partsname+"%");
		List<BizParts> list=mapper.selectByExample(example);
		return list;
	}
}
