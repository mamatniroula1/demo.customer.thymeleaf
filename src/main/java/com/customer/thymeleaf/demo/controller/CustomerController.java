package com.customer.thymeleaf.demo.controller;


import com.customer.thymeleaf.demo.model.Customer;
import com.customer.thymeleaf.demo.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@Controller
@RequestMapping("/customers")
public class CustomerController {


    @Autowired
    private CustomerService customerService;



    @GetMapping("/list")
    public String showList(Model model){
        List<Customer> customers= customerService.findAll();
        model.addAttribute("customers",customers);
        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String addCustomer(Model   model){
        Customer customer= new Customer();
        model.addAttribute("customer", customer);
        return "customers/customer-form";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        return "redirect:/customers/list";
    }

    @GetMapping("/showFormForUpdate")
    public String updateCustomerInfo(@RequestParam("cid") int cid, Model model){

        Customer customer= customerService.findById(cid);
        model.addAttribute("customer", customer);
        return "customers/customer-form";

    }

    @GetMapping("/delete")
    public String deleteCustomerById(@RequestParam("cid") int cid){
        customerService.deleteById(cid);
        return "redirect:/customers/list";
    }
}
