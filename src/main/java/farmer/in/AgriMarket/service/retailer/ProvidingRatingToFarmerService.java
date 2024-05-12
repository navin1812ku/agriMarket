package farmer.in.AgriMarket.service.retailer;

import farmer.in.AgriMarket.dto.retailer.ProvidingRatingToFarmerRequest;

public interface ProvidingRatingToFarmerService {
    Object provideRatingToFarmer(String retailerId, ProvidingRatingToFarmerRequest providingRatingToFarmerRequest);
}
