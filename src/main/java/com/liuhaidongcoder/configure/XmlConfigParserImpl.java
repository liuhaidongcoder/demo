package com.liuhaidongcoder.configure;

import com.liuhaidongcoder.xml.ClientsMeta;
import com.liuhaidongcoder.xml.ObjectFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import java.io.File;

/**
 * @author Liu Haidong
 * @date 20/12/23
 */
public class XmlConfigParserImpl implements IConfigParser {
    @Override
    public Object parse(String configPath) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
            ClientsMeta clientsMeta = ((JAXBElement<ClientsMeta>)jaxbContext.createUnmarshaller().unmarshal(new File(configPath))).getValue();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
