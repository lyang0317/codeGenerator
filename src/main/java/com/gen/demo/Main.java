package com.gen.demo;

import com.gen.demo.assist.DSV;
import com.gen.demo.assist.DaoAndServicePathInfo;
import org.junit.Test;

import java.io.File;

/**
 * @date 2013-3-10
 *
 * @author fanhaibo (2018年06月10日) and hongten (2013-3-10)
 * @date 2018年06月10日12:11:34
 * @version 1.0.0 snapshot
 *
 */
public class Main {

    private static Main ins = new Main();

    public static void main(String[] args) throws Exception {

        BeanUtils beanUtils = new BeanUtils();
        ins.beanTool(beanUtils, "User");
    }

    /**
     * 根据bean生成相应的文件
     *
     * @param beanUtils
     * @param targetEntity eg: User--> UserDao,UserDaoImpl,UserService,UserServiceImpl
     * @throws Exception
     */
    public void beanTool(BeanUtils beanUtils, String targetEntity) throws Exception {
        beanUtils.createBeanFiles(targetEntity, DSV.DAO);
        beanUtils.createBeanFiles(targetEntity,DSV.SERVICE);

    }
}







