package com.gen.demo.assist;

/**
 * JVP: javaFile, velocity, path
 *
 * @author fanhaibo
 * @version 1.0.0 snapshot
 * @date 2018年06月10日12:11:34
 */

public class JVP {


    String JavaSuffix;//dao/service interface suffix
    String javaFilePath;//dao/service interface's path
    String vmName; //dao/service velocity file name
    String desc; //remark

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
}