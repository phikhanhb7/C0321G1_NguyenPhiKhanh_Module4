package com.example.model.repository.customer;

import com.example.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select * from customer where concat(customer_name,customer_birth_day,customer_id_card) like %?1% and flag =0",
            nativeQuery = true)
    Page<Customer> findByCustomerNameContaining(String name , Pageable pageable);
}

//    customer_name like %?1% and flag=0  and customer_birth_day like %?2% and customer_id_card like %?3%
