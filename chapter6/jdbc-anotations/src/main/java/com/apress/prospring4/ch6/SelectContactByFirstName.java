package com.apress.prospring4.ch6;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Created by bobby on 4/11/2017.
 */
public class SelectContactByFirstName extends MappingSqlQuery<Contact> {
    private static final String SQL_FIND_BY_FIRST_NAME =
            "SELECT ID, FIRST_NAME, LAST_NAME, BIRTH_DATE, FROM CONTACT WHERE FIRST_NAME + :FIRST_NAME";

    public SelectContactByFirstName(DataSource dataSource) {
        super(dataSource, SQL_FIND_BY_FIRST_NAME);
        super.declareParameter(new SqlParameter("FIRST_NAME", Types.VARCHAR));
    }

    protected Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contact contact = new Contact();

        contact.setId(rs.getLong("id"));
        contact.setFirstName(rs.getString("FIRST_NAME"));
        contact.setLastName(rs.getString("LAST_NAME"));
        contact.setBirthDate(rs.getDate("BIRTH_DATE"));

        return contact;
    }

}
