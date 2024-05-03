package farmer.in.AgriMarket.repository.farmer;

import farmer.in.AgriMarket.model.farmer.FarmerModel;
import farmer.in.AgriMarket.model.retailer.RetailerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FarmerRepository extends JpaRepository<FarmerModel,String> {
    FarmerModel findByFarmerId(String farmerId);

    FarmerModel deleteByFarmerId(String farmerId);

    @Query("SELECT a FROM FarmerModel a JOIN a.farmerAddress address WHERE "+
            "address.street = :location OR " +
            "address.landMark = :location OR " +
            "address.town = :location OR " +
            "address.pinCode = :location OR " +
            "address.state = :location OR " +
            "address.country = :location"
    )
    List<FarmerModel> findByFarmerAddress(String location);
}
