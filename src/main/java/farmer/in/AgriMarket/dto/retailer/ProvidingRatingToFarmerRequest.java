package farmer.in.AgriMarket.dto.retailer;

import lombok.Data;

@Data
public class ProvidingRatingToFarmerRequest {
    private String farmerId;
    private Double farmerRating;
}
