package com.exceed.employeeAssetM.repository;
import aj.org.objectweb.asm.commons.Remapper;
import com.exceed.employeeAssetM.entity.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssetRepository extends JpaRepository<Asset ,Long> {

     // custom asset operations
     // List<Asset> FindByType(String type);
      // List <Asset> FindByEmployeeId(Long EmployeeId);

}
