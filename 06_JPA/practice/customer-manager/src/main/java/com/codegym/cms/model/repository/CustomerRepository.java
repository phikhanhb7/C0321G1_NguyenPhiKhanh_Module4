package com.codegym.cms.model.repository;

import com.codegym.cms.model.bean.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CustomerRepository implements ICustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer as c", Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(Long id) {
        TypedQuery<Customer> query = (TypedQuery<Customer>) entityManager.createQuery("select c from Customer as c where c.id = :id", Customer.class);
        query.setParameter("id", id);

        return query.getSingleResult();
    }

    @Override
    public void save(Customer customer) {
        if (customer.getId() != null) {
            entityManager.merge(customer);
        } else {
            entityManager.persist(customer);
        }
    }

    @Override
    public void remove(Long id) {
        Customer customer = entityManager.find(Customer.class, id);
        entityManager.remove(customer);
    }
}
