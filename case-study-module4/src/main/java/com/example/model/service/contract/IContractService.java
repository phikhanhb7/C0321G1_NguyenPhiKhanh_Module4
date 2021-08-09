package com.example.model.service.contract;

import com.example.model.entity.contract.Contract;
import com.example.model.entity.contract.ContractTotal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IContractService {
    void save(Contract contract);
    Iterable<Contract> findAll(Pageable pageable);

    Iterable<Contract> findAllContract();

//    Page<ContractTotal> findAllContractUsing(String name, Pageable pageable);

    Optional<Contract> findById(Integer id);

    Page<Contract> findAllContractUsing(String name, Pageable pageable);
//
//    void setContractTotal(Page<Contract> contracts);

}
