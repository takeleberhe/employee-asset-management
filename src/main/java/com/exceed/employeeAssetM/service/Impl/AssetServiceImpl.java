package com.exceed.employeeAssetM.service.Impl;

import com.exceed.employeeAssetM.dto.AssetDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.exceed.employeeAssetM.service.AssetService;
import com.exceed.employeeAssetM.repository.AssetRepository;
import com.exceed.employeeAssetM.entity.Asset;
import com.exceed.employeeAssetM.mapper.AssetMapper;

@Service
@RequiredArgsConstructor

public class AssetServiceImpl implements AssetService {
    private final AssetRepository repository;
    private final AssetMapper mapper;

    @Override
    public AssetDTO createAsset(AssetDTO dto) {
        Asset asset =mapper.toEntity(dto);
        return mapper.toDto(asset);
    }

    @Override
    public AssetDTO findAssetById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Asset not found"));
    }

}
