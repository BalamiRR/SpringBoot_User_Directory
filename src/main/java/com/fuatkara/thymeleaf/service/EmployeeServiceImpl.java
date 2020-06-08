package com.fuatkara.thymeleaf.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.fuatkara.thymeleaf.dao.EmployeeRepository;
import com.fuatkara.thymeleaf.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	// Set up constructor injection
	// Qualifier kullandik cunku hibernate kullanimiyoz artik JPA kullaniyoruz Fakat unutma ki
	// Qualifierin icine sinifin adini yazdik ama kucuk harfle olucak kural!!!  BEAN ID yani
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int saveId) {
		
		//Bu islemi yapmak icin employeeRepository.findById(saveId) secili hale getir,
		Optional<Employee> result = employeeRepository.findById(saveId);
		
		Employee theEmployee = null;
		
		if(result.isPresent()) {
			theEmployee = result.get();
		}
		
		else {
			throw new RuntimeException("Did not find employee" + saveId);
		}
		
		return theEmployee;
	}

	@Override
	public void save(Employee insertEmployee) {
		employeeRepository.save(insertEmployee);
	}

	@Override
	public void deleteById(int deleteId) {
		employeeRepository.deleteById(deleteId);
	}

}