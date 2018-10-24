package cn.edu.hhuwtian.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.hhuwtian.pojo.QueryVo;
import cn.edu.hhuwtian.pojo.TSpecialfieldinfo;
import cn.edu.hhuwtian.pojo.TSpecialfieldinfoExample;

public interface TSpecialfieldinfoMapper {
	int countByExample(TSpecialfieldinfoExample example);

	int deleteByExample(TSpecialfieldinfoExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(TSpecialfieldinfo record);

	int insertSelective(TSpecialfieldinfo record);

	List<TSpecialfieldinfo> selectByExample(TSpecialfieldinfoExample example);

	TSpecialfieldinfo selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") TSpecialfieldinfo record,
			@Param("example") TSpecialfieldinfoExample example);

	int updateByExample(@Param("record") TSpecialfieldinfo record,
			@Param("example") TSpecialfieldinfoExample example);

	int updateByPrimaryKeySelective(TSpecialfieldinfo record);

	int updateByPrimaryKey(TSpecialfieldinfo record);

	int findCountByQueryVo(QueryVo vo);

	List<TSpecialfieldinfo> findSpecialFieldInfoListByQueryVo(QueryVo vo);

	List<QueryVo> findSpecialNumber();
}