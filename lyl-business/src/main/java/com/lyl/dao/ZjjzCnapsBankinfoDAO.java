package com.lyl.dao;

import com.lyl.pojo.ZjjzCnapsBankinfo;

public interface ZjjzCnapsBankinfoDAO {
    int deleteByPrimaryKey(Long id);

    int insert(ZjjzCnapsBankinfo record);

    int insertSelective(ZjjzCnapsBankinfo record);

    ZjjzCnapsBankinfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ZjjzCnapsBankinfo record);

    int updateByPrimaryKey(ZjjzCnapsBankinfo record);
}