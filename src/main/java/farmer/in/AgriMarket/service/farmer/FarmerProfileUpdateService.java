package farmer.in.AgriMarket.service.farmer;

import farmer.in.AgriMarket.dto.farmer.FarmerProfileUpdateRequest;

public interface FarmerProfileUpdateService {
    Object updateProfile(String farmerId, FarmerProfileUpdateRequest farmerProfileUpdateRequest);
}
