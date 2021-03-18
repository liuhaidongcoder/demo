package com.liuhaidongcoder.mybatis.factory;

import com.liuhaidongcoder.mybatis.dao.Student;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.Collection;
import java.util.List;
import java.util.Properties;

/**
 * @author Liu Haidong
 * @date 20/12/7
 */
public class ExampleObjectFactory extends DefaultObjectFactory {
    private Properties properties;
    @Override
    public Object create(Class type) {
        System.out.println(properties.getProperty("someProperty"));
            return super.create(type);
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        return super.create(type, constructorArgTypes, constructorArgs);
    }

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
        super.setProperties(properties);
    }
    @Override
    public <T> boolean isCollection(Class<T> type) {
        return Collection.class.isAssignableFrom(type);
    }
}
