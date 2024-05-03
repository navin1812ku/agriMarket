package farmer.in.AgriMarket.service.retailer;

import farmer.in.AgriMarket.dto.retailer.RetailerChangePasswordRequest;

public interface RetailerChangePasswordService {
    Object changePassword(String retailerID, RetailerChangePasswordRequest retailerChangePasswordRequest);
}
