package farmer.in.AgriMarket.service.farmer;

import farmer.in.AgriMarket.dto.farmer.FarmerCanChangePasswordRequest;

public interface FarmerCanChangePasswordService {
    Object changePasswordIsPossible(String farmerId, FarmerCanChangePasswordRequest farmerCanChangePasswordRequest);
}
