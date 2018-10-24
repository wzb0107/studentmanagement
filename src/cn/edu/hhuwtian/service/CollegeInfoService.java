package cn.edu.hhuwtian.service;

import java.util.List;

import cn.edu.hhuwtian.exception.CascadeDeleteException;
import cn.edu.hhuwtian.pojo.QueryVo;
import cn.edu.hhuwtian.pojo.TCollegeinfo;
import cn.edu.hhuwtian.util.Page;

public interface CollegeInfoService {

	public Page<TCollegeinfo> findPageByQueryVo(QueryVo vo);

	public void addCollegeInfo(TCollegeinfo collegeinfo);

	public TCollegeinfo showCollegeInfo(Integer id);

	public void deleteCollegeInfo (Integer id) throws CascadeDeleteException;

	public void updateCollegeInfo(TCollegeinfo collegeinfo);

	public List<TCollegeinfo> findAllCollege();

	public Integer findCollegeId(QueryVo vo);
 
}
