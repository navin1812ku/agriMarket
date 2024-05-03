package farmer.in.AgriMarket.dto.retailer;

import lombok.Data;

@Data
public class RetailerProfileUpdateRequest {
    private String email;
    private String fullName;
    private String mobileNumber;
    private String age;
}
