package farmer.in.AgriMarket.repository.retailer;


import farmer.in.AgriMarket.model.retailer.RetailerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetailerAddressRepository extends JpaRepository<RetailerAddress,String> {
    RetailerAddress findByRetailerId(String retailerId);
}
