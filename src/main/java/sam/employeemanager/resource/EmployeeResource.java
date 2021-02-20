package sam.employeemanager.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sam.employeemanager.model.Employee;
import sam.employeemanager.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {

	@Autowired
	private EmployeeService service;
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees () {
		List<Employee> employees = service.findAllEmployees(); 
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) {
		Employee employee = service.findEmployeeById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee createdEmployee = service.addEmployee(employee);
		return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
	}
	
	@PutMapping("/update}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee newEmployee) {
		Employee updatedEmployee = service.updateEmployee(newEmployee);
		return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id) {
		service.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}