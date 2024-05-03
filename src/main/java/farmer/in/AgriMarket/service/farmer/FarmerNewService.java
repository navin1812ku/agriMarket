package farmer.in.AgriMarket.service.farmer;

import farmer.in.AgriMarket.dto.farmer.FarmerNewRequest;

import java.util.List;

public interface FarmerNewService {
    List<Object> addFarmer(FarmerNewRequest farmerNewRequest);
}
