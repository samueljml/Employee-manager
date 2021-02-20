package sam.employeemanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sam.employeemanager.exception.UserNotFoundException;
import sam.employeemanager.model.Employee;
import sam.employeemanager.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return repository.save(employee);
	}
	
	public List<Employee> findAllEmployees() {
		return repository.findAll();
	}
	
	public Employee updateEmployee(Employee employee) {
		return repository.save(employee);
	}
	
	public void deleteEmployee(Long id) {
		repository.deleteEmployeeById(id);
	}
	
	public Employee findEmployeeById(Long id) {
        return repository.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }
}
