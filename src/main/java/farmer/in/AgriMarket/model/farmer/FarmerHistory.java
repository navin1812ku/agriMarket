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
    private String retailer;
    @Column(nullable = false)
    private String productImage;
    @Column(nullable = false)
    private String productName;
    @Column(nullable = false)
    private String productQuantity;
    @Column(nullable = false)
    private String productDescription;
    @Column(nullable = false)
    private String productCost;
}
