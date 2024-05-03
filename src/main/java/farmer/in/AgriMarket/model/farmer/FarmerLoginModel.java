package farmer.in.AgriMarket.model.farmer;


import farmer.in.AgriMarket.enumDto.Role;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "farmer_login")
@Data
public class FarmerLoginModel {
    @Id
    private String farmerId;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
}
