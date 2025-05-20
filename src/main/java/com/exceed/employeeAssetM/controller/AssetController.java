package com.exceed.employeeAssetM.controller;
import com.exceed.employeeAssetM.dto.AssetDTO;
import com.exceed.employeeAssetM.mapper.AssetMapper;
import com.exceed.employeeAssetM.service.AssetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Api/Assets")
@RequiredArgsConstructor

public class AssetController {

    private final AssetService service;
    private final AssetMapper mapper;

    @PostMapping
    ResponseEntity <AssetDTO> create(AssetDTO dto){
        return ResponseEntity.ok(service.createAsset(dto));

    }

    @GetMapping("/{id}")

    ResponseEntity<AssetDTO> findAssetById(Long id){
        return ResponseEntity.ok(service.findAssetById(id));
    }

}
