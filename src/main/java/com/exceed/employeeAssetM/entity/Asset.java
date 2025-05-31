package com.exceed.employeeAssetM.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Asset name must not be blank")
    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
