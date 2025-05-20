package com.exceed.employeeAssetM.controller;
import com.exceed.employeeAssetM.service.EmployeeService;
import com.exceed.employeeAssetM.dto.EmployeeDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api/Employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService service;

    @PostMapping
   public ResponseEntity<EmployeeDTO> create(@Valid  @RequestBody EmployeeDTO dto){
        return ResponseEntity.ok(service.createEmployee(dto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id ){
        return ResponseEntity.ok(service.getEmployeeById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<EmployeeDTO>> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ) {
        return ResponseEntity.ok(service.searchEmployees(name, email));
    }

}
