package farmer.in.AgriMarket.dto.farmer;

import farmer.in.AgriMarket.enumDto.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class FarmerNewRequest {
    private String farmerId;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
}
