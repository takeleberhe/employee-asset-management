package com.exceed.employeeAssetM.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {

    private String name;
    private String email;
    private Long departmentId;

    private List<AssetDTO> assets;

    private List<String> assetNames;
}

