package farmer.in.AgriMarket.controller.retailer;


import farmer.in.AgriMarket.dto.retailer.RetailerForgetPasswordRequest;
import farmer.in.AgriMarket.service.retailer.RetailerForgetPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/retailer/retailerForgetPassword")
public class RetailerForgetPasswordController {

    @Autowired
    private RetailerForgetPasswordService retailerForgetPasswordService;

    @PutMapping("/{retailerId}")
    ResponseEntity<Object> forgetPassword(@PathVariable String retailerId, @RequestBody RetailerForgetPasswordRequest retailerForgetPasswordRequest){
        return new ResponseEntity<>(retailerForgetPasswordService.forgetPassword(retailerId,retailerForgetPasswordRequest), HttpStatus.ACCEPTED);
    }
}
