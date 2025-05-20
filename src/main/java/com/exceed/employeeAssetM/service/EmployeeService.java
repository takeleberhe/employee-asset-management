package com.exceed.employeeAssetM.service;
import com.exceed.employeeAssetM.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO dto);
    EmployeeDTO getEmployeeById(Long Id);
    List<EmployeeDTO>getEmployeeByDepartment(Long deptId);
    List<EmployeeDTO> searchEmployees(String name,String email);
}
