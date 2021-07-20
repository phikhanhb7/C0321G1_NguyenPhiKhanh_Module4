package com.example.model.repository;

import com.example.model.bean.Product;
import com.mysql.cj.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = BaseRepository.entityManager.createQuery("SELECT p FROM product as p", Product.class);
        return query.getResultList();
    }

    @Override
    public void create(Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.persist(product);
        transaction.commit();
    }

    @Override
    public Product findById(int id) {
        return BaseRepository.entityManager.find(Product.class,id);
    }

    @Override
    public void edit(Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.merge(product);
        transaction.commit();
    }

    @Override
    public void delete(int id) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        Product product = BaseRepository.entityManager.find(Product.class,id);
        BaseRepository.entityManager.remove(product);
        transaction.commit();
    }
}
