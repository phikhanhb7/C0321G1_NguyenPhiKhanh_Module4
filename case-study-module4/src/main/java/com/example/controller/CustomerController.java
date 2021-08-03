package com.example.controller;

import com.example.model.dto.CustomerDto;
import com.example.model.entity.customer.Customer;
import com.example.model.entity.customer.CustomerType;
import com.example.model.service.customer.ICustomerService;
import com.example.model.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping(value = "/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @ModelAttribute(value = "customerTypes")
    public Iterable<CustomerType> customerTypes() {
        return customerTypeService.findAll();
    }


    @GetMapping(value = {"/create-customer"})
    public ModelAndView showCreateCustomer() {
        CustomerDto customerDto = new CustomerDto();
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customerDto", customerDto);
        return modelAndView;
    }

    @PostMapping(value = "/create-customer")
    public ModelAndView saveCustomer(@Validated @ModelAttribute CustomerDto customerDto, BindingResult bindingResult) {
        List<CustomerType> customerTypes = (List<CustomerType>) customerTypeService.findAll();
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("customer/create");
            modelAndView.addAllObjects(bindingResult.getModel());
            return modelAndView;
        } else {
            customerService.save(customer);
            ModelAndView modelAndView = new ModelAndView("/customer/create");
            modelAndView.addObject("customer", customer);
            modelAndView.addObject("mes", "new customer created successfully");
            return modelAndView;
        }
    }

    @GetMapping(value = "")
    public ModelAndView listCustomer(@RequestParam("search") Optional<String> search,
                                     @RequestParam("birthday") Optional<String> birthday,
                                     @RequestParam("idCard") Optional<String> idCard,
                                     @PageableDefault(value = 2) Pageable pageable) {
        Page<Customer> customers;
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        customers = customerService.findByCustomerNameContaining(search.orElse(""), birthday.orElse(""), idCard.orElse(""), pageable);
        modelAndView.addObject("search", search.orElse(""));
        modelAndView.addObject("birthday", birthday.orElse(""));
        modelAndView.addObject("idCard", idCard.orElse(""));
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping(value = "/edit-customer/{id}")
    public String showEditForm(@PathVariable Integer id, Model model){
        Optional<Customer> customer = customerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer.get(),customerDto);
        if (customer.isPresent()){
            model.addAttribute("customerDto",customerDto);
            return "/customer/edit";
        }else {
            return "/error";
        }
    }

    @PostMapping(value = "/edit-customer")
    public ModelAndView updateCustomer(@Validated @ModelAttribute CustomerDto customerDto,
                                       BindingResult bindingResult) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("customer/edit");
            return modelAndView;
        } else {
            customerService.save(customer);
            ModelAndView modelAndView = new ModelAndView("customer/edit");
            modelAndView.addObject("customer", customer);
            modelAndView.addObject("mes", "Customer update successfully");
            return modelAndView;
        }

    }

    //delete 1 customer

//    @GetMapping(value = "/delete-customer")
//    public String deleteCustomer(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
//        Optional<Customer> customer = customerService.findById(id);
//        if (customer.get() == null) {
//            return "/error";
//        }
//        customer.get().setFlag(true);
//        customerService.save(customer.get());
//        redirectAttributes.addFlashAttribute("mes", "deleted successfully! ");
//        return "redirect:customers";
//    }


    // delete nhieu
    @GetMapping(value = "/delete-customer")
    public ModelAndView delete(@RequestParam Optional<List<Integer>> listId, RedirectAttributes redirectAttributes) {
        if (listId.isPresent()) {
            for (Integer id : listId.get()) {
                Optional<Customer> customer = customerService.findById(id);
                if (!customer.isPresent()) {
                    return new ModelAndView("error");
                }

                customer.get().setFlag(true);
                customerService.save(customer.get());
            }
            redirectAttributes.addFlashAttribute("mes", "Delete is successful!!");
            return new ModelAndView("redirect:/customers");
        }
        return new ModelAndView("redirect:/customers");
    }
}
