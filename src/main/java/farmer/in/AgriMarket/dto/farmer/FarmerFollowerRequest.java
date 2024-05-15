package farmer.in.AgriMarket.dto.farmer;


import lombok.Data;

@Data
public class FarmerFollowerRequest {
    private String farmerId;
    private String id;
    private Boolean isYouFollowing;
}
