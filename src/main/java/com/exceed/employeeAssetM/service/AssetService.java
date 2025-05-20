package com.exceed.employeeAssetM.service;
import com.exceed.employeeAssetM.dto.AssetDTO;


public interface AssetService {
    AssetDTO createAsset(AssetDTO dto);
    AssetDTO findAssetById(Long id);

}
