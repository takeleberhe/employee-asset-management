package com.exceed.employeeAssetM.controller;
import com.exceed.employeeAssetM.service.DepartmentService;
import com.exceed.employeeAssetM.dto.DepartmentDTO;
import com.exceed.employeeAssetM.entity.Department;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Api/Department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService service;

     @PostMapping
    public ResponseEntity<DepartmentDTO> create(@RequestBody DepartmentDTO dto){
        return ResponseEntity.ok(service.createDepartment(dto));

    }
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.getDepartmentById(id));
    }

}
