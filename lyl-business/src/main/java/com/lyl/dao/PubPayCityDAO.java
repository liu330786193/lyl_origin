package com.lyl.dao;

import com.lyl.pojo.PubPayCity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PubPayCityDAO {
    int deleteByPrimaryKey(Long id);

    int insert(PubPayCity record);

    int insertSelective(PubPayCity record);

    PubPayCity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PubPayCity record);

    int updateByPrimaryKey(PubPayCity record);

    List<PubPayCity> selectByType(
            @Param("nodecode") String nodecode,
            @Param("areatype") String areatype
    );

    List<PubPayCity> selectByTypeAndAreaCode2(
            @Param("nodecode") String nodecode,
            @Param("areatype") String areatype,
            @Param("areacode2") String areacode2
    );

    List<PubPayCity> selectByTypeAndAreaCode3(
            @Param("nodecode") String nodecode,
            @Param("areatype") String areatype,
            @Param("areacode2") String areacode2,
            @Param("areacode3") String areacode3
    );

}