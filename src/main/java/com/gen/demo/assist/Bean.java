package com.gen.demo.assist;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author fanhaibo (2018年06月10日)
 * @date 2018年06月10日12:11:34
 * @version 1.0.0 snapshot
 *
 */
public class Bean {


    private static final Map<String,Object> map = new HashMap<>();
    /**
     * bean 名称
     */
    private String name;
    /**
     * bean 首字母小写名称
     */
    private String lowerName;
    /**
     * bean 路径
     */
    private String beanUrl;
    private String beanDaoUrl;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setLowerName(String lowerName) {
        this.lowerName = lowerName;
    }

    public String getBeanUrl() {
        return beanUrl;
    }

    public void setBeanName(String beanUrl) {
        this.beanUrl = beanUrl;
    }

    public String getBeanDaoUrl() {
        return beanDaoUrl;
    }

    public void setBeanDaoUrl(String beanDaoUrl) {
        this.beanDaoUrl = beanDaoUrl;
    }

    public Bean put(String key, Object value) {
        map.put(key, value);
        return this;
    }
}


