package farmer.in.AgriMarket.dto.farmer;

import lombok.Data;

@Data
public class FarmerProfileUpdateRequest {
    private String email;
    private String fullName;
    private String mobileNumber;
    private String age;
}
