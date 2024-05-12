package farmer.in.AgriMarket.repository.retailer;

import farmer.in.AgriMarket.model.retailer.RetailerFarmerHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RetailerFarmerHistoryRepository extends JpaRepository<RetailerFarmerHistory, Long> {

    List<RetailerFarmerHistory> findByFarmerId(String farmerId);
}
