package dmacc.controllers;

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
	String viewAllCustomers(Model model) {
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
	
<<<<<<< Updated upstream
	@GetMapping("/editCust/{id}")
	String showUpdateCustomer(@PathVariable("id") long id, Model model) {
		Customer cust = repo.findById(id).orElse(null);
=======
	@GetMapping("/editCust/{custId}")
	String showUpdateCustomer(@PathVariable("custId") long custId, Model model) {
		Customer cust = repo.findById(custId).orElse(null);
>>>>>>> Stashed changes
		model.addAttribute("newCust", cust);
		return "newCust";
	}
	
<<<<<<< Updated upstream
	@PostMapping("/updateCust/{id}")
=======
	@PostMapping("/updateCust/{custId}")
>>>>>>> Stashed changes
	String saveCust(Customer newCust, Model model) {
		repo.save(newCust);
		return viewAllCustomers(model);
	}

<<<<<<< Updated upstream
	@GetMapping("/deleteCust/{id}")
	String deleteCust(@PathVariable("id") long id, Model model) {
		repo.findById(id).ifPresent(repo :: delete);
=======
	@GetMapping("/deleteCust/{custId}")
	String deleteCust(@PathVariable("custId") long custId, Model model) {
		repo.findById(custId).ifPresent(repo :: delete);
>>>>>>> Stashed changes
		return viewAllCustomers(model);
	}
}