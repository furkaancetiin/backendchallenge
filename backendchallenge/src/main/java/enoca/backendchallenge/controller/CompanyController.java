package enoca.backendchallenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import enoca.backendchallenge.entity.Company;
import enoca.backendchallenge.service.CompanyService;

@Controller
public class CompanyController {
	
	private CompanyService companyService;

	public CompanyController(CompanyService companyService) {
		super();
		this.companyService = companyService;
	}
	
	@GetMapping("/companies")
	public String getAll(Model model) {
		model.addAttribute("companies",this.companyService.getAll().getData());
		return "companies";
	}
	
	@GetMapping("/companies/add")
	public String addCompany(Model model) {
		Company company = new Company();
		model.addAttribute("company",company);
		return "add_company";
	}
	
	@PostMapping("/companies")
	public String addCompany(@ModelAttribute("companies") Company company) {
		this.companyService.add(company);
		return "redirect:/companies";
	}
	
	@GetMapping("/companies/update/{id}")
	public String updateCompany(@PathVariable int id,Model model) {
		model.addAttribute("company",this.companyService.getCompanyById(id).getData());
		return "update_company";
	}
	
	@PostMapping("/companies/{id}")
	public String updateCompany(@PathVariable int id, @ModelAttribute("companies") Company company, Model model) {
		
		Company getCompanyById = this.companyService.getCompanyById(id).getData();
		getCompanyById.setName(company.getName());
		getCompanyById.setAdress(company.getAdress());
		getCompanyById.setWebsite(company.getWebsite());
		
		this.companyService.update(getCompanyById);
		return "redirect:/companies";
	}
	
	@GetMapping("/companies/{id}")
	public String deleteCompany(@PathVariable int id) {
		this.companyService.deleteCompanyById(id);
		return "redirect:/companies";
	}
	
}
