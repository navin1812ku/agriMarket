package farmer.in.AgriMarket.repository.farmer;

import farmer.in.AgriMarket.model.farmer.FarmerProductHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmerProductHistoryRepository extends JpaRepository<FarmerProductHistory,Long> {

    FarmerProductHistory findByFarmerIdAndProductId(String farmerId, Long productId);
}
