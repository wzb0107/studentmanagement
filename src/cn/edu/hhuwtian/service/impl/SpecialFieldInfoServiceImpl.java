package cn.edu.hhuwtian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.hhuwtian.dao.TCollegeinfoMapper;
import cn.edu.hhuwtian.dao.TSpecialfieldinfoMapper;
import cn.edu.hhuwtian.pojo.QueryVo;
import cn.edu.hhuwtian.pojo.TSpecialfieldinfo;
import cn.edu.hhuwtian.pojo.TSpecialfieldinfoExample;
import cn.edu.hhuwtian.service.SpecialFieldInfoService;
import cn.edu.hhuwtian.util.Page;

@Service
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = false)
public class SpecialFieldInfoServiceImpl implements SpecialFieldInfoService {

	@Autowired
	private TSpecialfieldinfoMapper specialFieldInfoMapper;
	@Autowired
	private TCollegeinfoMapper collegeInfoMapper;

	@Override
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = true)
	public Page<TSpecialfieldinfo> findPageByQueryVo(QueryVo vo) {
		Page<TSpecialfieldinfo> page = new Page<>();
		vo.setSize(5);
		page.setSize(5);
		if (vo != null) {
			if (vo.getPage() != null) {
				page.setPage(vo.getPage());
				vo.setStartRow((vo.getPage() - 1) * vo.getSize());
			}
			if (vo.getName() != null && !"".equals(vo.getName().trim())) {
				vo.setName(vo.getName().trim());
			}
			Integer total = specialFieldInfoMapper.findCountByQueryVo(vo);
			page.setTotal(total);
			List<TSpecialfieldinfo> list = specialFieldInfoMapper
					.findSpecialFieldInfoListByQueryVo(vo);
			page.setRows(list);
		}
		return page;
	}

	@Override
	public void addSpecialFieldInfo(TSpecialfieldinfo specialfieldinfo) {
		specialFieldInfoMapper.insert(specialfieldinfo);
	}

	@Override
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = true)
	public TSpecialfieldinfo showFieldInfo(Integer id) {
		TSpecialfieldinfo specialFieldInfo = specialFieldInfoMapper
				.selectByPrimaryKey(id);
		System.out.println(specialFieldInfo);
		return specialFieldInfo;
	}

	@Override
	public void updateSpecialFieldInfo(TSpecialfieldinfo specialfieldinfo) {
		specialFieldInfoMapper.updateByPrimaryKey(specialfieldinfo);
	}

	@Override
	public void deleteSpecialField(Integer id) {
		specialFieldInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Integer findSpecialFieldId(QueryVo vo) {
		if (vo.getNumber() != null && !"".equals(vo.getNumber().trim())) {
			TSpecialfieldinfoExample example = new TSpecialfieldinfoExample();
			example.createCriteria().andNumberEqualTo(vo.getNumber());
			List<TSpecialfieldinfo> list = specialFieldInfoMapper
					.selectByExample(example);
			return list.get(0).getId();
		}
		return null;
	}

	@Override
	public List<QueryVo> findAllSpecialField() {
		List<QueryVo> list = specialFieldInfoMapper.findSpecialNumber();
		return list;
	}
}
