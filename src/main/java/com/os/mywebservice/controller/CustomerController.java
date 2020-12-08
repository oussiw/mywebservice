package com.os.mywebservice.controller;

import com.os.mywebservice.dao.CustomerDao;
import com.os.mywebservice.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;

    @GetMapping("/list")
    public String getAll(Model model){
        List<Customer> customers = customerDao.findAll();
        for(Customer customer:customers){
            System.out.println(customer.toString());
        }
        model.addAttribute("listCustomers",customers);
        return "listPage";
    }

    @GetMapping("/add")
    public String getAddView(Model theModel){
        Customer customer = new Customer();
        theModel.addAttribute("customer",customer);
        return "add-form";
    }

    @GetMapping("/update/{id}")
    public ModelAndView getUpdView(@PathVariable(name="id") int customerId){
        ModelAndView modelAndView = new ModelAndView("upd-form");
        Optional<Customer> customerO=customerDao.findById(customerId);
        if(customerO.isPresent()) {
            Customer customer = customerO.get();
            modelAndView.addObject("customerU",customer);
        }
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("customer") Customer theCustomer){
        customerDao.save(theCustomer);
        return "redirect:/customers/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name="id") int customerId){
        customerDao.deleteById(customerId);
        return "redirect:/customers/list";
    }

}
