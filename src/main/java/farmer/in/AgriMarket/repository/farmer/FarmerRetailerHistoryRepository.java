package farmer.in.AgriMarket.repository.farmer;

import farmer.in.AgriMarket.model.farmer.FarmerRetailerHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FarmerRetailerHistoryRepository extends JpaRepository<FarmerRetailerHistory, Long> {

    List<FarmerRetailerHistory> findByRetailerId(String retailerId);
}
