package com.lyl.ensure.extension;

import com.lyl.ensure.EnsureParam;
import com.lyl.exception.CExceptionFactory;

/**
 * Created by lyl on 2016/9/11.
 */
public class EnsureParamEnumExtension extends EnsureParam<Enum> {
    private Enum anEnum;

    public EnsureParamEnumExtension(Enum anEnum) {
        super(anEnum);
        this.anEnum = anEnum;
    }

    public EnsureParamEnumExtension isEqual(Enum comparedEnum, String errorCode) {
        if(this.anEnum != comparedEnum) {
            throw CExceptionFactory.create(errorCode, new String[0]);
        } else {
            return this;
        }
    }

    public EnsureParamEnumExtension isNotEqual(Enum comparedEnum, String errorCode) {
        if(this.anEnum == comparedEnum) {
            throw CExceptionFactory.create(errorCode, new String[0]);
        } else {
            return this;
        }
    }

    public EnsureParamEnumExtension isNotNull(String errorCode) {
        if(this.anEnum == null) {
            throw CExceptionFactory.create(errorCode, new String[0]);
        } else {
            return this;
        }
    }
}
