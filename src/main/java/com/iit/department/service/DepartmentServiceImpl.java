package com.iit.department.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.iit.department.entities.Department;
import com.iit.department.models.DepartmentResponse;
import com.iit.department.repositories.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;


	@Autowired
	private HttpServletRequest request;

	@Override
	public List<DepartmentResponse> getDepartments() {

		List<Department> departments = departmentRepository.findAll();

		List<DepartmentResponse> response = new ArrayList<>();
		for (Department department : departments) {

			DepartmentResponse studentResponse = new DepartmentResponse(department.getId(), department.getName(),
					department.getNoOfEmployees());
			response.add(studentResponse);
		}

		return response;
	}

	@Override
	public DepartmentResponse getDepartment(Long id) {

		DepartmentResponse response = new DepartmentResponse();
		Optional<Department> optionalDepartment = departmentRepository.findById(id);
		if (optionalDepartment.isPresent()) {

			response.setId(optionalDepartment.get().getId());
			response.setName(optionalDepartment.get().getName());
			response.setNoOfEmployees(optionalDepartment.get().getNoOfEmployees());

		}
		return response;
	}
}
