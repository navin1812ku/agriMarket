package farmer.in.AgriMarket.service.retailer;

import farmer.in.AgriMarket.dto.retailer.RetailerAddressUpdateRequest;

public interface RetailerAddressUpdateService {
    Object addressUpdate(String retailerId, RetailerAddressUpdateRequest retailerAddressUpdateRequest);
}
