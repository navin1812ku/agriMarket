package farmer.in.AgriMarket.dto.farmer;

import lombok.Data;

@Data
public class FarmerAddressUpdateRequest {
    private String houseNumber;
    private String street;
    private String landMark;
    private String pinCode;
    private String town;
    private String state;
    private String country;
}
