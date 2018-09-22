package com.gen.model;


import com.gen.util.FieldUtils;
import com.gen.util.StringFormatUtil;
import org.apache.commons.lang.StringUtils;

/**
 * @author stefan
 * @version 0.0.1
 * @email my_email@gmail.com>
 * @date 2018-09-21
 */
public class TableInfo {


    //字段名称
    private String columnName;
    private String columnName30;//定长
    private String columnNameComma30;//逗号,定长
    private String columnNameQuota30;//引号,定长
    private String columnNameQuotaComma30;//引号,逗号,定长
    private String gsetter; //驼峰且首字母大写
    private String colNameHump;//驼峰
    private String colNameHumpQuota30;//驼峰,引号,定长
    private String colNameHumpQuotaComma30;//驼峰,引号,逗号,定长
    private String colNameSymbolHumpComma30;//#号,驼峰,逗号,定长

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


    public String getColumnName30() {
        return StringFormatUtil.getFormat30(columnName);
    }

    public void setColumnName30(String columnName30) {
        this.columnName30 = columnName30;
    }

    public String getColumnNameQuota30() {
        return StringFormatUtil.getQuotaFormat30(columnName);
    }

    public void setColumnNameQuota30(String columnNameQuota30) {
        this.columnNameQuota30 = columnNameQuota30;
    }

    public String getColumnNameQuotaComma30() {
        return StringFormatUtil.getQuotaFormat30(columnName) + ",";
    }

    public void setColumnNameQuotaComma30(String columnNameQuotaComma30) {
        this.columnNameQuotaComma30 = columnNameQuotaComma30;
    }

    public String getColNameHumpQuota30() {
        String hump = FieldUtils.lineToHump(columnName);
        return StringFormatUtil.getQuotaFormat30(hump);
    }

    public void setColNameHumpQuota30(String colNameHumpQuota30) {
        this.colNameHumpQuota30 = colNameHumpQuota30;
    }

    public String getColNameHumpQuotaComma30() {
        if (StringUtils.isNotBlank(colNameHumpQuotaComma30)) {
            return colNameHumpQuotaComma30;
        }
        String hump = FieldUtils.lineToHump(columnName);
        return StringFormatUtil.getQuotaFormat30(hump) + ",";
    }

    public void setColNameHumpQuotaComma30(String colNameHumpQuotaComma30) {
        this.colNameHumpQuotaComma30 = colNameHumpQuotaComma30;
    }

    public String getColNameSymbolHumpComma30() {

        if (StringUtils.isNotBlank(colNameSymbolHumpComma30)) {
            return colNameSymbolHumpComma30;
        }
        String hump = FieldUtils.lineToHump(columnName);
        return StringFormatUtil.getSymbolFormat30(hump) + ",";
    }

    public void setColNameSymbolHumpComma30(String colNameSymbolHumpComma30) {
        this.colNameSymbolHumpComma30 = colNameSymbolHumpComma30;
    }

    public String getColumnNameComma30() {
        if (StringUtils.isNotBlank(columnNameComma30)) {
            return columnNameComma30;
        }
        return StringFormatUtil.getFormat30(columnName) + ",";
    }

    public void setColumnNameComma30(String columnNameComma30) {
        this.columnNameComma30 = columnNameComma30;
    }
}