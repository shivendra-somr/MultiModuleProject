package com.agsft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
@RequestMapping("/api/gateway")
public class GatewayController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/employee-data")
	public String getEmployeeData() {
		String employeeDataUrl = "http://localhost:8081/employee-data/getEmployeeList";
		String str = restTemplate.getForObject(employeeDataUrl, String.class);
		return str;
	}
	
	@PostMapping("/employee/create")
	public ResponseEntity<Employee> createNewEmployee(@RequestBody Employee employee) {
		String registerUrl = "http://localhost:8081/employee-data/register/newEmployee";
		HttpEntity<Employee> httpEntity = new HttpEntity<>(employee);
		ResponseEntity<Employee> emp = restTemplate.postForEntity(registerUrl, httpEntity, Employee.class);
		return new ResponseEntity<Employee>(emp.getBody(),emp.getStatusCode());
	}
	
	@GetMapping("/epmloyee/{id}")
	public ResponseEntity<Employee> getEmployeebyId(@PathVariable("id") Long empId){
		String getUrl = "http://localhost:8081/employee-data/getEmployeeById/"+empId;
		Employee emp = restTemplate.getForObject(getUrl, Employee.class);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long empId){
		String deleteUrl = "http://localhost:8081/employee-data/deleteEmployee/"+empId;
		restTemplate.delete(deleteUrl);
		return new ResponseEntity<String>("Employee Deleted Successfully", HttpStatus.OK);
	}
	
	@PostMapping("/employee-attendance/create/{id}")
	public ResponseEntity<Attendance> createAttendance(@RequestBody Attendance attendance,@PathVariable("id") Long empId, @RequestParam String designation){
		String registerUrl = "http://localhost:8082/employee-attendance/createAttendance/"+empId+"?designation="+designation;
		HttpEntity<Attendance> httpEntity = new HttpEntity<>(attendance);
		ResponseEntity<Attendance> emp = restTemplate.postForEntity(registerUrl, httpEntity, Attendance.class);
		return new ResponseEntity<Attendance>(emp.getBody(),emp.getStatusCode());
	}
	
	@GetMapping("/employee-project/new")
	public ResponseEntity<String> getProject(){
		String getUrl = "http://localhost:8083/employee-project/getProject";
		String res = restTemplate.getForObject(getUrl, String.class);
		return new ResponseEntity<String>(res, HttpStatus.OK);
	}
	
	@GetMapping("/employee-salary/new")
	public ResponseEntity<String> getSalary(){
		String getUrl = "http://localhost:8084/employee-salary/newSalary";
		String res = restTemplate.getForObject(getUrl, String.class);
		return new ResponseEntity<String>(res, HttpStatus.OK);
	}
	
	@GetMapping("/calculation/new")
	public ResponseEntity<String> getCalc(){
		String getUrl = "http://localhost:8085/calculation/newCalculation";
		String res = restTemplate.getForObject(getUrl, String.class);
		return new ResponseEntity<String>(res, HttpStatus.OK);
	}
	
	@GetMapping("/utils/new")
	public ResponseEntity<String> getUtils(){
		String getUrl = "http://localhost:8086/common-util/getUtils";
		String res = restTemplate.getForObject(getUrl, String.class);
		return new ResponseEntity<String>(res, HttpStatus.OK);
	}
	
}
