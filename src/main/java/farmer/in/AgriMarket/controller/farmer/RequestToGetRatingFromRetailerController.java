package farmer.in.AgriMarket.controller.farmer;


import farmer.in.AgriMarket.service.farmer.RequestToGetRatingFromRetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/farmer/getRating")
public class RequestToGetRatingFromRetailerController {

    @Autowired
    private RequestToGetRatingFromRetailerService requestToGetRatingFromRetailerService;

    @GetMapping("/{farmerId}")
    ResponseEntity<Object> getRating(@PathVariable String farmerId){
        return new ResponseEntity<>(requestToGetRatingFromRetailerService.getRatingFromRetailer(farmerId), HttpStatus.FOUND);
    }
}
