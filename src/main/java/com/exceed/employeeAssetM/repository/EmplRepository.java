package com.exceed.employeeAssetM.repository;

import com.exceed.employeeAssetM.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmplRepository extends JpaRepository<Employee, Long> {
    // For request param filters
     // List<Employee> findByName(String name);
    //  List<Employee> findByEmail(String email);
     //  List<Employee> findByDepartmentId(Long departmentId);

    // Multiple filters combined (auto query generator)
       //  List<Employee> findByNameAndEmail(String name, String email);
}

