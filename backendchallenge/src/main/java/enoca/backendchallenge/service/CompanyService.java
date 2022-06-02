package enoca.backendchallenge.service;

import java.util.List;

import enoca.backendchallenge.core.utilities.results.DataResult;
import enoca.backendchallenge.core.utilities.results.Result;
import enoca.backendchallenge.entity.Company;

public interface CompanyService {
	DataResult<List<Company>> getAll();
	
	Result add(Company company);
	
	Result update(Company company);		
	
	DataResult<Company> getCompanyById(int id);		

	Result deleteCompanyById(int id);
}
