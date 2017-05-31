package com.apress.prospring4.ch6;

import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by bobby on 4/11/2017.
 */
public class SelectAllContacts extends MappingSqlQuery<Contact> {
    private static final String SQL_SELECT_ALL_CONTACT =
            "SELECT ID, FIRST_NAME, LAST_NAME, BIRTH_DATE FROM CONTACT";

    public SelectAllContacts(DataSource dataSource){
        super(dataSource, SQL_SELECT_ALL_CONTACT);
    }

    protected Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contact contact = new Contact();

        contact.setId(rs.getLong("ID"));
        contact.setFirstName(rs.getString("FIRST_NAME"));
        contact.setLastName(rs.getString("LAST_NAME"));
        contact.setBirthDate(rs.getDate("BIRTH_DATE"));

        return contact;
    }
}
