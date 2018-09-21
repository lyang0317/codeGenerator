package com.gen.model;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * GeneratedFileInfo: javaFile, velocity, path
 *
 * @author fanhaibo
 * @version 1.0.0 snapshot
 * @date 2018年06月10日12:11:34
 */

public class GeneratedFileInfo {


    private String JavaSuffix;//dao/service interface suffix
    private String javaFilePath;//dao/service interface's path
    private String vmName; //dao/service velocity file name
    private String desc; //remark

    private Map<String, Object> modelInfoMap = new LinkedHashMap<>();

    /**
     * @return //Dao.java
     */
    public String getJavaSuffix() {
        return JavaSuffix;
    }

    /**
     * @return /dao/
     */
    public String getJavaFilePath() {//
        return javaFilePath;
    }

    /**
     * @return //baseDao.vm
     */
    public String getVmName() {
        return vmName;
    }

    public String getDesc() {
        return desc;
    }

    public void setJavaSuffix(String javaSuffix) {
        this.JavaSuffix = javaSuffix;
    }

    public void setJavaFilePath(String javaFilePath) {
        this.javaFilePath = javaFilePath;
    }

    public void setVmName(String vmName) {
        this.vmName = vmName;
    }


    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Map<String, Object> getModelInfoMap() {
        return modelInfoMap;
    }

    public void setModelInfoMap(String key, Object value) {
        this.modelInfoMap.put(key, value);
    }
}