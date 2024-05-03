package farmer.in.AgriMarket.service.farmer;

import farmer.in.AgriMarket.dto.farmer.FarmerAddressUpdateRequest;

public interface FarmerAddressUpdateService {
    Object addressUpdate(String farmerId, FarmerAddressUpdateRequest farmerAddressUpdateRequest);
}
