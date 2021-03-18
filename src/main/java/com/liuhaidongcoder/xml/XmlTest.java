package com.liuhaidongcoder.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import java.io.File;

/**
 * @author Liu Haidong
 * @date 20/12/23
 */
public class XmlTest {
    public static void main(String[] args) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
        ClientsMeta clientsMeta = ((JAXBElement<ClientsMeta>)jaxbContext.createUnmarshaller().unmarshal(new File("/Users/liuhaidong/IdeaProjects/Demo/src/main/java/com/liuhaidongcoder/xml/configuration.xsd.xml"))).getValue();
        System.out.println(clientsMeta.getClient().get(0).getId());
    }
}
