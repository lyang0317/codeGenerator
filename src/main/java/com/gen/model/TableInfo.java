package com.gen.model;


import com.gen.util.FieldUtils;

/**
 * @author stefan
 * @version 0.0.1
 * @email my_email@gmail.com>
 * @date 2018-09-21
 */
public class TableInfo {

    //字段名称
    private String columnName;
    private String colNameHump ;//驼峰
    private String gsetter; //驼峰切首字母大写
    //字段注释
    private String columnComment; 
    //数据类型,JDBC TYPE
    private String dataType;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getDataType() {
        return dataType;
    }

    public String getColNameHump() {

        return FieldUtils.lineToHump(columnName);
    }

    public void setColNameHump(String colNameHump) {
        this.colNameHump = colNameHump;
    }

    public String getGsetter() {
        String gSetter = FieldUtils.lineToHumpGSetter(columnName);
        return gSetter;
    }

    public void setGsetter(String gsetter) {
        this.gsetter = gsetter;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}