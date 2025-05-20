package com.exceed.employeeAssetM.mapper;
import com.exceed.employeeAssetM.dto.DepartmentDTO;
import com.exceed.employeeAssetM.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    DepartmentMapper INSTANCE=Mappers.getMapper(DepartmentMapper.class);

    DepartmentDTO toDto(Department department);

    Department toEntity(DepartmentDTO departmentDto);

}
