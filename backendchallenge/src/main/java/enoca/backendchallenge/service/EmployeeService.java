package enoca.backendchallenge.service;

import java.util.List;

import enoca.backendchallenge.core.utilities.results.DataResult;
import enoca.backendchallenge.core.utilities.results.Result;
import enoca.backendchallenge.entity.Employee;

public interface EmployeeService {
	DataResult<List<Employee>> getAll();

	Result add(Employee employee);

	Result update(Employee employee);

	DataResult<Employee> getEmployeeById(int id);

	Result deleteEmployeeById(int id);
}
