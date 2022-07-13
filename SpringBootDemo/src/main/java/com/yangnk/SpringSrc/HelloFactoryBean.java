package com.yangnk.SpringSrc;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.lang.Nullable;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-04-29 16:26
 **/
public class HelloFactoryBean implements FactoryBean<Test0429a> {
    @Nullable
    @Override
    public Test0429a getObject() throws Exception {
        Test0429a test0429a = new Test0429a();
        return test0429a;
    }

    @Nullable
    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
