package com.gen.demo.assist;

import com.gen.demo.BeanUtils;
import com.gen.demo.ConfigData;
import com.gen.demo.Main;


/**
 *
 * DSV: DAO-SERVICE-VELOCITY
 * @author fanhaibo
 * @date 2018年06月10日12:11:34
 * @version 1.0.0 snapshot
 *
 */

public class DaoAndServicePathInfo {


    //获取项目根绝对路径
    private static String absPath = System.getProperty("user.dir");
    //获取运行时绝对路径
    private static String classFileAbsPath = DaoAndServicePathInfo.class.getResource("/").getPath();
    // 运行时当前包路径 com.google.generator
    private static String packagePath = Main.class.getPackage().getName();// com.google.generator
    // com/google/generator
    private static String packagePath_ = packagePath.replaceAll("\\.", "/");

    /**
     * 目前只处理maven结构: 选择绝对路径参数 /src/main/java/  OR /src/test/java/
     */
    private static final String PROJECT_VALUE = classFileAbsPath.contains(BeanUtils.PROJECT_TEST_PATH) ?
            ConfigData.DEF_PROJECT_TEST_PATH.getValue() : ConfigData.DEF_PROJECT_PATH.getValue();

    private static final String PROJECT_DESC = ConfigData.DEF_PROJECT_PATH.getDesc();
    public static Bean cacheMap = new Bean();

    static {

        System.out.println("\t\t\t#################################################");
        System.out.println("\t\t\t#################################################");
        System.out.println("\t\t\t######\t\t\t" + PROJECT_VALUE + "\t\t\t\t\t#");
        System.out.println("\t\t\t######\t\t\t" + PROJECT_DESC + "\t#");
        System.out.println("\t\t\t#################################################");
        System.out.println("\t\t\t#################################################");

        cacheMap.put(PathKeyManager.CLASS_RUNTIME_ABS_PATH, classFileAbsPath)
                .put(PathKeyManager.PROJECT_ABS_PATH, absPath)
                .put(PathKeyManager.PACKAGE_PATH, packagePath)
                .put(PathKeyManager.PACKAGE_PATH_, packagePath_);
    }


    public static String getAbsPath() {
        return absPath;
    }

    public static String getPackagePath_() {
        return packagePath_;
    }

    public static String getFilePackagePath() {
        return packagePath;
    }

    /**
     * @return UserServiceImpl.java path eg: /Users/van/src/main/java/com/google/generator/service/impl
     */
    public static String getFileAbsPath(String configData, String dsName) {
        String fileAbsPath = absPath + PROJECT_VALUE + packagePath_ + configData;
        cacheMap.put(dsName, fileAbsPath);
        return fileAbsPath;
    }

    /**
     * filePath=/Users/van/src/main/java/com/google/generator/service/impl
     *
     * @return 把对应的分层路径变成文件的 package eg: com.google.generator.service.impl
     */
    public static String toJavaPackage(String filePath) {
        String package_ = filePath.split(PROJECT_VALUE)[1].replaceAll("/", "\\.");
        String finalPackage = package_.substring(0, package_.length() - 1);
        return finalPackage;
    }

}