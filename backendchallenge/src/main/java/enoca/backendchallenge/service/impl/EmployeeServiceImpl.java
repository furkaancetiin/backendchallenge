package enoca.backendchallenge.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import enoca.backendchallenge.core.utilities.results.DataResult;
import enoca.backendchallenge.core.utilities.results.Result;
import enoca.backendchallenge.core.utilities.results.SuccessDataResult;
import enoca.backendchallenge.core.utilities.results.SuccessResult;
import enoca.backendchallenge.entity.Employee;
import enoca.backendchallenge.repository.EmployeeRepository;
import enoca.backendchallenge.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepository employeeRepository;

	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(this.employeeRepository.findAll(), "Çalışanlar listelendi.");
	}

	@Override
	public Result add(Employee employee) {
		this.employeeRepository.save(employee);
		return new SuccessResult();
	}

	@Override
	public Result update(Employee employee) {
		this.employeeRepository.save(employee);
		return new SuccessResult();
	}

	@Override
	public DataResult<Employee> getEmployeeById(int id) {		
		return new SuccessDataResult<Employee>(this.employeeRepository.findById(id).get());
	}

	@Override
	public Result deleteEmployeeById(int id) {
		this.employeeRepository.deleteById(id);
		return new SuccessResult();
	}
}
