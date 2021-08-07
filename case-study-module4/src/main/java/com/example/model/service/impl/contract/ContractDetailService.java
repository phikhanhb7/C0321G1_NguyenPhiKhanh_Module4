package com.example.model.service.impl.contract;

import com.example.model.entity.contract.AttachService;
import com.example.model.entity.contract.ContractDetail;
import com.example.model.repository.contract.IAttachServiceRepository;
import com.example.model.repository.contract.IContractDetailRepository;

import com.example.model.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    IContractDetailRepository contractDetailRepository;

    @Autowired
    IAttachServiceRepository attachServiceRepository;


    @Override
    public Iterable<ContractDetail> findAllContractDetail(Pageable pageable) {
        return contractDetailRepository.findAll(pageable);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public Iterable<AttachService> findAllAttachService() {
        return attachServiceRepository.findAll();
    }

    @Override
    public List<ContractDetail> findAllByAttachService() {
        return contractDetailRepository.findAllByAttachService();
    }


    @Override
    public List<ContractDetail> findAllByContract_Id(Integer id) {
        return contractDetailRepository.findAllByContract_Id(id);
    }
}

