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

    static {

        //生成dao代码
        DAO.setJavaSuffix("Dao.java");
        DAO.setVmName("beanDao.vm");
        DAO.setDesc("说明");
        DAO.setJavaFilePath("/genFile/");


    }

    private static Main ins = new Main();

    public static void main(String[] args) throws Exception {

        BeanUtils beanUtils = new BeanUtils();
        ins.beanTool(beanUtils, "User");
    }

    public void beanTool(BeanUtils beanUtils, String targetEntity) throws Exception {
        beanUtils.createBeanFiles(targetEntity, Main.DAO);
    }
}







