package farmer.in.AgriMarket.dto.product;


import lombok.Data;

@Data
public class CalculateTotalAmountRequest {
    private Long productId;
    private String retailerId;
    private Double retailerProductQuantity;
}
