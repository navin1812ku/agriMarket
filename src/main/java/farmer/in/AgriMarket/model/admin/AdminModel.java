package farmer.in.AgriMarket.model.admin;

import farmer.in.AgriMarket.enumDto.Role;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "admin")
@Data
public class AdminModel {
    @Id
    private String adminId;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
}
