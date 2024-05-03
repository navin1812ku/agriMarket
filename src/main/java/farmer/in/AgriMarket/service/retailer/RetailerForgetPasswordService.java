package farmer.in.AgriMarket.service.retailer;

import farmer.in.AgriMarket.dto.retailer.RetailerForgetPasswordRequest;

public interface RetailerForgetPasswordService {
    Object forgetPassword(String retailerId, RetailerForgetPasswordRequest retailerForgetPasswordRequest);
}
