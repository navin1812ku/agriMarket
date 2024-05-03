package farmer.in.AgriMarket.service.retailer;

import farmer.in.AgriMarket.dto.retailer.RetailerNewRequest;

import java.util.List;

public interface RetailerNewService {
    List<Object> addRetailer(RetailerNewRequest retailerNewRequest);
}
