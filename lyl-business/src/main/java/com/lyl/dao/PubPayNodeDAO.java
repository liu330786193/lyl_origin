package com.lyl.dao;

import com.lyl.pojo.PubPayNode;

import java.util.List;

public interface PubPayNodeDAO {
    int deleteByPrimaryKey(Long id);

    int insert(PubPayNode record);

    int insertSelective(PubPayNode record);

    PubPayNode selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PubPayNode record);

    int updateByPrimaryKey(PubPayNode record);

    List<PubPayNode> selectAll();

}