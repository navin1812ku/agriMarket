package farmer.in.AgriMarket.service.retailer;


import farmer.in.AgriMarket.dto.retailer.RetailerProfileUpdateRequest;

public interface RetailerProfileUpdateService {
    Object updateProfile(String retailerId, RetailerProfileUpdateRequest retailerProfileUpdateRequest);
}
