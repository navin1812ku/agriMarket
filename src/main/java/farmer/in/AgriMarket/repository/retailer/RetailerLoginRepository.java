package farmer.in.AgriMarket.repository.retailer;

import farmer.in.AgriMarket.model.retailer.RetailerLoginModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetailerLoginRepository extends JpaRepository<RetailerLoginModel,String> {
    RetailerLoginModel findByRetailerId(String retailerId);

    void deleteByRetailerId(String farmerId);
}
