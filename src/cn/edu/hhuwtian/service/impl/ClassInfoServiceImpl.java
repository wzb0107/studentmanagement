package cn.edu.hhuwtian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.hhuwtian.dao.TClassinfoMapper;
import cn.edu.hhuwtian.dao.TSpecialfieldinfoMapper;
import cn.edu.hhuwtian.pojo.QueryVo;
import cn.edu.hhuwtian.pojo.TClassinfo;
import cn.edu.hhuwtian.pojo.TClassinfoExample;
import cn.edu.hhuwtian.service.ClassInfoService;
import cn.edu.hhuwtian.util.Page;
@Service
public class ClassInfoServiceImpl implements ClassInfoService {

	@Autowired
	private TSpecialfieldinfoMapper specialfieldinfoMapper;
	@Autowired
	private TClassinfoMapper classInfoMapper;
	
	@Override
	public Page<TClassinfo> findPageByQueryVo(QueryVo vo) {
		Page<TClassinfo> page = new Page<>();
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
			int total = classInfoMapper.findCountByQueryVo(vo);
			page.setTotal(total);
			List<TClassinfo> list = classInfoMapper.findClassInfoListByQueryVo(vo);
			page.setRows(list);
		}
		return page;
	}

	@Override
	public void addSpecialFieldInfo(TClassinfo classinfo) {
		classInfoMapper.insert(classinfo);
	}
	
	@Override
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = true)
	public TClassinfo showClassInfo(Integer id) {
		TClassinfo classinfo = classInfoMapper
				.selectByPrimaryKey(id);
		return classinfo;
	}
	
	@Override
	public void updateClassInfo(TClassinfo classinfo) {
		classInfoMapper.updateByPrimaryKey(classinfo);
	}

	@Override
	public void deleteClassInfo(Integer id) {
		classInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<QueryVo> findAllClass() {
		List<QueryVo> list = classInfoMapper.findClassNumber();
		return list;
	}

	@Override
	public Integer findClassId(QueryVo vo) {
		if (vo.getNumber() != null && !"".equals(vo.getNumber().trim())) {
			TClassinfoExample example = new TClassinfoExample();
			example.createCriteria().andNumberEqualTo(vo.getNumber());
			List<TClassinfo> list = classInfoMapper
					.selectByExample(example);
			return list.get(0).getId();
		}
		return null;
	}
}
