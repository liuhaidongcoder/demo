package com.liuhaidongcoder.mybatis.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Liu Haidong
 * @date 20/12/7
 */
public enum ProfessionalEnum {
    //信息
    INFOR(1),
    //艺术
    ARTS(3);
    private int code;
    static Map<String,ProfessionalEnum> map = new HashMap<>();

    ProfessionalEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
    public static ProfessionalEnum getProfessionalEnumbyCode(int code){
        return map.get(String.valueOf(code));
    }
    static {
        for(ProfessionalEnum professionalEnum:ProfessionalEnum.values()){
            map.put(String.valueOf(professionalEnum.getCode()),professionalEnum);
        }
    }
}
