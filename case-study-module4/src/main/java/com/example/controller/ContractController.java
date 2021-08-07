package com.example.controller;

import com.example.model.dto.ContractDto;
import com.example.model.entity.contract.Contract;
import com.example.model.entity.customer.Customer;
import com.example.model.entity.employee.Employee;
import com.example.model.entity.service.Services;
import com.example.model.service.contract.IContractService;
import com.example.model.service.customer.ICustomerService;
import com.example.model.service.employee.IEmployeeService;
import com.example.model.service.service.IServicesService;
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
@RequestMapping("/contracts")
public class ContractController {
    @Autowired
    ICustomerService iCustomerService;

    @Autowired
    IEmployeeService employeeService;

    @Autowired
    IServicesService servicesService;

    @Autowired
    IContractService contractService;

    @ModelAttribute("customerList")
    public Iterable<Customer> getCustomerList(){
        return iCustomerService.findAll();
    }

    @ModelAttribute("employeeList")
    public Iterable<Employee> getEmployeeList(){
        return employeeService.findAll();
    }

    @ModelAttribute("serviceList")
    public Iterable<Services> getServiceList(){
        return servicesService.findAll();
    }

    @RequestMapping("")
    public String goListContract(@PageableDefault(value = 2) Pageable pageable,Model model){
        Iterable<Contract> contracts = contractService.findAll(pageable);
        model.addAttribute("contracts",contracts);
        return "/contract/list";
    }

    @RequestMapping("/create-contract")
    public String showCreateContract(Model model){
        model.addAttribute("contractDto",new ContractDto());
        return "/contract/create";
    }

    @PostMapping("/create-contract")
    public String createContract(@Valid @ModelAttribute ContractDto contractDto, BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes, Model model){
        new ContractDto().validate(contractDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("contractDto",contractDto);
            model.addAttribute("mes","create fail");
            return "/contract/create";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto,contract);
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("mes","Create Contract OK");
        return "redirect:/contracts";

    }

    @GetMapping(value = "/delete-contract")
    public String deleteEmployee(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        Optional<Contract> contract = contractService.findById(id);
        if (!contract.isPresent()) {
            return "/error";
        }
        contract.get().setFlag(true);
        contractService.save(contract.get());
        redirectAttributes.addFlashAttribute("mes", "deleted successfully! ");
        return "redirect:/contracts";
    }
}
