package farmer.in.AgriMarket.repository.retailer;

import farmer.in.AgriMarket.model.retailer.RetailerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RetailerRepository extends JpaRepository<RetailerModel, String> {
    RetailerModel findByRetailerId(String retailerId);

    RetailerModel deleteByRetailerId(String farmerId);
    @Query("SELECT a FROM RetailerModel a JOIN a.retailerAddress address WHERE "+
            "address.street = :location OR " +
            "address.landMark = :location OR " +
            "address.town = :location OR " +
            "address.pinCode = :location OR " +
            "address.state = :location OR " +
            "address.country = :location"
    )
    List<RetailerModel> findByRetailerAddress(String location);
}
