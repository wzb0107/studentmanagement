package cn.edu.hhuwtian.dao;

import cn.edu.hhuwtian.pojo.TStudentselectcourseinfo;
import cn.edu.hhuwtian.pojo.TStudentselectcourseinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TStudentselectcourseinfoMapper {
    int countByExample(TStudentselectcourseinfoExample example);

    int deleteByExample(TStudentselectcourseinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TStudentselectcourseinfo record);

    int insertSelective(TStudentselectcourseinfo record);

    List<TStudentselectcourseinfo> selectByExample(TStudentselectcourseinfoExample example);

    TStudentselectcourseinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TStudentselectcourseinfo record, @Param("example") TStudentselectcourseinfoExample example);

    int updateByExample(@Param("record") TStudentselectcourseinfo record, @Param("example") TStudentselectcourseinfoExample example);

    int updateByPrimaryKeySelective(TStudentselectcourseinfo record);

    int updateByPrimaryKey(TStudentselectcourseinfo record);
}