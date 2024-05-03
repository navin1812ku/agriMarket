package farmer.in.AgriMarket.repository.randomNumber;

import farmer.in.AgriMarket.model.randomNumber.RandomNumberModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RandomNumberRepository extends JpaRepository<RandomNumberModel , Long> {
    RandomNumberModel findByRandomNumber(Long randomNumber);
}
