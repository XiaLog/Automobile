package oracle.test;


import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import oracle.dao.SysUserMapper;
import oracle.mybatis.vo.BizOrder;
import oracle.mybatis.vo.BizParts;
import oracle.mybatis.vo.SysUser;
import oracle.service.BizAssembleService;
import oracle.service.BizOrderService;
import oracle.service.BizOrdercheckService;
import oracle.service.BizOrderdetailService;
import oracle.service.BizPartsService;
import oracle.service.BizPartsrepbillService;
import oracle.service.BizPartsrepertoryService;
import oracle.service.SysUserService;

public class UserTest {

	static ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationcontext.xml");
	public static void main(String[] args) {
//		SysUserService service=context.getBean(SysUserService.class);
//		List<Map<String,Object>> list=service.getlist();
//		for(Map s:list)
//			System.out.println(s);
//		String s=service.getName("zcg", "zcg123");
//		System.out.println(s);
		BizOrderService service=context.getBean(BizOrderService.class);
//		service.deleteByid(18);
		BizOrder biz=new BizOrder();
		biz.setOrderflag("0");
		biz.setOrdercode("aaaaaaaaaa");
		System.out.println(service.insertOrder(biz));
//		Date date=new Date("2017-09-08");

//		biz.setOrderdate(date);
//		List<Map<String,Object>> list=service.searchList(biz);
//        for(Map b:list)
//        	System.out.println(b);
//		BizPartsService service=context.getBean(BizPartsService.class);
//		List<BizParts> list=service.getAll();
//		for(BizParts i:list)
//			System.out.println(i);
//		BizPartsrepertoryService service=context.getBean(BizPartsrepertoryService.class);
//		service.changeCount(100, 44);
//		List<Map<String,Object>> list=service.getlistByNameOrId(null,"ÂË");
//		for(Map i:list)
//			System.out.println(i);
	//System.out.println(Integer.valueOf("-99"));
//		Date d=null;
//		System.out.println(d);
//		BizOrdercheckService service=context.getBean(BizOrdercheckService.class);
//		BizOrder b=new BizOrder();
//    	b.setOrdercode("DD2015111203");
//		List<Map<String,Object>> list=service.searchcheckList(b);
//		for(Map m:list)
//			System.out.println(m);
//		BizOrderdetailService oservice=context.getBean(BizOrderdetailService.class);
//		List<Map<String,Object>> list=service.getdetaillist(1);
//		for(Map m:list)
//			System.out.println(m);
//		BizAssembleService service=context.getBean(BizAssembleService.class);
//		String[] s= {"100","101"};
//		service.insert(s);
//		List<Map<String,Object>> list=service.getAssemblelist(3);
//		for(Map m:list)4:51

//			System.out.println(m);
//		Integer a[]= {102,100};
//		Integer count[]= {1,2};
//		Integer orderid=1;
//		for(int i=0;i<count.length;i++) {
//			service.changeCount(a[i], count[i]);
//			oservice.updateCountById(orderid,a[i],count[i]);
//		}

	}

}
