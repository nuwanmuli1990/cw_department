package com.iit.department.service;

import java.util.List;

import com.iit.department.models.DepartmentResponse;

public interface DepartmentService {

	List<DepartmentResponse> getDepartments();
	
	DepartmentResponse getDepartment(Long id);
	
}
