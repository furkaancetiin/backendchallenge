package enoca.backendchallenge.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import enoca.backendchallenge.core.utilities.results.DataResult;
import enoca.backendchallenge.core.utilities.results.Result;
import enoca.backendchallenge.entity.Company;
import enoca.backendchallenge.service.CompanyService;

@RestController
@RequestMapping("/api/companies")
public class CompaniesController {
	
	private CompanyService companyService;	
	
	public CompaniesController(CompanyService companyService) {
		super();
		this.companyService = companyService;
	}


	@GetMapping("/getall")  
	public DataResult<List<Company>> getAll(){
		return this.companyService.getAll();
	}
	
	@GetMapping("/getbyid")
	public DataResult<Company> getById(@RequestParam("id") int id){
		return this.companyService.getCompanyById(id);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Company company) {
		return this.companyService.add(company);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Company company) {
		return this.companyService.update(company);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id) {
		return this.companyService.deleteCompanyById(id);
	}
	
	
}
