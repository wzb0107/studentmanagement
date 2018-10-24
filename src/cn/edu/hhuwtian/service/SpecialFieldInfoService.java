package cn.edu.hhuwtian.service;

import java.util.List;

import cn.edu.hhuwtian.pojo.QueryVo;
import cn.edu.hhuwtian.pojo.TSpecialfieldinfo;
import cn.edu.hhuwtian.util.Page;

public interface SpecialFieldInfoService {

	Page<TSpecialfieldinfo> findPageByQueryVo(QueryVo vo);

	void addSpecialFieldInfo(TSpecialfieldinfo specialfieldinfo);

	TSpecialfieldinfo showFieldInfo(Integer id);

	void updateSpecialFieldInfo(TSpecialfieldinfo specialfieldinfo);

	void deleteSpecialField(Integer id);

	List<QueryVo> findAllSpecialField();

	Integer findSpecialFieldId(QueryVo vo);

}
