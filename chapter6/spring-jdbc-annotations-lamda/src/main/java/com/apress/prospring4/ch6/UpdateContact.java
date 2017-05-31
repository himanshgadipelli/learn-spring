package com.apress.prospring4.ch6;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

/**
 * Created by bobby on 4/11/2017.
 */
public class UpdateContact extends SqlUpdate {
    private static final String SQL_UPDATE_CONTACT =
            "UPDATE CONTACT SET FIRST_NAME = :FIRST_NAME, LAST_NAME = :LAST_NAME, BIRTH_DATE = :BIRTH_DATE WHERE ID = :ID";

    public UpdateContact(DataSource dataSource) {
        super(dataSource,SQL_UPDATE_CONTACT);
        super.declareParameter(new SqlParameter("FIRST_NAME", Types.VARCHAR));
        super.declareParameter(new SqlParameter("LAST_NAME", Types.VARCHAR));
        super.declareParameter(new SqlParameter("BIRTH_DATE", Types.DATE));
        super.declareParameter(new SqlParameter("ID", Types.INTEGER));
    }
}
