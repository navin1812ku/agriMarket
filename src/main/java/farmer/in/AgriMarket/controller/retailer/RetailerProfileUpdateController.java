package farmer.in.AgriMarket.controller.retailer;


import farmer.in.AgriMarket.dto.retailer.RetailerProfileUpdateRequest;
import farmer.in.AgriMarket.service.retailer.RetailerProfileUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/retailerProfileUpdate")
public class RetailerProfileUpdateController {

    @Autowired
    private RetailerProfileUpdateService retailerProfileUpdateService;

    @PutMapping("/{retailerId}")
    ResponseEntity<Object> updateProfile(@PathVariable String retailerId, @RequestBody RetailerProfileUpdateRequest retailerProfileUpdateRequest){
        return new ResponseEntity<>(retailerProfileUpdateService.updateProfile(retailerId, retailerProfileUpdateRequest), HttpStatus.ACCEPTED);
    }
}
