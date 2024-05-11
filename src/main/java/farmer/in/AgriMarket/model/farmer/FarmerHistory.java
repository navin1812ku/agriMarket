package farmer.in.AgriMarket.model.farmer;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "farmer_history")
@Data
public class FarmerHistory {
    @Id
    private String farmerId;
    @Column(nullable = false)
    private String retailerId;
    @Column(nullable = false)
    private String retailerName;
    @Column(nullable = false)
    private String productName;
    @Column(nullable = false)
    private String productQuantity;
    @Column(nullable = false)
    private String productCost;
    @Column(nullable = false)
    private String retailerProductQuantity;
    @Column(nullable = false)
    private String retailerPaidCost;
    @Column(nullable = false)
    private String totalProfitOfProduct;
}
