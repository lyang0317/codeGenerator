package com.gen.demo;

import com.gen.demo.assist.JVP;

/**
 * @author fanhaibo (2018年06月10日) and hongten (2013-3-10)
 * @version 1.0.0 snapshot
 * @date 2013-3-10
 * @date 2018年06月10日12:11:34
 */
public class Main {

    public static final JVP DAO = new JVP();
    public static final JVP DAO_IMPL = new JVP();
    public static final JVP SERVICE = new JVP();
    public static final JVP SERVICE_IMPL = new JVP();

    static {

        //生成dao代码
        DAO.setJavaSuffix("Dao.java");
        DAO.setVmName("beanDao.vm");
        DAO.setDesc("说明");
        DAO.setJavaFilePath("/genFile/");
        //生成dao代码
        DAO_IMPL.setJavaSuffix("DaoImpl.java");
        DAO_IMPL.setVmName("beanDaoImpl.vm");
        DAO_IMPL.setDesc("说明");
        DAO_IMPL.setJavaFilePath("/genFile/");

        SERVICE.setJavaSuffix("Service.java");
        SERVICE.setVmName("beanService.vm");
        SERVICE.setDesc("说明");
        SERVICE.setJavaFilePath("/genFile/");

        SERVICE_IMPL.setJavaSuffix("ServiceImpl.java");
        SERVICE_IMPL.setVmName("beanServiceImpl.vm");
        SERVICE_IMPL.setDesc("说明");
        SERVICE_IMPL.setJavaFilePath("/genFile/");
    }

    private static Main ins = new Main();

    public static void main(String[] args) throws Exception {

        BeanUtils beanUtils = new BeanUtils();
        ins.beanTool(beanUtils, "User");
    }

    public void beanTool(BeanUtils beanUtils, String targetEntity) throws Exception {
        beanUtils.createBeanFiles(targetEntity, Main.DAO);
        beanUtils.createBeanFiles(targetEntity, Main.DAO_IMPL);
        beanUtils.createBeanFiles(targetEntity, Main.SERVICE);
        beanUtils.createBeanFiles(targetEntity, Main.SERVICE_IMPL);
    }
}







