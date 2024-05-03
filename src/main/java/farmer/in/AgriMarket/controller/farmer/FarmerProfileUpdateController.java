package farmer.in.AgriMarket.controller.farmer;

import farmer.in.AgriMarket.dto.farmer.FarmerProfileUpdateRequest;
import farmer.in.AgriMarket.service.farmer.FarmerProfileUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/farmerProfileUpdate")
public class FarmerProfileUpdateController {

    @Autowired
    private FarmerProfileUpdateService farmerProfileUpdateService;

    @PutMapping("/{farmerId}")
    ResponseEntity<Object> updateProfile(@PathVariable String farmerId, @RequestBody FarmerProfileUpdateRequest farmerProfileUpdateRequest){
        return new ResponseEntity<>(farmerProfileUpdateService.updateProfile(farmerId, farmerProfileUpdateRequest), HttpStatus.ACCEPTED);
    }
}
