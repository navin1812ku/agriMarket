package farmer.in.AgriMarket.controller.farmer;


import farmer.in.AgriMarket.dto.farmer.FarmerChangePasswordRequest;
import farmer.in.AgriMarket.service.farmer.FarmerChangePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/farmer/farmerChangePassword")
public class FarmerChangePasswordController {

    @Autowired
    private FarmerChangePasswordService farmerChangePasswordService;

    @PutMapping("/{farmerId}")
    ResponseEntity<Object> changePassword(@PathVariable String farmerId, @RequestBody FarmerChangePasswordRequest farmerChangePasswordRequest){
        return new ResponseEntity<>(farmerChangePasswordService.changePassword(farmerId,farmerChangePasswordRequest), HttpStatus.CREATED);
    }
}
