package com.liuhaidongcoder.configure;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Liu Haidong
 * @date 20/12/23
 */
public class ConfigParserFactory {
    private static Map<String,IConfigParser> configParserCache = new HashMap<String,IConfigParser>();
    static {
        configParserCache.put(ConfigParserTypeEunm.XML.getType(),new XmlConfigParserImpl());
        configParserCache.put(ConfigParserTypeEunm.YML.getType(),new YmlConfigParserImpl());
    }
    public static IConfigParser getConfigParser(ConfigParserTypeEunm configParserTypeEunm){
        return configParserCache.get(configParserTypeEunm.getType());
    }
}
