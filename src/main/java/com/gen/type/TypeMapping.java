package com.gen.type;

/**
 * @author fanhbon2018/9/21
 * @desc jdbc-java对应关系
 */
public enum TypeMapping {

    VARCHAR("java.lang.String", "String", "desc"),
    CHAR("java.lang.String", "char", "desc"),
    BLOB("java.lang.byte[]", "byte[]", "desc"),
    INTEGER("java.lang.Long", "Long", "desc"),
    TINYINT("java.lang.Integer", "Integer", "desc"),
    SMALLINT("java.lang.Integer", "Integer", "desc"),
    MEDIUMINT("java.lang.Integer", "Integer", "desc"),
    BIT("java.lang.Boolean", "Boolean", "desc"),
    BIGINT("java.math.BigInteger", "BigInteger", "desc"),
    FLOAT("java.lang.Float", "Float", "desc"),
    DOUBLE("java.lang.Double", "Double", "desc"),
    DECIMAL("java.math.BigDecimal", "BigDecimal", "desc"),
    DATE("java.util.Date", "Date", "desc"),
    TIME("java.util.Date", "Date", "desc"),
    DATETIME("java.util.Date", "Date", "desc"),
    TIMESTAMP("java.util.Date", "Date", "desc"),
    YEAR("java.util.Date", "Date", "desc");

    private String path;
    private String type;
    private String desc;

    TypeMapping(String path, String type, String desc) {
        this.path = path;
        this.type = type;
        this.desc = desc;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static TypeMapping getJavaType(String jdbcType) {
        for (TypeMapping typeMapping : TypeMapping.values()) {
            if (typeMapping.name().equalsIgnoreCase(jdbcType)){
                return typeMapping;
            }
        }
        return VARCHAR;
    }

}
