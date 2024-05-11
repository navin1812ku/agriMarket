package farmer.in.AgriMarket.model.product;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class ProductModel {
    @Id
    private Long productId;
    @Column(nullable = false)
    private String productImage;
    @Column(nullable = false)
    private String productName;
    @Column(nullable = false)
    private Integer productQuantityPerKG;
    @Column(nullable = false)
    private String productDescription;
    @Column(nullable = false)
    private Double productCost;
    @Column(nullable = false)
    private String farmerId;
    @Column(nullable = false)
    private String farmerName;
    @Column(nullable = false)
    private String farmerRatting;
}
