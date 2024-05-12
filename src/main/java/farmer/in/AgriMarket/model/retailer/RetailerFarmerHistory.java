package farmer.in.AgriMarket.model.retailer;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "retailer_farmer_history")
@Data
public class RetailerFarmerHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long retailerFarmerHistoryId;
    @Column(nullable = false)
    private String retailerId;
    @Column(nullable = false)
    private String farmerId;
    @Column(nullable = false)
    private String farmerName;
    @Column(nullable = false)
    private String farmerRating;
    @Column(nullable = false)
    private String productName;
    @Column(nullable = false)
    private Double productCost;
    @Column(nullable = false)
    private Integer retailerProductQuantity;
    @Column(nullable = false)
    private Double retailerPaidAmount;
    @Column(nullable = false)
    private Boolean isFarmerGiveRating;
}
