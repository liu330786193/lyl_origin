package com.lyl.dao;

import com.lyl.pojo.PubBank;

public interface PubBankDAO {
    int deleteByPrimaryKey(Long id);

    int insert(PubBank record);

    int insertSelective(PubBank record);

    PubBank selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PubBank record);

    int updateByPrimaryKey(PubBank record);
}