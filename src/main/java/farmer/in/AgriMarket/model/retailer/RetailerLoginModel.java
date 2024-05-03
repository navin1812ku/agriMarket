package farmer.in.AgriMarket.model.retailer;


import farmer.in.AgriMarket.enumDto.Role;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "retailer_login")
@Data
public class RetailerLoginModel {
    @Id
    private String retailerId;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
}
