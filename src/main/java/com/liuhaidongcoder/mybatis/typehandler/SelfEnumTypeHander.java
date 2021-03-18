package com.liuhaidongcoder.mybatis.typehandler;

import com.liuhaidongcoder.mybatis.enums.ProfessionalEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Liu Haidong
 * @date 20/12/7
 */

public class SelfEnumTypeHander extends BaseTypeHandler<ProfessionalEnum> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, ProfessionalEnum parameter, JdbcType jdbcType) throws SQLException {
       ps.setInt(i,parameter.getCode());

    }
    @Override
    public ProfessionalEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int s = rs.getInt(columnName);
        return ProfessionalEnum.getProfessionalEnumbyCode(s);
    }
    @Override
    public ProfessionalEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int s = rs.getInt(columnIndex);
        return ProfessionalEnum.getProfessionalEnumbyCode(s);
    }
    @Override
    public ProfessionalEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int s = cs.getInt(columnIndex);
        return ProfessionalEnum.getProfessionalEnumbyCode(s);
    }
}
