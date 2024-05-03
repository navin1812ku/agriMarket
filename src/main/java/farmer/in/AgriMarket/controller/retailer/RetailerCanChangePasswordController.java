package farmer.in.AgriMarket.controller.retailer;


import farmer.in.AgriMarket.dto.retailer.RetailerCanChangePasswordRequest;
import farmer.in.AgriMarket.service.retailer.RetailerCanChangePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/retailerCanChangePassword")
public class RetailerCanChangePasswordController {

    @Autowired
    private RetailerCanChangePasswordService retailerCanChangePasswordService;

    @PostMapping("/{retailerId}")
    ResponseEntity<Object> canChangePassword(@PathVariable String retailerId, @RequestBody RetailerCanChangePasswordRequest retailerCanChangePasswordRequest){
        return new ResponseEntity<>(retailerCanChangePasswordService.canChangePassword(retailerId, retailerCanChangePasswordRequest), HttpStatus.FOUND);
    }
}
