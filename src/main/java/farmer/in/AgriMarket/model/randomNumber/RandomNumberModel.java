package farmer.in.AgriMarket.model.randomNumber;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "random_number")
@Data
public class RandomNumberModel {
    @Id
    private Long randomNumber;
}
