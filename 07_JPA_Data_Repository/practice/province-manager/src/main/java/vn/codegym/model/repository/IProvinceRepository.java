package vn.codegym.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import vn.codegym.model.bean.Province;

public interface IProvinceRepository extends PagingAndSortingRepository<Province,Long> {
}
