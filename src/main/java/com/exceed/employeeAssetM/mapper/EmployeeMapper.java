package com.exceed.employeeAssetM.mapper;

import com.exceed.employeeAssetM.dto.EmployeeDTO;
import com.exceed.employeeAssetM.entity.Department;
import com.exceed.employeeAssetM.entity.Employee;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = { AssetMapper.class })
public interface EmployeeMapper {

    @Mappings({
            @Mapping(target = "department", expression = "java(mapDepartment(dto.getDepartmentId()))")
    })
    Employee toEntity(EmployeeDTO dto);

    @Mapping(target = "departmentId", source = "department.id")
    EmployeeDTO toDto(Employee employee);

    default Department mapDepartment(Long id) {
        if (id == null) return null;
        return Department.builder().id(id).build();
    }
}
