package com.gen.demo.assist;

/**
 * DSV: DAO-SERVICE-VELOCITY
 *
 * @author fanhaibo
 * @version 1.0.0 snapshot
 * @date 2018年06月10日12:11:34
 */

public class DSV {


    String DS;//dao/service interface suffix
    String DSPath;//dao/service interface's path
    String DSImpl; //dao/service implement
    String DSImplPath;//dao/service implement's path
    String vmName; //dao/service velocity file name
    String vmImplName; //ao/service implement velocity file name
    String desc; //remark

    String modelName;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public DSV() {

    }

//    DSV(String DS, String DSPath, String DSImpl, String DSImplPath, String vmName, String vmImplName, String desc) {
//        this.DS = DS;
//        this.DSPath = DSPath;
//        this.DSImpl = DSImpl;
//        this.DSImplPath = DSImplPath;
//        this.vmName = vmName;
//        this.vmImplName = vmImplName;
//        this.desc = desc;
//    }

    /**
     * @return //Dao.java
     */
    public String getDS() {
        return DS;
    }

    /**
     * @return /dao/
     */
    public String getDSPath() {//
        return DSPath;
    }

    /**
     * @return //DaoImpl.java
     */
    public String getDSImpl() {
        return DSImpl;
    }

    public String getDSImplPath() {
        return DSImplPath;
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

    public String getVmImplName() {
        return vmImplName;
    }

    public void setDS(String DS) {
        this.DS = DS;
    }

    public void setDSPath(String DSPath) {
        this.DSPath = DSPath;
    }

    public void setDSImpl(String DSImpl) {
        this.DSImpl = DSImpl;
    }

    public void setDSImplPath(String DSImplPath) {
        this.DSImplPath = DSImplPath;
    }

    public void setVmName(String vmName) {
        this.vmName = vmName;
    }

    public void setVmImplName(String vmImplName) {
        this.vmImplName = vmImplName;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}