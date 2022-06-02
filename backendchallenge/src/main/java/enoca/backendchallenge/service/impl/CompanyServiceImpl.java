package enoca.backendchallenge.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import enoca.backendchallenge.core.utilities.results.DataResult;
import enoca.backendchallenge.core.utilities.results.Result;
import enoca.backendchallenge.core.utilities.results.SuccessDataResult;
import enoca.backendchallenge.core.utilities.results.SuccessResult;
import enoca.backendchallenge.entity.Company;
import enoca.backendchallenge.repository.CompanyRepository;
import enoca.backendchallenge.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{

	private CompanyRepository companyRepository;
	
	public CompanyServiceImpl(CompanyRepository companyRepository) {
		super();
		this.companyRepository = companyRepository;
	}

	@Override
	public DataResult<List<Company>> getAll() {
		return new SuccessDataResult<List<Company>>(this.companyRepository.findAll(),"Veri listelendi.");
	}

	@Override
	public Result add(Company company) {
		this.companyRepository.save(company);
		return new SuccessResult();
		
	}

	@Override
	public Result update(Company company) {
		this.companyRepository.save(company);
		return new SuccessResult();
	}

	@Override
	public DataResult<Company> getCompanyById(int id) {	
		Company company = this.companyRepository.findById(id).get();
		return new SuccessDataResult<Company>(company);
	}

	@Override
	public Result deleteCompanyById(int id) {
		this.companyRepository.deleteById(id);
		return new SuccessResult();
	}	

}
