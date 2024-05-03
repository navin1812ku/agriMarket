package farmer.in.AgriMarket.service.farmer;

import farmer.in.AgriMarket.dto.farmer.FarmerChangePasswordRequest;

public interface FarmerChangePasswordService {
    Object changePassword(String farmerId, FarmerChangePasswordRequest farmerChangePasswordRequest);
}
