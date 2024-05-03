package farmer.in.AgriMarket.model.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;

@Entity
@Table(name = "product")
@Data
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
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
    @Column(nullable = false)
    private String farmerId;
    @Column(nullable = false)
    private String farmerName;
    @Column(nullable = false)
    private Double farmerRatting;
    @Column(nullable = false)
    @JsonFormat(pattern = "hh:mm:ss")
    private Time time;
    private String retailerId;
    private String retailerName;
    private Double retailerRatting;
}
