package com.gen.demo.assist;

import java.util.HashMap;


/**
 * @date 2013-3-10
 *
 * @author fanhaibo (2018年06月10日) and hongten (2013-3-10)
 * @date 2018年06月10日12:11:34
 * @version 1.0.0 snapshot
 *
 */
public class Bean extends HashMap<String,Object> {

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
    /**
     * dao 路径
     */
    private String beanDaoUrl;
    /**
     * dao 实现路径
     */
    private String beanDaoImplUrl;
    /**
     * service 路径
     */
    private String beanServiceUrl;
    /**
     * service 实现路径
     */
    private String beanServiceImplUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLowerName() {
        return lowerName;
    }

    public void setLowerName(String lowerName) {
        this.lowerName = lowerName;
    }

    public String getBeanUrl() {
        return beanUrl;
    }

    public void setBeanUrl(String beanUrl) {
        this.beanUrl = beanUrl;
    }

    public String getBeanDaoUrl() {
        return beanDaoUrl;
    }

    public void setBeanDaoUrl(String beanDaoUrl) {
        this.beanDaoUrl = beanDaoUrl;
    }

    public String getBeanDaoImplUrl() {
        return beanDaoImplUrl;
    }

    public void setBeanDaoImplUrl(String beanDaoImplUrl) {
        this.beanDaoImplUrl = beanDaoImplUrl;
    }

    public String getBeanServiceUrl() {
        return beanServiceUrl;
    }

    public void setBeanServiceUrl(String beanServiceUrl) {
        this.beanServiceUrl = beanServiceUrl;
    }

    public String getBeanServiceImplUrl() {
        return beanServiceImplUrl;
    }

    public void setBeanServiceImplUrl(String beanServiceImplUrl) {
        this.beanServiceImplUrl = beanServiceImplUrl;
    }

    @Override
    public Bean put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}


