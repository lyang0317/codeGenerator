package com.gen.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gen.config.ConfigData;
import com.gen.model.*;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @author fanhaibo (2018年06月10日) and hongten (2013-3-10)
 * @version 1.0.0 snapshot
 * @date 2013-3-10
 * @date 2018年06月10日12:11:34
 */

public class GeneratorJavaFileUtils {


    public static String PROJECT_PATH = ConfigData.PROJECT_PATH.getValue();// /target/classes/
    public static String PROJECT_TEST_PATH = ConfigData.PROJECT_TEST_PATH.getValue();//SpringBoot

    private static FileInfo fileInfo = new FileInfo();
    private List<TableInfo> dataList;
    private String tabName;
    private static DeveloperInfo developerInfo = new DeveloperInfo();
    public static String tableInfoJson;
    public GeneratorJavaFileUtils(List<TableInfo> dataList, String tabName) {
        this.dataList = dataList;
        this.tabName = tabName;
    }

    /**
     * 创建bean的Service的实现<br>
     *
     * @throws Exception
     */

    public void createBeanFiles(String entityName, GeneratedFileInfo daoGeneratedFileInfo) {
        initVMParameters(entityName, daoGeneratedFileInfo);

        doCreateFiles(entityName, daoGeneratedFileInfo);
    }

    private void initVMParameters(String entityName, GeneratedFileInfo GeneratedFileInfo) {
        fileInfo.setLowerName(getLowercaseChar(entityName));
        developerInfo.setAuthorName(ConfigData.AUTHOR_NAME.getValue());
        developerInfo.setAuthorMail(ConfigData.AUTHOR_MAIL.getValue());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ConfigData.DATE_FORMAT.getValue());
        developerInfo.setDate(simpleDateFormat.format(new Date()));
        developerInfo.setVersion(ConfigData.VERSION.getValue());
        fileInfo.setName(entityName);
        fileInfo.setTabName(tabName);

        //处理路径, 把文件放到指定位置
        String absPath = PathInfo.getFileAbsPath(GeneratedFileInfo.getJavaFilePath(), GeneratedFileInfo.getJavaSuffix());
        String packagePath = PathInfo.toJavaPackage(absPath);


        fileInfo.setBeanDaoUrl(packagePath);


    }

    private void doCreateFiles(String entityName, GeneratedFileInfo gfi) {
        //
        try {
            String absPath = PathInfo.getFileAbsPath(gfi.getJavaFilePath(), gfi.getJavaSuffix());

            File filePath = new File(absPath);
            //创建目录
            createFilePath(filePath);
            //创建文件
            String fileName = absPath + entityName + gfi.getJavaSuffix();
            File file = new File(fileName);
            FileWriter fw = new FileWriter(file);

            String pkgPath = PathInfo.packagePath + gfi.getJavaFilePath() + gfi.getEntityName();
            pkgPath = pkgPath.replaceAll("/",".");
            gfi.setPkgPathEntityName(pkgPath);
            String GeneratedCodeFile = createCodeByVelocity(gfi.getVmName(), fileInfo, developerInfo);
            fw.write(GeneratedCodeFile);
            fw.flush();
            fw.close();
            showInfo(fileName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 根据模板生成代码
     *
     * @param vmName 模板路径
     * @param fileInfo       目标bean
     * @param developerInfo 注释
     * @return
     * @throws Exception
     */
    private String createCodeByVelocity(String vmName, FileInfo fileInfo, DeveloperInfo developerInfo) throws Exception {

        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty("input.encoding", "UTF-8");
        velocityEngine.setProperty("output.encoding", "UTF-8");
        if (PROJECT_PATH.equals(ConfigData.DEF_PROJECT_PATH.getValue()) || "MAVEN".equalsIgnoreCase(ConfigData.PROJECT_NAME.getValue())) {
            velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
            velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        }
        velocityEngine.init();
        Template template = velocityEngine.getTemplate(vmName);
        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("fileInfo", fileInfo);
        velocityContext.put("developerInfo", developerInfo);


        for (TableInfo tableInfo : dataList) {
            tableInfo.setTabName(tabName);
        }

        /** 处理最后一个逗号 */
        TableInfo tableInfo = dataList.get(dataList.size() - 1);
        tableInfo.setColNameHumpQuotaComma30(tableInfo.getColNameHumpQuota30());
        tableInfo.setColNameSymbolHumpComma30(tableInfo.getColNameSymbolHump30());
        tableInfo.setColumnNameComma30(tableInfo.getColumnName30());
        tableInfo.setColumnNameQuotaComma30(tableInfo.getColumnNameQuota30());
//        velocityContext.put("map", map);

        //生成文件需要的主要数据
        velocityContext.put("dataList", dataList);

        tableInfoJson = new ObjectMapper().writeValueAsString(dataList);
        StringWriter stringWriter = new StringWriter();
        template.merge(velocityContext, stringWriter);
        return stringWriter.toString();

    }

    /**
     * 创建文件
     *
     * @param file
     */
    private void createFilePath(File file) {
        if (!file.exists()) {
            System.out.println("创建文件夹[" + file.getAbsolutePath() + "]情况：" + file.mkdirs());
        } else {
            System.out.println("存在文件夹：" + file.getAbsolutePath());
        }
    }

    /**
     * 把第一个字母变为小写<br>
     * 如：<br>
     * <code>str = "UserDao";</code><br>
     * <code>return "userDao";</code>
     *
     * @param str
     * @return
     */
    private String getLowercaseChar(String str) {
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    /**
     * 显示信息
     *
     * @param info
     */
    private void showInfo(String info) {
        System.out.println("创建文件：" + info + "成功！");
    }

    /**
     * 获取系统时间
     *
     * @return
     */
    private static String getDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ConfigData.DATE_FORMAT.getValue());
        return simpleDateFormat.format(new Date());
    }


}

