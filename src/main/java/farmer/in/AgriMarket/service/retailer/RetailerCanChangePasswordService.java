package farmer.in.AgriMarket.service.retailer;

import farmer.in.AgriMarket.dto.retailer.RetailerCanChangePasswordRequest;

public interface RetailerCanChangePasswordService {
    Object canChangePassword(String retailerId, RetailerCanChangePasswordRequest retailerCanChangePasswordRequest);
}
