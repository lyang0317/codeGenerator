package com.gen.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gen.demo.assist.*;
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


/**
 * @date 2013-3-10
 *
 * @author fanhaibo (2018年06月10日) and hongten (2013-3-10)
 * @date 2018年06月10日12:11:34
 * @version 1.0.0 snapshot
 *
 */

public class BeanUtils {


    private static String DAO_FLAG = DSV.DAO.toString();
    private static String SERVICE_FLAG = DSV.SERVICE.toString();


    public static String PROJECT_PATH = ConfigData.PROJECT_PATH.getValue();// /target/classes/
    public static String PROJECT_TEST_PATH = ConfigData.PROJECT_TEST_PATH.getValue();//SpringBoot

    private static Bean bean = new Bean();
    private static Annotation annotation = new Annotation();

    /**
     * 创建bean的Service的实现<br>
     *
     * @throws Exception
     */

    public void createBeanFiles(String entityName, DSV daoDsv) throws Exception {
        initVMParameters(entityName, daoDsv);

        createDsFiles(entityName, daoDsv);
        createDsImplFiles(entityName, daoDsv);
    }

    private void initVMParameters(String entityName, DSV dsv) {
        bean.setLowerName(getLowercaseChar(entityName));
        annotation.setAuthorName(ConfigData.AUTHOR_NAME.getValue());
        annotation.setAuthorMail(ConfigData.AUTHOR_MAIL.getValue());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ConfigData.DATE_FORMAT.getValue());
        annotation.setDate(simpleDateFormat.format(new Date()));
        annotation.setVersion(ConfigData.VERSION.getValue());
        bean.setName(entityName);
        bean.setBeanUrl(entityName);

        String daoPath = DaoAndServicePathInfo.getFileAbsPath(dsv.getDSPath_(), dsv.getDS());
        String daoImplPath = DaoAndServicePathInfo.getFileAbsPath(dsv.getDSImplPath_(), dsv.getDSImpl());

        String daoPackage = DaoAndServicePathInfo.toJavaPackage(daoPath);
        String daoImplPackage = DaoAndServicePathInfo.toJavaPackage(daoImplPath);

        if (DAO_FLAG.equalsIgnoreCase(dsv.toString())) {
            bean.setBeanDaoUrl(daoPackage);
            bean.setBeanDaoImplUrl(daoImplPackage);
        } else if (SERVICE_FLAG.equalsIgnoreCase(dsv.toString())) {
            bean.setBeanServiceUrl(daoPackage);
            bean.setBeanServiceImplUrl(daoImplPackage);
        } else {
            //TODO
        }


    }

    private void createDsFiles(String entityName, DSV dsv) {
        String absPath_ = dsv.getDSPath_();
        String vmName = dsv.getVmName();
        String packagePath = dsv.getDS();
        doCreateFiles(entityName, absPath_, packagePath, vmName, dsv);
    }

    private void createDsImplFiles(String entityName, DSV dsv) {
        String dsImplPath_ = dsv.getDSImplPath_();
        String vmImplName = dsv.getVmImplName();
        String dsImpl = dsv.getDSImpl();
        doCreateFiles(entityName, dsImplPath_, dsImpl, vmImplName, dsv);
    }

    private void doCreateFiles(String entityName, String path_, String packagePath, String vmName, DSV dsv) {


        //
        try {

            String absPath = DaoAndServicePathInfo.getFileAbsPath(path_,
                    path_.contains("impl") ? dsv.getDSImpl() : dsv.getDS());

            File filePath = new File(absPath);
            //创建目录
            createFilePath(filePath);
            //创建文件
            String fileName = absPath + entityName + packagePath;
            File file = new File(fileName);
            FileWriter fw = new FileWriter(file);

            String GeneratedCodeFile = createCodeByVelocity(vmName, bean, annotation);
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
     * @param fileVMPath 模板路径
     * @param bean       目标bean
     * @param annotation 注释
     * @return
     * @throws Exception
     */
    private String createCodeByVelocity(String fileVMPath, Bean bean, Annotation annotation) throws Exception {
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty("input.encoding", "UTF-8");
        velocityEngine.setProperty("output.encoding", "UTF-8");
        if (PROJECT_PATH.equals(ConfigData.DEF_PROJECT_PATH.getValue()) || "MAVEN".equalsIgnoreCase(ConfigData.PROJECT_NAME.getValue())) {
            velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
            velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        }
        velocityEngine.init();
        Template template = velocityEngine.getTemplate(fileVMPath);
        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("bean", bean);
        velocityContext.put("annotation", annotation);
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
        System.out.println("====json======start====");
        System.out.println("\t所有的路径信息如下: ");
        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println();
            String json = mapper.writeValueAsString(DaoAndServicePathInfo.cacheMap);
            JsonFormatter.printFormattingJson(json);
            System.out.println();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("====json======end======");
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

