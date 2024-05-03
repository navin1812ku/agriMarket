package farmer.in.AgriMarket.dto.admin;

import farmer.in.AgriMarket.enumDto.Role;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class AdminNewRequest {
    private String adminId;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
}
