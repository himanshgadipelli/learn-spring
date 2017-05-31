package com.apress.prospring4.ch6;

import java.util.List;

/**
 * Created by bobby on 4/10/2017.
 */
public interface ContactDao {
    List<Contact> findAll();
    List<Contact> findByFirstName(String firstName);
    String findFirstNameById(Long id);
    List<Contact> findAllWithDetail();
    void insert(Contact contact);
    void insertWithDetail(Contact contact);
    void update(Contact contact);
}
