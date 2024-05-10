package farmer.in.AgriMarket.controller.retailer;


import farmer.in.AgriMarket.service.retailer.RetailerProfileViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/retailer/retailerProfile")
public class RetailerProfileViewController {

    @Autowired
    private RetailerProfileViewService retailerProfileViewService;

    @GetMapping("/{retailerId}")
    ResponseEntity<Object> getProfile(@PathVariable String retailerId){
        return new ResponseEntity<>(retailerProfileViewService.getProfile(retailerId), HttpStatus.FOUND);
    }
}
