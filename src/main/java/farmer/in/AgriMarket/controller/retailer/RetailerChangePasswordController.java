package farmer.in.AgriMarket.controller.retailer;


import farmer.in.AgriMarket.dto.retailer.RetailerChangePasswordRequest;
import farmer.in.AgriMarket.service.retailer.RetailerChangePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/retailer/retailerChangePassword")
public class RetailerChangePasswordController {

    @Autowired
    private RetailerChangePasswordService retailerChangePasswordService;

    @PutMapping("/{retailerId}")
    ResponseEntity<Object> changePassword(@PathVariable String retailerId, @RequestBody RetailerChangePasswordRequest retailerChangePasswordRequest){
        return new ResponseEntity<>(retailerChangePasswordService.changePassword(retailerId, retailerChangePasswordRequest), HttpStatus.CREATED);
    }
}
