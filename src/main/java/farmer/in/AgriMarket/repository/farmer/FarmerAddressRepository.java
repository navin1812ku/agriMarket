package farmer.in.AgriMarket.repository.farmer;

import farmer.in.AgriMarket.model.farmer.FarmerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmerAddressRepository extends JpaRepository<FarmerAddress,String> {
    FarmerAddress findByFarmerId(String farmerId);
}
