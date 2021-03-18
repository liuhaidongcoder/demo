//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.12.23 时间 03:08:08 PM CST 
//


package com.liuhaidongcoder.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>serviceMeta complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="serviceMeta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="serviceName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="serviceStorageType" type="{http://www.58.com/eic/olap}storageTypeEnum"/>
 *         &lt;element name="desc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="property" type="{http://www.58.com/eic/olap}propertyMeta"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "serviceMeta", propOrder = {
    "serviceName",
    "serviceStorageType",
    "desc",
    "property"
})
public class ServiceMeta {

    @XmlElement(required = true)
    protected String serviceName;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected StorageTypeEnum serviceStorageType;
    protected String desc;
    @XmlElement(required = true)
    protected PropertyMeta property;

    /**
     * 获取serviceName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * 设置serviceName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceName(String value) {
        this.serviceName = value;
    }

    /**
     * 获取serviceStorageType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link StorageTypeEnum }
     *     
     */
    public StorageTypeEnum getServiceStorageType() {
        return serviceStorageType;
    }

    /**
     * 设置serviceStorageType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link StorageTypeEnum }
     *     
     */
    public void setServiceStorageType(StorageTypeEnum value) {
        this.serviceStorageType = value;
    }

    /**
     * 获取desc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 设置desc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesc(String value) {
        this.desc = value;
    }

    /**
     * 获取property属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PropertyMeta }
     *     
     */
    public PropertyMeta getProperty() {
        return property;
    }

    /**
     * 设置property属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PropertyMeta }
     *     
     */
    public void setProperty(PropertyMeta value) {
        this.property = value;
    }

}
