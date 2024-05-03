package farmer.in.AgriMarket.service.farmer;

import farmer.in.AgriMarket.dto.farmer.FarmerForgetPasswordRequest;

public interface FarmerForgetPasswordService {
    Object forgetPassword(String farmerId, FarmerForgetPasswordRequest farmerForgetPasswordRequest);
}
