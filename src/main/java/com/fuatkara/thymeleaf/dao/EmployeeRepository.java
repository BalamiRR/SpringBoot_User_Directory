package com.fuatkara.thymeleaf.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.fuatkara.thymeleaf.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// thats it  .. no need to write any code
	// Buraya herhangi bir kod yazmicaz o otomatik olarak bize CRUD yapmamizi sagliyor.
	
	// add a method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();
	
}