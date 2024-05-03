package farmer.in.AgriMarket.controller.farmer;

import farmer.in.AgriMarket.dto.farmer.FarmerForgetPasswordRequest;
import farmer.in.AgriMarket.service.farmer.FarmerForgetPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/farmerForgetPassword")
public class FarmerForgetPasswordController {

    @Autowired
    private FarmerForgetPasswordService farmerForgetPasswordService;

    @PutMapping("/{farmerId}")
    ResponseEntity<Object> forgetPassword(@PathVariable String farmerId, @RequestBody FarmerForgetPasswordRequest farmerForgetPasswordRequest){
        return new ResponseEntity<>(farmerForgetPasswordService.forgetPassword(farmerId, farmerForgetPasswordRequest), HttpStatus.OK);
    }
}
