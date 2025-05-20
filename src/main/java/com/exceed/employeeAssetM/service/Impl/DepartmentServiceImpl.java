package com.exceed.employeeAssetM.service.Impl;

import com.exceed.employeeAssetM.dto.DepartmentDTO;
import com.exceed.employeeAssetM.entity.Department;
import com.exceed.employeeAssetM.exception.DepartmentNotFoundException;
import com.exceed.employeeAssetM.mapper.DepartmentMapper;
import com.exceed.employeeAssetM.repository.DepartmentRepository;
import com.exceed.employeeAssetM.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j // Enables logging with "log.info", "log.error", etc.
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;
    private final DepartmentMapper mapper;

    @Override
    public DepartmentDTO createDepartment(DepartmentDTO dto) {
        try {
            Department department = mapper.toEntity(dto);
            Department saved = repository.save(department);
            log.info("✅ Department created with ID: {}", saved.getId());
            return mapper.toDto(saved);
        } catch (Exception e) {
            log.error("❌ Failed to create department: {}", e.getMessage(), e);
            throw new RuntimeException("Unable to create department. Please try again later.");
        }
    }

    @Override
    public DepartmentDTO getDepartmentById(Long id) {
        try {
            return repository.findById(id)
                    .map(mapper::toDto)
                    .orElseThrow(() -> {
                        log.warn("⚠️ Department not found with ID: {}", id);
                        return new DepartmentNotFoundException("Department not found with ID: " + id);
                    });
        } catch (DepartmentNotFoundException e) {
            throw e; // Let it bubble up to be handled by @ControllerAdvice
        } catch (Exception e) {
            log.error("❌ Error fetching department with ID: {}", id, e);
            throw new RuntimeException("Unable to fetch department. Please try again later.");
        }
    }
}
