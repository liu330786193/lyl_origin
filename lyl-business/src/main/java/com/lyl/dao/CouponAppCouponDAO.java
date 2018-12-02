package com.lyl.dao;

import com.lyl.db.Pager;
import com.lyl.pojo.CouponAppCoupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponAppCouponDAO {
    List<CouponAppCoupon> queryAllInfo(@Param("page") Pager<CouponAppCoupon> pager);
    Long getAllCount();
}