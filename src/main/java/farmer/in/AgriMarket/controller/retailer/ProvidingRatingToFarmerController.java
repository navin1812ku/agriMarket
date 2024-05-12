package farmer.in.AgriMarket.controller.retailer;


import farmer.in.AgriMarket.dto.retailer.ProvidingRatingToFarmerRequest;
import farmer.in.AgriMarket.service.retailer.ProvidingRatingToFarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/retailer/providingRatingToFarmers")
public class ProvidingRatingToFarmerController {

    @Autowired
    private ProvidingRatingToFarmerService providingRatingToFarmerService;

    @PutMapping("/{retailerId}")
    ResponseEntity<Object> provideRating(@PathVariable String retailerId, @RequestBody ProvidingRatingToFarmerRequest providingRatingToFarmerRequest){
        return new ResponseEntity<>(providingRatingToFarmerService.provideRatingToFarmer(retailerId, providingRatingToFarmerRequest), HttpStatus.OK);
    }
}
