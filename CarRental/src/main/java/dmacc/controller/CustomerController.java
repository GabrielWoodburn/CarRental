package dmacc.controller;

import dmacc.beans.Customer;
import dmacc.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Rumbi Chinhamhora rchinhamhora
 * CIS 175 - Spring 2021
 * Apr 10, 2021
 */

@Controller
public class CustomerController {
	
	@Autowired
	CustomerRepository repo;

	
	@GetMapping("/viewCustomers")
	public String viewAllCustomers(Model model) {
		if (repo.findAll().isEmpty()) return addNewCustomer(model);
		List<Customer> customers = repo.findAll();
		model.addAttribute("customers", customers);
		return "viewCustomers";
	}
	
	@GetMapping("/inputCustomer")
	public String addNewCustomer(Model model) {
		Customer newCust = new Customer();
		model.addAttribute("newCust", newCust);
		return "newCust";
	}
	

	@GetMapping("/editCust/{id}")
		public String showUpdateCustomer(@PathVariable("id") long id, Model model) {
		Customer cust = repo.findById(id).orElse(null);
		model.addAttribute("newCustomer", cust);
		return "input";
	}


	

	@PostMapping("/updateCust/{id}") 
		public String reviewCustomer(Customer newCust, Model model) {
		repo.save(newCust);
		return viewAllCustomers(model);
	}



	@GetMapping("/deleteCust/{id}")
		public String deleteCust(@PathVariable("id") long id, Model model) {
		Customer c = repo.findById(id).orElse(null);
		repo.delete(c);
		return viewAllCustomers(model);
	}

}