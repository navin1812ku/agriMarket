package farmer.in.AgriMarket.controller.farmer;


import farmer.in.AgriMarket.dto.farmer.FarmerAddressUpdateRequest;
import farmer.in.AgriMarket.service.farmer.FarmerAddressUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/farmer/farmerAddressUpdate")
public class FarmerAddressUpdateController {

    @Autowired
    private FarmerAddressUpdateService farmerAddressUpdateService;

    @PutMapping("/{farmerId}")
    ResponseEntity<Object> addressUpdate(@PathVariable String farmerId, @RequestBody FarmerAddressUpdateRequest farmerAddressUpdateRequest){
        return new ResponseEntity<>(farmerAddressUpdateService.addressUpdate(farmerId, farmerAddressUpdateRequest), HttpStatus.ACCEPTED);
    }
}
