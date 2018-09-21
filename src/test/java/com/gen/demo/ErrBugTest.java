package com.gen.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gen.mapper.TableInfo;
import com.gen.service.ErrBugTogetherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Map;

/**
 * @author fanhb on 2018/9/21
 * @desc xxxx
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ErrBugTest {
    @Autowired
    private ErrBugTogetherService errBugTogetherService;

    /**
     * 测试从数据库获取表的描述数据
     *
     * @throws JsonProcessingException
     */
    @Test
    public void getAllTest() throws JsonProcessingException {
        String tabName = "keyvalue_job";
        String dbName = "axiom";
        List<TableInfo> columnInfo = errBugTogetherService.getColumnInfo(tabName, dbName);
        String json = new ObjectMapper().writeValueAsString(columnInfo);
        System.err.println(json);

        boolean empty = ObjectUtils.isEmpty(columnInfo);
        assert (false == empty);

    }

}
