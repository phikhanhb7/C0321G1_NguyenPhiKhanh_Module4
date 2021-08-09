package com.example.model.service.impl.contract;

import com.example.model.entity.contract.Contract;
import com.example.model.entity.contract.ContractDetail;
import com.example.model.entity.contract.ContractTotal;
import com.example.model.repository.contract.IContractDetailRepository;
import com.example.model.repository.contract.IContractRepository;
import com.example.model.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractService implements IContractService {
    @Autowired
    IContractRepository contractRepository;

    @Autowired
    IContractDetailRepository contractDetailRepository;
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

//    @Override
//    public void setContractTotal(Page<Contract> contracts) {
//
//        for (Contract contract : contracts){
//            List<ContractDetail> contractDetails= contractDetailRepository.findAllByContract_Id(contract.getId());
//            Double totalMoney= contract.getService().getServiceCost() - contract.getContractDeposit();
//
//            for (ContractDetail contractDetail : contractDetails){
//                totalMoney+= contractDetail.getQuantity()* contractDetail.getAttachService().getAttachServiceCost();
//            }
//            contract.setContractTotal(totalMoney);
//        }
//    }

    @Override
    public Optional<Contract> findById(Integer id) {
        return contractRepository.findById(id);
    }


}
