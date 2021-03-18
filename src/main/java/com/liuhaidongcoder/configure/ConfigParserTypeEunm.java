package com.liuhaidongcoder.configure;

/**
 * @author Liu Haidong
 * @date 20/12/23
 */
public enum ConfigParserTypeEunm {
    // XML配置解析类型
    XML("xml"),
    // YML配置解析类型
    YML("yml");
    private String type;
    ConfigParserTypeEunm(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
}
