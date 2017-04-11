package com.apress.prospring4.ch6;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bobby on 4/11/2017.
 */
@Repository("contactDao")
public class JdbcContactDao implements ContactDao {
    private static final Log LOG = LogFactory.getLog(JdbcContactDao.class);

    private DataSource dataSource;
    private SelectAllContacts selectAllContacts;
    private SelectContactByFirstName selectContactByFirstName;
    private UpdateContact updateContact;
    private InsertContact insertContact;
    private InsertContactTelDetail insertContactTelDetail;
    private StoredFunctionFirstNameById storedFunctionFirstNameById;

    @Override
    public List<Contact> findAll() {
        return selectAllContacts.execute();
    }

    @Override
    public List<Contact> findByFirstName(String fileName) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("FIRST_NAME", fileName);

        return selectContactByFirstName.executeByNamedParam(paramMap);
    }

    @Override
    public String findFirstNameById(Long id) {
        List<String> result = storedFunctionFirstNameById.execute(id);
        return result.get(0);
    }

    @Override
    public void insert(Contact contact) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("FIRST_NAME", contact.getFirstName());
        paramMap.put("LAST_NAME", contact.getLastName());
        paramMap.put("BIRTH_DATE", contact.getBirthDate());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        insertContact.updateByNamedParam(paramMap, keyHolder);

        contact.setId(keyHolder.getKey().longValue());

        LOG.info("New contact inserted with id: " + contact.getId());
    }

    @Override
    public void insertWithDetail(Contact contact) {
        insertContactTelDetail = new InsertContactTelDetail(dataSource);

        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("FIRST_NAME", contact.getFirstName());
        paramMap.put("LAST_NAME", contact.getLastName());
        paramMap.put("BIRTH_DATE", contact.getBirthDate());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        insertContact.updateByNamedParam(paramMap, keyHolder);

        contact.setId(keyHolder.getKey().longValue());

        LOG.info("New contact inserted with id: " + contact.getId());

        List<ContactTelDetail> contactTelDetails =
                contact.getContactTelDetails();

        if (contactTelDetails != null) {
            for (ContactTelDetail contactTelDetail : contactTelDetails) {
                paramMap = new HashMap<String, Object>();
                paramMap.put("CONTACT_ID", contact.getId());
                paramMap.put("TEL_TYPE", contactTelDetail.getTelType());
                paramMap.put("TEL_NUMBER", contactTelDetail.getTelNumber());
                insertContactTelDetail.updateByNamedParam(paramMap);
            }
        }

        insertContactTelDetail.flush();
    }

    @Override
    public List<Contact> findAllWithDetail() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

        String sql = "SELECT C.ID, C.FIRST_NAME, C.LAST_NAME, C.BIRTH_DATE, " +
                "T.ID AS CONTACT_TEL_ID, T.TEL_TYPE, T.TEL_NUMBER FROM CONTACT C " +
                "LEFT JOIN CONTACT_TEL_DETAIL T ON C.ID = T.CONTACT_ID";

        return jdbcTemplate.query(sql, new ContactWithDetailExtractor());
    }

    @Override
    public void update(Contact contact) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("FIRST_NAME", contact.getFirstName());
        paramMap.put("LAST_NAME", contact.getLastName());
        paramMap.put("BIRTH_DATE", contact.getBirthDate());
        paramMap.put("ID", contact.getId());

        updateContact.updateByNamedParam(paramMap);

        LOG.info("Existing contact updated with id: " + contact.getId());
    }


    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.selectAllContacts = new SelectAllContacts(dataSource);
        this.selectContactByFirstName = new SelectContactByFirstName(dataSource);
        this.updateContact = new UpdateContact(dataSource);
        this.insertContact = new InsertContact(dataSource);
        this.storedFunctionFirstNameById = new StoredFunctionFirstNameById(dataSource);
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    private static final class ContactWithDetailExtractor
            implements ResultSetExtractor<List<Contact>> {
        public List<Contact> extractData(ResultSet rs) throws SQLException, DataAccessException {
            Map<Long, Contact> map = new HashMap<Long, Contact>();
            Contact contact = null;

            while (rs.next()) {
                Long id = rs.getLong("ID");
                contact = map.get(id);

                if (contact == null) {
                    contact = new Contact();
                    contact.setId(id);
                    contact.setFirstName(rs.getString("FIRST_NAME"));
                    contact.setLastName(rs.getString("LAST_NAME"));
                    contact.setBirthDate(rs.getDate("BIRTH_DATE"));
                    contact.setContactTelDetails(new ArrayList<ContactTelDetail>());

                    map.put(id, contact);
                }

                Long contactTelDetailId = rs.getLong("CONTACT_TEL_ID");

                if (contactTelDetailId > 0) {
                    ContactTelDetail contactTelDetail = new ContactTelDetail();
                    contactTelDetail.setId(contactTelDetailId);
                    contactTelDetail.setContactId(id);
                    contactTelDetail.setTelType(rs.getString("TEL_TYPE"));
                    contactTelDetail.setTelNumber(rs.getString("TEL_NUMBER"));
                    contact.getContactTelDetails().add(contactTelDetail);
                }
            }
            return new ArrayList<Contact>(map.values());
        }
    }
}
