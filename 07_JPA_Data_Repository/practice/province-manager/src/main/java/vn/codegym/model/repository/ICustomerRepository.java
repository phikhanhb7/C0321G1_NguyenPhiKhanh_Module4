package vn.codegym.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import vn.codegym.model.bean.Customer;


public interface ICustomerRepository extends PagingAndSortingRepository<Customer,Long> {
}
