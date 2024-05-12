package farmer.in.AgriMarket.model.farmer;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "farmer_retailer_history")
@Data
public class FarmerRetailerHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long farmerRetailerHistoryId;
    @Column(nullable = false)
    private String farmerId;
    @Column(nullable = false)
    private String productName;
    @Column(nullable = false)
    private Integer productQuantity;
    @Column(nullable = false)
    private Double productCost;
    @Column(nullable = false)
    private String retailerId;
    @Column(nullable = false)
    private String retailerName;
    @Column(nullable = false)
    private Integer retailerProductQuantity;
    @Column(nullable = false)
    private Double retailerPaidCost;
    @Column(nullable = false)
    private String retailerRating;
    @Column(nullable = false)
    private Boolean isRetailerGiveRating;
}
