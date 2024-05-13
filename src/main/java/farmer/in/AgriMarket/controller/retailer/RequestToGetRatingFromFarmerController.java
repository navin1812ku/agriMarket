package farmer.in.AgriMarket.controller.retailer;


import farmer.in.AgriMarket.service.retailer.RequestToGetRatingFromFarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/retailer/getRating")
public class RequestToGetRatingFromFarmerController {

    @Autowired
    private RequestToGetRatingFromFarmerService requestToGetRatingFromFarmerService;

    @GetMapping("/{retailerId}")
    ResponseEntity<Object> getRating(@PathVariable String retailerId){
        return new ResponseEntity<>(requestToGetRatingFromFarmerService.getRatingFromFarmer(retailerId), HttpStatus.FOUND);
    }
}
