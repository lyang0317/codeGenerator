package com.gen.demo;

import com.gen.core.GeneratorJavaFileUtils;
import com.gen.model.GeneratedFileInfo;

/**
 * @author fanhaibo (2018年06月10日) and hongten (2013-3-10)
 * @version 1.0.0 snapshot
 * @date 2013-3-10
 * @date 2018年06月10日12:11:34
 */
public class Main {

    public static final GeneratedFileInfo DAO = new GeneratedFileInfo();
    public static final GeneratedFileInfo DAO_IMPL = new GeneratedFileInfo();
    public static final GeneratedFileInfo SERVICE = new GeneratedFileInfo();
    public static final GeneratedFileInfo SERVICE_IMPL = new GeneratedFileInfo();
    public static final GeneratedFileInfo MODEL = new GeneratedFileInfo();

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

        MODEL.setJavaSuffix("Entity.java");
        MODEL.setVmName("beanEntity.vm");
        MODEL.setDesc("说明");
        MODEL.setJavaFilePath("/genFile/");
    }

    private static Main ins = new Main();

    public static void main(String[] args) throws Exception {

        GeneratorJavaFileUtils generatorJavaFileUtils = new GeneratorJavaFileUtils();
        ins.beanTool(generatorJavaFileUtils, "User");
    }

    public void beanTool(GeneratorJavaFileUtils generatorJavaFileUtils, String targetEntity) throws Exception {

        MODEL.setModelInfoMap("column_name","字段名称");
        MODEL.setModelInfoMap("column_comment","字段注释");
        MODEL.setModelInfoMap("data_type","数据类型");



        generatorJavaFileUtils.createBeanFiles(targetEntity, Main.DAO);
        generatorJavaFileUtils.createBeanFiles(targetEntity, Main.DAO_IMPL);
        generatorJavaFileUtils.createBeanFiles(targetEntity, Main.SERVICE);
        generatorJavaFileUtils.createBeanFiles(targetEntity, Main.SERVICE_IMPL);
        generatorJavaFileUtils.createBeanFiles(targetEntity, Main.MODEL);
    }








}







