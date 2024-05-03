package farmer.in.AgriMarket.model.retailer;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "retailer_history")
@Data
public class RetailerHistory {
    @Id
    private String retailerId;
    @Column(nullable = false)
    private String farmerName;
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
