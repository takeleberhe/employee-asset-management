package com.exceed.employeeAssetM.repository;
import com.exceed.employeeAssetM.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

         List<Department> findByDepName(String deptName);

}
