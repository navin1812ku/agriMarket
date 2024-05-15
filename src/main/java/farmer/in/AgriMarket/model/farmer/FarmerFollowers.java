package farmer.in.AgriMarket.model.farmer;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "farmerFollowers")
@Data
public class FarmerFollowers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long followerId;
    @Column(nullable = false)
    private String farmerId;
    private String id;
    private Boolean isYouFollowing;
}
