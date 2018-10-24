package cn.edu.hhuwtian.service;

import java.util.List;

import cn.edu.hhuwtian.pojo.QueryVo;
import cn.edu.hhuwtian.pojo.TClassinfo;
import cn.edu.hhuwtian.util.Page;

public interface ClassInfoService {

	Page<TClassinfo> findPageByQueryVo(QueryVo vo);

	public void addSpecialFieldInfo(TClassinfo classinfo);
	
	public TClassinfo showClassInfo(Integer id);
	
	public void updateClassInfo(TClassinfo classinfo);
	
	public void deleteClassInfo(Integer id);

	Integer findClassId(QueryVo vo);

	List<QueryVo> findAllClass();
}
