package farmer.in.AgriMarket.dto.retailer;

import lombok.Data;

@Data
public class RetailerAddressUpdateRequest {
    private String houseNumber;
    private String street;
    private String landMark;
    private String pinCode;
    private String town;
    private String state;
    private String country;
}
