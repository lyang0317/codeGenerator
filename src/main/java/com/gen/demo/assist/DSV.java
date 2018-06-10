package com.gen.demo.assist;

/**
 *
 * DSV: DAO-SERVICE-VELOCITY
 * @author fanhaibo
 * @date 2018年06月10日12:11:34
 * @version 1.0.0 snapshot
 *
 */

public enum DSV {

    DAO("Dao.java", "/dao/", "DaoImpl.java", "/dao/impl/", "beanDao.vm", "beanDaoImpl.vm", "说明"),
    SERVICE("Service.java", "/service/", "ServiceImpl.java", "/service/impl/", "beanService.vm", "beanServiceImpl.vm", "说明");

    String DS;
    String DSPath_;
    String DSImpl;
    String DSImplPath_;
    String vmName;
    String vmImplName;
    String desc;

    DSV(String DS, String DSPath_, String DSImpl, String DSImplPath_, String vmName, String vmImplName, String desc) {
        this.DS = DS;
        this.DSPath_ = DSPath_;
        this.DSImpl = DSImpl;
        this.DSImplPath_ = DSImplPath_;
        this.vmName = vmName;
        this.vmImplName = vmImplName;
        this.desc = desc;
    }

    /**
     * @return //Dao.java
     */
    public String getDS() {
        return DS;
    }

    /**
     * @return /dao/
     */
    public String getDSPath_() {//
        return DSPath_;
    }

    /**
     * @return //DaoImpl.java
     */
    public String getDSImpl() {
        return DSImpl;
    }

    public String getDSImplPath_() {
        return DSImplPath_;
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
}