package cn.edu.hhuwtian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.hhuwtian.dao.TCollegeinfoMapper;
import cn.edu.hhuwtian.exception.CascadeDeleteException;
import cn.edu.hhuwtian.pojo.QueryVo;
import cn.edu.hhuwtian.pojo.TCollegeinfo;
import cn.edu.hhuwtian.pojo.TCollegeinfoExample;
import cn.edu.hhuwtian.service.CollegeInfoService;
import cn.edu.hhuwtian.util.Page;
/**
 * 学院信息
 * @author 贾金磊
 *
 */
@Service
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
public class CollegeInfoServiceImpl implements CollegeInfoService {

	@Autowired
	private TCollegeinfoMapper collegeInfoMapper;
	@Override
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
	public Page<TCollegeinfo> findPageByQueryVo(QueryVo vo) {
		Page<TCollegeinfo> page = new Page<>();
		vo.setSize(5);
		page.setSize(5);
		if(vo != null) {
			if(vo.getPage() != null){
				page.setPage(vo.getPage());
				vo.setStartRow((vo.getPage() - 1) * vo.getSize());
			}
			if(vo.getName() != null && !"".equals(vo.getName().trim())){
				vo.setName(vo.getName().trim());
			}
			int total = collegeInfoMapper.findCountByQueryVo(vo);
			page.setTotal(total);
			List<TCollegeinfo> list = collegeInfoMapper.findCollegeinfoListByQueryVo(vo);
			page.setRows(list);
		}
		return page;
	}
	@Override
	public void addCollegeInfo(TCollegeinfo collegeinfo) {
		collegeInfoMapper.insert(collegeinfo);
	}
	@Override
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
	public TCollegeinfo showCollegeInfo(Integer id) {
		TCollegeinfo collegeinfo = collegeInfoMapper.selectByPrimaryKey(id);
		return collegeinfo;
	}
	@Override
	public void deleteCollegeInfo(Integer id) throws CascadeDeleteException {
		try {
			collegeInfoMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			throw new CascadeDeleteException("不允许级联删除");
		}
	}
	@Override
	public void updateCollegeInfo(TCollegeinfo collegeinfo) {
		collegeInfoMapper.updateByPrimaryKey(collegeinfo);
	}
	@Override
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
	public List<TCollegeinfo> findAllCollege() {
		List<TCollegeinfo> list = collegeInfoMapper.selectByExample(null);
		return list;
	}
	@Override
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
	public Integer findCollegeId(QueryVo vo) {
		if(vo.getNumber() != null && !"".equals(vo.getNumber().trim())) {
			TCollegeinfoExample example = new TCollegeinfoExample();
			example.createCriteria().andNumberEqualTo(vo.getNumber());
			List<TCollegeinfo> list = collegeInfoMapper.selectByExample(example);
			return list.get(0).getId();
		}
		return null;
	}
}
