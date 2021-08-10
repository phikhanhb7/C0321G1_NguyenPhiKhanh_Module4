package com.example.controller;

import com.example.model.dto.ContractDetailDto;
import com.example.model.dto.ContractDto;
import com.example.model.entity.contract.AttachService;
import com.example.model.entity.contract.Contract;
import com.example.model.entity.contract.ContractDetail;
import com.example.model.service.contract.IContractDetailService;
import com.example.model.service.contract.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/contractDetails")
public class ContractDetailController {

    @Autowired
    IContractDetailService contractDetailService;

    @Autowired
    IContractService contractService;

    @ModelAttribute("contractList")
    public Iterable<Contract> getContractList(){
        return contractService.findAllContract();
    }

    @ModelAttribute("attachServiceList")
    public Iterable<AttachService> getAttachServiceList(){
        return contractDetailService.findAllAttachService();
    }
    @GetMapping("")
    public String showListContractDetail(@PageableDefault(value = 2) Pageable pageable, Model model){
        model.addAttribute("contractDetails",contractDetailService.findAllContractDetail(pageable));
        return "/contractDetail/list";
    }

    @GetMapping("/create-contractDetail")
    public String goCreatePage(Model model){
        model.addAttribute("contractDetailDto",new ContractDetailDto());
        return "/contractDetail/create";
    }

    @PostMapping("/create-contractDetail")
    public String createContractDetail(@Valid @ModelAttribute ContractDetailDto contractDetailDto, BindingResult bindingResult,
                                       Model model , RedirectAttributes redirectAttributes){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("contractDetailDto",contractDetailDto);
            return "/contractDetail/create";
        }
        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto,contractDetail);
        contractDetailService.save(contractDetail);
        return "redirect:/contractDetails";
    }

    @GetMapping(value = "/delete-contractDetail")
    public String deleteEmployee(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        Optional<ContractDetail> contractDetail = contractDetailService.findById(id);
        if (!contractDetail.isPresent()) {
            return "/error";
        }
        contractDetail.get().setFlag(true);
        contractDetailService.save(contractDetail.get());
        redirectAttributes.addFlashAttribute("mes", "deleted successfully! ");
        return "redirect:/contractDetails";
    }
}
