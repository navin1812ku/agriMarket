package farmer.in.AgriMarket.dto.farmer;

import lombok.Data;

@Data
public class ProvidingRatingToRetailerRequest {
    private String retailerId;
    private Double retailerRating;
}
