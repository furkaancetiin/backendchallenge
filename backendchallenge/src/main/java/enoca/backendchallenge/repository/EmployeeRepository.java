package enoca.backendchallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import enoca.backendchallenge.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
}
