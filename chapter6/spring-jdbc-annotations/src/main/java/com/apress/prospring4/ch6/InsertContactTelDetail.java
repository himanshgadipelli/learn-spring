package com.apress.prospring4.ch6;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.BatchSqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

/**
 * Created by bobby on 4/11/2017.
 */
public class InsertContactTelDetail extends BatchSqlUpdate {
    private static final String SQL_INSERT_CONTACT_TEL =
            "INSERT INTO CONTACT_TEL_DETAIL(CONTACT_ID, TEL_TYPE, TEL_NUMBER) VALUES (:CONTACT_ID, :TEL_TYPE, :TEL_NUMBER)";

    private static final int BATCH_SIZE = 10;

    public InsertContactTelDetail(DataSource dataSource) {
        super(dataSource, SQL_INSERT_CONTACT_TEL);

        declareParameter(new SqlParameter("CONTACT_ID", Types.INTEGER));
        declareParameter(new SqlParameter("TEL_TYPE", Types.VARCHAR));
        declareParameter(new SqlParameter("TEL_TYPE", Types.VARCHAR));

        setBatchSize(BATCH_SIZE);
    }
}
