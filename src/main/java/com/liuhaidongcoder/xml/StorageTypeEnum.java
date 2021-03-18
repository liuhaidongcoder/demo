//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.12.23 时间 03:08:08 PM CST 
//


package com.liuhaidongcoder.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>storageTypeEnum的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="storageTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="REDIS"/>
 *     &lt;enumeration value="WTABLE"/>
 *     &lt;enumeration value="HBASE"/>
 *     &lt;enumeration value="MYSQL"/>
 *     &lt;enumeration value="TIDB"/>
 *     &lt;enumeration value="DORIS"/>
 *     &lt;enumeration value="CLICKHOUSE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "storageTypeEnum")
@XmlEnum
public enum StorageTypeEnum {

    REDIS,
    WTABLE,
    HBASE,
    MYSQL,
    TIDB,
    DORIS,
    CLICKHOUSE;

    public String value() {
        return name();
    }

    public static StorageTypeEnum fromValue(String v) {
        return valueOf(v);
    }

}
