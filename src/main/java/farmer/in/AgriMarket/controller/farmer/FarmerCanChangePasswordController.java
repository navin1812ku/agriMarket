package farmer.in.AgriMarket.controller.farmer;


import farmer.in.AgriMarket.dto.farmer.FarmerCanChangePasswordRequest;
import farmer.in.AgriMarket.service.farmer.FarmerCanChangePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/farmerCanChangePassword")
public class FarmerCanChangePasswordController {

    @Autowired
    private FarmerCanChangePasswordService farmerCanChangePasswordService;

    @PostMapping("/{farmerId}")
    ResponseEntity<Object> changePassword(@PathVariable String farmerId, @RequestBody FarmerCanChangePasswordRequest farmerCanChangePasswordRequest){
        return new ResponseEntity<>(farmerCanChangePasswordService.changePasswordIsPossible(farmerId, farmerCanChangePasswordRequest), HttpStatus.ACCEPTED);
    }
}
