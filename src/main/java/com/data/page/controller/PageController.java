package com.data.page.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.data.page.entity.Employee;
import com.data.page.service.EmployeeService;

@RestController
public class PageController {
	
	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return paging 
	 */
	@GetMapping("employee/{pageNo}/{pageSize}/{sortBy}/{sortDir}")
	public List<Employee> getpage(@PathVariable(value = "pageNo", required = false) int pageNo,
			@PathVariable int pageSize,@PathVariable String sortBy,@PathVariable String sortDir){
		
		return employeeService.findPaginate(pageNo,pageSize,sortBy,sortDir);
	}
	
//	@GetMapping("/empByName")
//	public List<Employee> getnameByAsc(){
//		return employeeService.findAllOrderByName();
//	}
//	
//	@GetMapping("/empByNameDesc")
//	public List<Employee> getnameByDesc(){
//		return employeeService.findAllOrderByNames();
//	}

}
