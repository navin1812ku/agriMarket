package farmer.in.AgriMarket.model.farmer;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "farmer_product_history")
@Data
public class FarmerProductHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long farmerProductHistoryId;
    @Column(nullable = false)
    private String farmerId;
    @Column(nullable = false)
    private Long productId;
    @Column(nullable = false)
    private String productName;
    @Column(nullable = false)
    private Integer productQuantity;
    @Column(nullable = false)
    private Double productCost;
    @Column(nullable = false)
    private Double totalProfitCost;
}
