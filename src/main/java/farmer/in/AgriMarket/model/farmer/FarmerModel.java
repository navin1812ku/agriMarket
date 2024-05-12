package farmer.in.AgriMarket.model.farmer;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "farmer")
@Data
public class FarmerModel {
    @Id
    private String farmerId;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private String fullName;
    private String mobileNumber;
    private String age;
    private Double rating;
    @OneToOne
    @JoinColumn(name = "farmerId")
    private FarmerAddress farmerAddress;
    @OneToMany
    @JoinColumn(name = "farmerId")
    private List<FarmerRetailerHistory> farmerRetailerHistory;
    @OneToMany
    @JoinColumn(name="farmerId")
    private List<FarmerProductHistory> farmerProductHistories;
}
