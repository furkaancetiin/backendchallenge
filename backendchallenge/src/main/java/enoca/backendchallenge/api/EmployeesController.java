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
import enoca.backendchallenge.entity.Employee;
import enoca.backendchallenge.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

	private EmployeeService employeeService;

	public EmployeesController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping("/getall")
	public DataResult<List<Employee>> getAll() {
		return this.employeeService.getAll();
	}

	@GetMapping("/getbyid")
	public DataResult<Employee> getById(@RequestParam("id") int id) {
		return this.employeeService.getEmployeeById(id);
	}

	@PostMapping("/add")
	public Result add(@RequestBody Employee employee) {
		return this.employeeService.add(employee);
	}

	@PostMapping("/update")
	public Result update(@RequestBody Employee employee) {
		return this.employeeService.update(employee);
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id) {
		return this.employeeService.deleteEmployeeById(id);
	}
}
