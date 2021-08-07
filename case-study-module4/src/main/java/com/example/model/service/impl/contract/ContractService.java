package com.example.model.service.impl.contract;

import com.example.model.entity.contract.Contract;
import com.example.model.entity.contract.ContractTotal;
import com.example.model.repository.contract.IContractRepository;
import com.example.model.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractService implements IContractService {
    @Autowired
    IContractRepository contractRepository;
    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public Iterable<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Iterable<Contract> findAllContract() {
        return contractRepository.findAll();
    }

    @Override
    public Page<Contract> findAllContractUsing(String name, Pageable pageable) {
        return contractRepository.findAllContractUsing(name,pageable);
    }

    @Override
    public Optional<Contract> findById(Integer id) {
        return contractRepository.findById(id);
    }


}
