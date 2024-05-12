package farmer.in.AgriMarket.dto.product;


import lombok.Data;

@Data
public class ProductPlaceOrderRequest {
    private Long productId;
    private String retailerId;
    private Integer retailerProductQuantity;
    private Boolean paymentPaid;
}
