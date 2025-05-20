package com.exceed.employeeAssetM.mapper;

import com.exceed.employeeAssetM.dto.AssetDTO;
import com.exceed.employeeAssetM.entity.Asset;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AssetMapper {
    AssetDTO toDto(Asset asset);
    Asset toEntity(AssetDTO dto);
}
