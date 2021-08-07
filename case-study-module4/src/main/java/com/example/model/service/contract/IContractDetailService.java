package com.example.model.service.contract;


import com.example.model.entity.contract.AttachService;
import com.example.model.entity.contract.ContractDetail;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractDetailService {
    Iterable<ContractDetail> findAllContractDetail(Pageable pageable);
    void save(ContractDetail contractDetail);

    Iterable<AttachService> findAllAttachService();

    List<ContractDetail> findAllByAttachService();

    List<ContractDetail> findAllByContract_Id(Integer id);
}
