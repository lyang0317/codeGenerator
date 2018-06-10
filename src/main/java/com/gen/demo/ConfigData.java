package com.gen.demo;




/**
 * @date 2013-3-10
 *
 * @author fanhaibo (2018年06月10日)
 * @date 2018年06月10日12:11:34
 * @version 1.0.0 snapshot
 */
public enum ConfigData {

    /**
     * @code /Users/van/wiser/generator/${DEF_PROJECT_PATH}/com/gen/demo/dao/impl/UserDaoImpl.java 等效于下面这个路径
     * @eg /Users/van/wiser/generator/src/main/java/com/gen/demo/dao/impl/UserDaoImpl.java
     * @desc 该demo适用于maven结构的项目, 非maven项目需要修改这个路径参数
     * @eg : SpringBoot
     *
     * /src/main/test/ 放在测试路径下也应该修该参数
     */
    DEF_PROJECT_PATH("/src/main/java/", "MAVEN 非测试类的项目绝对路径参数"),
    DEF_PROJECT_TEST_PATH("/src/test/java/", "MAVEN 测试类的项目绝对路径参数"),

    AUTHOR_NAME("java_author", "作者"),
    AUTHOR_MAIL("my_email@gmail.com", "邮箱"),
    VERSION("0.0.1", "版本号"),
    DATE_FORMAT("yyyy-MM-dd", "日期格式化样式"),


    // 非springBoot可能需要修改这些参数, 主要是根据class文件位置来获取放置文件的绝对路径
    PROJECT_PATH("/target/classes/", "SpringBoot非测试代码中生成代码会用到的参数, 其他项目可能需要改这个参数"),
    PROJECT_TEST_PATH("/target/test-classes/", "SpringBoot测试代码中生成代码会用到的参数, 其他项目可能需要改这个参数"),
    PROJECT_NAME("MAVEN", "MAVEN 项目");

    private String value;
    private String desc;

    ConfigData(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}