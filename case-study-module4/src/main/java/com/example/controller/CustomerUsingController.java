package com.example.controller;

import com.example.model.entity.contract.Contract;
import com.example.model.entity.contract.ContractDetail;
import com.example.model.service.contract.IContractDetailService;
import com.example.model.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customerUsings")
public class CustomerUsingController {

    @Autowired
    IContractService contractService;

    @Autowired
    IContractDetailService contractDetailService;



    @GetMapping("")
    public String goListCustomerUsing(@PageableDefault(value = 2) Pageable pageable, Model model, Optional<String> search){
        String nameValue="";
        if (search.isPresent()){
            nameValue=search.get();
        }

        Page<Contract> contractCustomerUsing = contractService.findAllContractUsing(nameValue,pageable);

        for (Contract contract : contractCustomerUsing){
            List<ContractDetail> contractDetails= contractDetailService.findAllByContract_Id(contract.getId());
            Double totalMoney= contract.getService().getServiceCost() - contract.getContractDeposit();

            for (ContractDetail contractDetail : contractDetails){
               totalMoney+= contractDetail.getQuantity()* contractDetail.getAttachService().getAttachServiceCost();
            }
            contract.setContractTotal(totalMoney);
        }
        model.addAttribute("contractDetailList",contractDetailService.findAllByAttachService());
        model.addAttribute("customerUsingList",contractCustomerUsing);
        model.addAttribute("search",nameValue);
        return "/customerUsing/list";
    }


}
