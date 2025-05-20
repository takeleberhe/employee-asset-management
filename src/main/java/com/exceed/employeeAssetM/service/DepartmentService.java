package com.exceed.employeeAssetM.service;
import com.exceed.employeeAssetM.dto.DepartmentDTO;


public interface DepartmentService {
    DepartmentDTO createDepartment(DepartmentDTO dto);
    DepartmentDTO getDepartmentById(Long id);

}
