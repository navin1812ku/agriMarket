package farmer.in.AgriMarket.dto.product;


import lombok.Data;

@Data
public class AddProductRequest {
    private String farmerId;
    private String productImage;
    private String productName;
    private Integer productQuantityPerKG;
    private String productDescription;
    private Double productCost;
}
