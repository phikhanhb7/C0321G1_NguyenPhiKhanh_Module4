package com.example.model.repository.contract;

import com.example.model.entity.contract.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IAttachServiceRepository extends JpaRepository<AttachService,Integer> {

}
