package farmer.in.AgriMarket.model.retailer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "retailer_address")
@Data
public class RetailerAddress {
    @Id
    private String retailerId;
    @Column(nullable = false)
    private String houseNumber;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String landMark;
    @Column(nullable = false)
    private String pinCode;
    @Column(nullable = false)
    private String town;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false)
    private String country;
}
