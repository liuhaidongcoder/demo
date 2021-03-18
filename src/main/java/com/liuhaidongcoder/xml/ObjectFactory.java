//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.12.23 时间 03:08:08 PM CST 
//


package com.liuhaidongcoder.xml;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.liuhaidongcoder.xml package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Clients_QNAME = new QName("http://www.58.com/eic/olap", "clients");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.liuhaidongcoder.xml
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ClientsMeta }
     * 
     */
    public ClientsMeta createClientsMeta() {
        return new ClientsMeta();
    }

    /**
     * Create an instance of {@link ServiceMeta }
     * 
     */
    public ServiceMeta createServiceMeta() {
        return new ServiceMeta();
    }

    /**
     * Create an instance of {@link ClientMeta }
     * 
     */
    public ClientMeta createClientMeta() {
        return new ClientMeta();
    }

    /**
     * Create an instance of {@link AppMeta }
     * 
     */
    public AppMeta createAppMeta() {
        return new AppMeta();
    }

    /**
     * Create an instance of {@link PropertyMeta }
     * 
     */
    public PropertyMeta createPropertyMeta() {
        return new PropertyMeta();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClientsMeta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.58.com/eic/olap", name = "clients")
    public JAXBElement<ClientsMeta> createClients(ClientsMeta value) {
        return new JAXBElement<ClientsMeta>(_Clients_QNAME, ClientsMeta.class, null, value);
    }

}
