package com.example.controller;

import com.example.model.dto.ServiceDto;
import com.example.model.entity.contract.Contract;
import com.example.model.entity.service.RentType;
import com.example.model.entity.service.ServiceType;
import com.example.model.entity.service.Services;
import com.example.model.service.service.IServicesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Repository
@RequestMapping("/services")
public class ServicesController {
    @Autowired
    IServicesService servicesService;

    @ModelAttribute("rentTypeList")
    public Iterable<RentType> getRentTypeList(){
       return servicesService.findAllRentType();
    }

    @ModelAttribute("serviceTypeList")
    public Iterable<ServiceType> getServiceTypeList(){
        return servicesService.findAllServiceType();
    }

    @RequestMapping("")
    public String showListService(@PageableDefault(value = 2) Pageable pageable, Model model){
        Page<Services> services = servicesService.findAll(pageable);
        model.addAttribute("services",services);
        return "/service/list";
    }

    @RequestMapping("/create-service")
    public String showCreateService(Model model){
        ServiceDto serviceDto = new ServiceDto();
        model.addAttribute("serviceDto",serviceDto);
        return "/service/create";
    }

    @PostMapping("/create-service")
    public String createService(@Valid @ModelAttribute ServiceDto serviceDto , BindingResult bindingResult, Model model,
                                RedirectAttributes redirectAttributes){
        if (bindingResult.hasFieldErrors()){
            for (Services services : servicesService.findAll()){
                if (serviceDto.getServiceCode().equals(services.getServiceCode())){
                    model.addAttribute("codeDuplicate","Duplicate code");
                    model.addAttribute("serviceDto",serviceDto);
                    return "/service/create";
                }
            }

        }
        Services services = new Services();
        BeanUtils.copyProperties(serviceDto,services);
        servicesService.save(services);
        redirectAttributes.addFlashAttribute("mes","Create OK ");
        return "redirect:/services";
    }

    @GetMapping(value = "/delete-service")
    public String deleteEmployee(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        Optional<Services> services = servicesService.findById(id);
        if (!services.isPresent()) {
            return "/error";
        }
        services.get().setFlag(true);
        servicesService.save(services.get());
        redirectAttributes.addFlashAttribute("mes", "deleted successfully! ");
        return "redirect:/services";
    }
}
