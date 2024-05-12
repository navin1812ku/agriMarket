package farmer.in.AgriMarket.controller.farmer;


import farmer.in.AgriMarket.dto.farmer.ProvidingRatingToRetailerRequest;
import farmer.in.AgriMarket.service.farmer.ProvidingRatingToRetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/farmer/providingRatingToFarmer")
public class ProvidingRatingToRetailerController {

    @Autowired
    private ProvidingRatingToRetailerService providingRatingToRetailerService;

    @PutMapping("/{farmerId}")
    ResponseEntity<Object> providingRating(@PathVariable String farmerId, @RequestBody ProvidingRatingToRetailerRequest providingRatingToRetailerRequest){
        return new ResponseEntity<>(providingRatingToRetailerService.providingRatingToRetailer(farmerId, providingRatingToRetailerRequest), HttpStatus.OK);
    }
}
