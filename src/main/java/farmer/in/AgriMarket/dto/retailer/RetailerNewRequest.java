package farmer.in.AgriMarket.dto.retailer;


import farmer.in.AgriMarket.enumDto.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class RetailerNewRequest {
    private String retailerId;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
}
