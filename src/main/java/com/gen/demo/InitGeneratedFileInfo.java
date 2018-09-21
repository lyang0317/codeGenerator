package com.gen.demo;

import com.gen.core.GeneratorJavaFileUtils;
import com.gen.model.GeneratedFileInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fanhaibo (2018年06月10日) and hongten (2013-3-10)
 * @version 1.0.0 snapshot
 * @date 2013-3-10
 * @date 2018年06月10日12:11:34
 */
public class InitGeneratedFileInfo {

    public static final GeneratedFileInfo DAO = new GeneratedFileInfo();
    public static final GeneratedFileInfo DAO_IMPL = new GeneratedFileInfo();
    public static final GeneratedFileInfo SERVICE = new GeneratedFileInfo();
    public static final GeneratedFileInfo SERVICE_IMPL = new GeneratedFileInfo();
    public static final GeneratedFileInfo MODEL = new GeneratedFileInfo();
    public static final GeneratedFileInfo XML = new GeneratedFileInfo();


    private static final List<GeneratedFileInfo> fileInfoList = new ArrayList<>();
    static {

        //生成dao代码
        DAO.setJavaSuffix("Dao.java");
        DAO.setVmName("beanDao.vm");
        //生成dao代码
        DAO_IMPL.setJavaSuffix("DaoImpl.java");
        DAO_IMPL.setVmName("beanDaoImpl.vm");

        SERVICE.setJavaSuffix("Service.java");
        SERVICE.setVmName("beanService.vm");

        SERVICE_IMPL.setJavaSuffix("ServiceImpl.java");
        SERVICE_IMPL.setVmName("beanServiceImpl.vm");

        MODEL.setJavaSuffix("Entity.java");
        MODEL.setVmName("beanEntity.vm");

        XML.setJavaSuffix("-Mapper.xml");
        XML.setVmName("bean.xml.vm");



        fileInfoList.add(DAO);
        fileInfoList.add(DAO_IMPL);
        fileInfoList.add(SERVICE);
        fileInfoList.add(SERVICE_IMPL);
        fileInfoList.add(MODEL);
        fileInfoList.add(MODEL);
    }

    public static void initGeneratedFileInfo(GeneratorJavaFileUtils generatorJavaFileUtils, String targetEntity) {

//        MODEL.setModelInfoMap("column_name","字段名称");
//        MODEL.setModelInfoMap("column_comment","字段注释");
//        MODEL.setModelInfoMap("data_type","数据类型");

        for (GeneratedFileInfo generatedFileInfo : fileInfoList) {
            generatedFileInfo.setDesc("desc");
            generatedFileInfo.setJavaFilePath("/genFile/");
        }

        generatorJavaFileUtils.createBeanFiles(targetEntity, InitGeneratedFileInfo.DAO);
        generatorJavaFileUtils.createBeanFiles(targetEntity, InitGeneratedFileInfo.DAO_IMPL);
        generatorJavaFileUtils.createBeanFiles(targetEntity, InitGeneratedFileInfo.SERVICE);
        generatorJavaFileUtils.createBeanFiles(targetEntity, InitGeneratedFileInfo.SERVICE_IMPL);
        generatorJavaFileUtils.createBeanFiles(targetEntity, InitGeneratedFileInfo.MODEL);
    }








}







