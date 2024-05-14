package farmer.in.AgriMarket.dto.product;

import lombok.Data;

@Data
public class ProductUpdateRequest {
    private String productImage;
    private String productName;
    private Integer productQuantityPerKG;
    private String productDescription;
    private Double productCost;
}
