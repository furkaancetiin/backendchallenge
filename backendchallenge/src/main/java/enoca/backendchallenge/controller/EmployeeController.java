package enoca.backendchallenge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import enoca.backendchallenge.entity.Employee;
import enoca.backendchallenge.service.CompanyService;
import enoca.backendchallenge.service.EmployeeService;

@Controller
public class EmployeeController {

	
	private EmployeeService employeeService;
	private CompanyService companyService;
	
	public EmployeeController(EmployeeService employeeService,CompanyService companyService) {
		super();
		this.employeeService = employeeService;
		this.companyService = companyService;
	}
	
	@GetMapping("/employees")
	public String getAll(Model model) {
		model.addAttribute("employees",this.employeeService.getAll().getData());
		return "employees";
	}
	
	@GetMapping("/employees/add")
	public String addEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
		return "add_employee";
	}
	
	@PostMapping("/employees")
	public String addEmployee(@ModelAttribute("employees") Employee employee) {
		this.employeeService.add(employee);
		return "redirect:/employees";
	}
	
	@GetMapping("/employees/update/{id}")
	public String updateEmployee(@PathVariable int id,Model model) {
		model.addAttribute("employee",this.employeeService.getEmployeeById(id).getData());
		return "update_employee";
	}
	
	@PostMapping("/employees/{id}")
	public String updateEmployee(@PathVariable int id, @ModelAttribute("employees") Employee employee, Model model) {
		
		Employee getEmployeeById = this.employeeService.getEmployeeById(id).getData();
		getEmployeeById.setFirstName(employee.getFirstName());
		getEmployeeById.setLastName(employee.getLastName());
		getEmployeeById.setCompany(employee.getCompany());
		getEmployeeById.setScore(employee.getScore());
		
		this.employeeService.update(getEmployeeById);
		return "redirect:/employees";
	}
	
	@GetMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id) {
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/employees";
	}
}
