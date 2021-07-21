package vn.codegym.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.bean.Blog;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
}
