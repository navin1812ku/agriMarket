package farmer.in.AgriMarket.model.retailer;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "retailer")
@Data
public class RetailerModel {
    @Id
    private String retailerId;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private String fullName;
    private String mobileNumber;
    private String age;
    private Double rating;
    @OneToOne
    @JoinColumn(name = "retailerId")
    private RetailerAddress retailerAddress;
    @OneToMany
    @JoinColumn(name = "retailerId")
    private List<RetailerFarmerHistory> retailerFarmerHistory;
}
