package com.liuhaidongcoder.configure;

/**
 * @author Liu Haidong
 * @date 20/12/23
 */
public class ConfigurationCenter {
    private Object object;
    public ConfigurationCenter(ConfigParserTypeEunm configParserTypeEunm,String configPath) {
        ConfigParserFactory.getConfigParser(configParserTypeEunm).parse(configPath);
    }

}
