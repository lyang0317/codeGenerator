#基于velocity的代码生成器 , 连接mysql, 通过数据库表生成实体类和注释,service等

第一步: 修改数据库连接,连接用户,和密码 
```
    --/resource/application-dev.xml
    --url: jdbc:mysql://127.0.0.1:3306/axiom?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&useSSL=false
```

第二步: 修改数据库名称,表名,java文件头的作者,邮箱
```
    --String dbName = "axiom"; // 数据库名称
    --String tabName = "keyvalue_job"; //表名
    --ConfigData.setAuthorName("zhanSan");
    --ConfigData.setAuthorMail("zhanSan@gmail.com");
```  

第三步: 用junit运行代码直接生成代码
```
    --被生成代码的位置: /test/java/com.gen.generator.genFile
   
