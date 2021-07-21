package com.example.model.repository;


import com.example.model.bean.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;

@Transactional
@Repository
public class CustomerRepository implements ICustomerRepository {


    @Override
    public void insertWithStoredProcedure(Customer customer) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        String sql = "CALL Insert_Customer(:firstName, :lastName)";
        Query query = BaseRepository.entityManager.createNativeQuery(sql);
        query.setParameter("firstName", customer.getFirstName());
        query.setParameter("lastName", customer.getLastName());
        query.executeUpdate() ;
        transaction.commit();
    }
}