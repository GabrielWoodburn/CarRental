package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Dealership;
import dmacc.repository.DealershipRepository;

@Controller
public class WebController {
	@Autowired
	DealershipRepository repo;

	@GetMapping({ "/", "viewAll" })
	public String viewAllDealerships(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewDealership(model);
		}
		
		model.addAttribute("dealerships", repo.findAll());
		return "results";
	}

	@GetMapping("/inputDealership")
	public String addNewDealership(Model model) {
		Dealership d = new Dealership();
		model.addAttribute("newDealership", d);
		return "input";
	}

	@GetMapping("/edit/{id}")
	public String showUpdateDealership(@PathVariable("id") long id, Model model) {
		Dealership d = repo.findById(id).orElse(null);
		System.out.println("ITEM TO EDIT: " + d.toString());
		model.addAttribute("newDealership", d);
		return "input";
	}

	@PostMapping("/update/{id}")
	public String reviseDealership(Dealership d, Model model) {
		repo.save(d);
		return viewAllDealerships(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Dealership d = repo.findById(id).orElse(null);
	    repo.delete(d);
	    return viewAllDealerships(model);
	}
}