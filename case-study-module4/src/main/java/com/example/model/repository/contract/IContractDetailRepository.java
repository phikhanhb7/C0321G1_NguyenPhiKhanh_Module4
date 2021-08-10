package com.example.model.repository.contract;


import com.example.model.dto.ContractInterfaceDto;
import com.example.model.entity.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
    @Query(value = " select dt.id as id,sum(dt.quantity) as quantity , dt.attach_service_id as attachServiceId ," +
            " dt.contract_id as contractId , att.attach_service_name as attachServiceName " +
            " from  contract_detail dt " +
            " join attach_service att on dt.attach_service_id = att.id " +
            "group by dt.attach_service_id,dt.contract_id ",nativeQuery = true)
    List<ContractInterfaceDto> findAllByContractDetailByAttachService();

    List<ContractDetail> findAllByContract_Id(Integer id);
    @Query(value= " select  * from contract_detail where flag =0", nativeQuery = true,
            countQuery = "select  count(*) from  contract_detail where flag =0")
    Page<ContractDetail> findAll(Pageable pageable);
}
