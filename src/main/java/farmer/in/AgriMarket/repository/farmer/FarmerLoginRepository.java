package farmer.in.AgriMarket.repository.farmer;

import farmer.in.AgriMarket.model.farmer.FarmerLoginModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmerLoginRepository extends JpaRepository<FarmerLoginModel,String> {
    FarmerLoginModel findByFarmerId(String farmerId);

    void deleteByFarmerId(String farmerId);
}
