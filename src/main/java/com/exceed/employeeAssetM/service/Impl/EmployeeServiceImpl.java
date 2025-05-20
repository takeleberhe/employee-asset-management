package com.exceed.employeeAssetM.service.Impl;

import com.exceed.employeeAssetM.dto.EmployeeDTO;
import com.exceed.employeeAssetM.service.EmployeeService;
import com.exceed.employeeAssetM.entity.Employee;
import com.exceed.employeeAssetM.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.exceed.employeeAssetM.repository.EmplRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor

@Slf4j
@Service
public class EmployeeServiceImpl  implements EmployeeService {

    private final EmplRepository employeeRepository;
    private final EmployeeMapper employeeMapper;


    @Override
    public EmployeeDTO createEmployee(EmployeeDTO dto) {
        Employee employee = employeeMapper.toEntity(dto);
        employeeRepository.save(employee);
        return employeeMapper.toDto(employee);
    }


    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .map(employeeMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public List<EmployeeDTO> getEmployeeByDepartment(Long deptId) {
        return employeeRepository.findAll().stream()
                .filter(emp->emp.getDepartment().getId().equals(deptId))
                .map(employeeMapper::toDto).collect(Collectors.toList());
    }


    @Override
    public List<EmployeeDTO> searchEmployees(String name, String email) {
        return employeeRepository.findAll().stream().filter(emp->emp.getName().contains(name)||emp.getEmail()
                .contains(email)).map(employeeMapper::toDto)
                .collect(Collectors.toList());
    }
}
