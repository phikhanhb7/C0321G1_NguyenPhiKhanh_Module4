package com.example.model.repository.contract;

import com.example.model.entity.contract.Contract;
import com.example.model.entity.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
    @Query(value = "select id, sum(quantity) as quantity, attach_service_id, contract_id " +
            "from contract_detail group by attach_service_id",nativeQuery = true)
    List<ContractDetail> findAllByAttachService();

    List<ContractDetail> findAllByContract_Id(Integer id);
}
